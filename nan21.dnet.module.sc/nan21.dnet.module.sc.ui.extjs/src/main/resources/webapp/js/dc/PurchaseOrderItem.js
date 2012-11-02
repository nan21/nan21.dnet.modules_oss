/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderItemDs",
	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderItemDsFilter",
	paramModel: "net.nan21.dnet.module.sc.order.ds.param.PurchaseOrderItemDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: FilterCtx ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.sc_order_dc_PurchaseOrderItem$FilterCtx",

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


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.sc_order_dc_PurchaseOrderItem$CtxEditList",
	_noImport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"productCode", dataIndex:"productCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_mm_prod_lovs_Products", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} 
						]}})
			.addTextColumn({name:"productName", dataIndex:"productName", width:200})
			.addNumberColumn({name:"quantity", dataIndex:"quantity", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"uomId", dataIndex:"uomId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"uomCode", dataIndex:"uomCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasure", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "uomId"} 
						]}})
			.addNumberColumn({name:"unitPrice", dataIndex:"unitPrice", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"netAmount", dataIndex:"netAmount", align:"right", decimals:2})
			.addNumberColumn({name:"purchaseOrderId", dataIndex:"purchaseOrderId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"productId", dataIndex:"productId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_order_dc_PurchaseOrderItem$CtxList",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"productCode", dataIndex:"productCode", width:100})
			.addTextColumn({ name:"productName", dataIndex:"productName", width:200})
			.addNumberColumn({ name:"quantity", dataIndex:"quantity", decimals:2})
			.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"uomCode", dataIndex:"uomCode", width:100})
			.addNumberColumn({ name:"unitPrice", dataIndex:"unitPrice", decimals:2})
			.addNumberColumn({ name:"netAmount", dataIndex:"netAmount", decimals:2})
			.addTextColumn({ name:"tax", dataIndex:"tax", hidden:true, width:120})
			.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount", decimals:2})
			.addNumberColumn({ name:"lineAmount", dataIndex:"lineAmount", decimals:2})
			.addNumberColumn({ name:"purchaseOrderId", dataIndex:"purchaseOrderId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"taxId", dataIndex:"taxId", hidden:true, width:70})
			.addDefaults();
	}});


/* ================= EDITOR: EditForm ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$EditForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sc_order_dc_PurchaseOrderItem$EditForm",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addHiddenField({ name:"productId", dataIndex:"productId", anchor:"-20",listeners:{
				change:{scope:this, fn:this.onProductChange}
			}
			})
			.addLov({xtype:"md_mm_prod_lovs_ProductsWithUom", name:"productCode", dataIndex:"productCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ,{lovField:"uom", dsField: "uomCode"} ,{lovField:"uomId", dsField: "uomId"} 
				]})
			.addDisplayFieldText({ name:"productName", dataIndex:"productName", anchor:"-20"})
			.addNumberField({name:"quantity", dataIndex:"quantity", allowBlank:false, anchor:"-20", decimals:2,listeners:{
				change:{scope:this, fn:this.calcNetAmount}
			}
			})
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasure", name:"uomCode", dataIndex:"uomCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "uomId"} 
				]})
			.addLov({xtype:"md_base_tax_lovs_TaxApplicables", name:"tax", dataIndex:"tax", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "taxId"} 
				]})
			.addNumberField({name:"unitPrice", dataIndex:"unitPrice", allowBlank:false, anchor:"-20", decimals:2,listeners:{
				change:{scope:this, fn:this.calcNetAmount}
			}
			})
			.addDisplayFieldNumber({ name:"netAmount", dataIndex:"netAmount", disabled:true , anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldNumber({ name:"taxAmount", dataIndex:"taxAmount", disabled:true , anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldNumber({ name:"lineAmount", dataIndex:"lineAmount", disabled:true , anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
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
