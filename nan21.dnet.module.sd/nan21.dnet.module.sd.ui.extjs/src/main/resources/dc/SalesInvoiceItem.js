/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceItemDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: FilterCtx ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.sd_invoice_dc_SalesInvoiceItem$FilterCtx",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_mm_prod_lovs_Products", name:"productCode", dataIndex:"productCode", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.md.mm.prod.lovs.Products", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "productId"} 
					]}})
		;
	},

});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_invoice_dc_SalesInvoiceItem$CtxList",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"productCode", dataIndex:"productCode", width:100})
			.addTextColumn({ name:"productName", dataIndex:"productName", width:200})
			.addNumberColumn({ name:"quantity", dataIndex:"quantity", decimals:2})
			.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"uomCode", dataIndex:"uomCode", width:100})
			.addNumberColumn({ name:"netUnitPrice", dataIndex:"unitPrice", decimals:2})
			.addNumberColumn({ name:"netAmount", dataIndex:"netAmount", decimals:2})
			.addTextColumn({ name:"tax", dataIndex:"tax", hidden:true, width:120})
			.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount", decimals:2})
			.addNumberColumn({ name:"lineAmount", dataIndex:"lineAmount", decimals:2})
			.addNumberColumn({ name:"salesInvoiceId", dataIndex:"salesInvoiceId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"taxId", dataIndex:"taxId", hidden:true, width:70})
			.addDefaults();
	}});


/* ================= EDITOR: EditForm ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem$EditForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_invoice_dc_SalesInvoiceItem$EditForm",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_mm_prod_lovs_ProductsWithUom", name:"productCode", dataIndex:"productCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ,{lovField:"uom", dsField: "uomCode"} ,{lovField:"uomId", dsField: "uomId"} 
				]})
			.addHiddenField({ name:"productId", dataIndex:"productId", anchor:"-20",listeners:{
				change:{scope:this, fn:this.onProductChange}
			}
			})
			.addDisplayFieldText({ name:"productName", dataIndex:"productName", anchor:"-20"})
			.addNumberField({name:"quantity", dataIndex:"quantity", anchor:"-20",listeners:{
				change:{scope:this, fn:this.calcNetAmount}
			}
			})
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasure", name:"uomCode", dataIndex:"uomCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "uomId"} 
				]})
			.addNumberField({name:"unitPrice", dataIndex:"unitPrice", allowBlank:false, anchor:"-20",listeners:{
				change:{scope:this, fn:this.calcNetAmount}
			}
			})
			.addDisplayFieldNumber({ name:"netAmount", dataIndex:"netAmount", disabled:true , anchor:"-20" })
			.addDisplayFieldNumber({ name:"taxAmount", dataIndex:"taxAmount", disabled:true , anchor:"-20" })
			.addDisplayFieldNumber({ name:"lineAmount", dataIndex:"lineAmount", disabled:true , anchor:"-20" })
			.addLov({xtype:"md_base_tax_lovs_TaxApplicables", name:"tax", dataIndex:"tax", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "taxId"} 
				]})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true})
			.addPanel({ name:"row1", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col1", width:400, layout:"form"})
			.addPanel({ name:"col4", width:400, layout:"form"})
			.addPanel({ name:"row2", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["row1", "row2"])
			.addChildrenTo("row1", ["col1", "col4"])
			.addChildrenTo("col1", ["productId", "productCode", "productName"])
			.addChildrenTo("col4", ["description"])
			.addChildrenTo("row2", ["col2", "col3"])
			.addChildrenTo("col2", ["quantity", "uomCode", "unitPrice", "tax"])
			.addChildrenTo("col3", ["netAmount", "taxAmount", "lineAmount"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	onProductChange: function() {
		
				var r = this._controller_.record;
				r.beginEdit();
				r.set("unitPrice", 0);
				r.set("netAmount", 0);
				r.set("taxAmount", 0);
				if (!r.get("productId")) {
					return ;
				}
				r.endEdit();
				this._controller_.doService("onProductChange");
	},
	
	calcNetAmount: function() {
		
				var r = this._controller_.record;
				r.beginEdit();
				r.set("netAmount", r.get("unitPrice") * r.get("quantity"));
				r.set("taxAmount", "");
				r.endEdit(); ;
	}
});
