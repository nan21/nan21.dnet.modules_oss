/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceItemDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: FilterCtx ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.sc_invoice_dc_PurchaseInvoiceItem$FilterCtx",

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


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_invoice_dc_PurchaseInvoiceItem$CtxList",
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
			.addNumberColumn({ name:"purchaseInvoiceId", dataIndex:"purchaseInvoiceId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"taxId", dataIndex:"taxId", hidden:true, width:70})
			.addDefaults();
	}});


/* ================= EDITOR: EditForm ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem$EditForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sc_invoice_dc_PurchaseInvoiceItem$EditForm",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_mm_prod_lovs_ProductsWithUom", name:"productCode", dataIndex:"productCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ,{lovField:"uom", dsField: "uomCode"} ,{lovField:"uomId", dsField: "uomId"} 
				]})
			.addDisplayFieldText({ name:"productName", dataIndex:"productName", anchor:"-20"})
			.addNumberField({name:"quantity", dataIndex:"quantity", allowBlank:false, anchor:"-20"})
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasure", name:"uomCode", dataIndex:"uomCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "uomId"} 
				]})
			.addCombo({ xtype:"combo", name:"entryMode", dataIndex:"entryMode", anchor:"-20",
				store:[ "price", "amount"]
			,listeners:{
				change:{scope:this, fn:this._onEntryModeChange_}
			}
			})
			.addNumberField({name:"unitPrice", dataIndex:"unitPrice", anchor:"-20",listeners:{
				change:{scope:this, fn:this.calcNetAmount}
			}
			})
			.addNumberField({name:"docLineNetAmount", dataIndex:"netAmount", anchor:"-20"})
			.addNumberField({name:"docLineTaxAmount", dataIndex:"taxAmount", anchor:"-20"})
			.addNumberField({name:"docLineAmount", dataIndex:"lineAmount", anchor:"-20"})
			.addDisplayFieldNumber({ name:"netAmount", dataIndex:"netAmount", disabled:true , anchor:"-20" })
			.addDisplayFieldNumber({ name:"taxAmount", dataIndex:"taxAmount", disabled:true , anchor:"-20" })
			.addDisplayFieldNumber({ name:"lineAmount", dataIndex:"lineAmount", disabled:true , anchor:"-20" })
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addLov({xtype:"md_base_tax_lovs_TaxApplicables", name:"tax", dataIndex:"tax", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "taxId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true})
			.addPanel({ name:"row1", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col1", width:400, layout:"form"})
			.addPanel({ name:"col5", width:400, layout:"form"})
			.addPanel({ name:"row2", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col3", width:250, layout:"form"})
			.addPanel({ name:"col4", width:250, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["row1", "row2"])
			.addChildrenTo("row1", ["col1", "col5"])
			.addChildrenTo("col1", ["productCode", "productName", "entryMode"])
			.addChildrenTo("col5", ["description"])
			.addChildrenTo("row2", ["col3", "col4", "col2"])
			.addChildrenTo("col3", ["quantity", "uomCode", "tax"])
			.addChildrenTo("col4", ["unitPrice", "docLineNetAmount", "docLineTaxAmount", "docLineAmount"])
			.addChildrenTo("col2", ["netAmount", "taxAmount", "lineAmount"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	calcNetAmount: function() {
		
				var r = this._controller_.record, mode=r.data.entryMode;
				
				if (mode == "price") {
					//r.beginEdit();
					r.set("netAmount", r.get("unitPrice")||0 * r.get("quantity")||0);
					r.set("taxAmount", "");
					r.set("lineAmount", "");
					//r.endEdit();
					return;
				};
	},
	
	_onNetAmountChange_: function() {
			
					var r = this._getController_().getRecord();		 	  
					r.set("taxAmount", "");	
					r.set("lineAmount", "");
					r.set("unitPrice", r.get("netAmount")||0 / r.get("quantity")||0);			  
				;
	},
	
	_onTaxAmountChange_: function() {
				
					var r = this._getController_().getRecord();		   			
					r.set("lineAmount", "");			  
				;
	},
	
	_onLineAmountChange_: function() {
		
					var r = this._getController_().getRecord();		  			
					r.set("netAmount", "");	
					r.set("taxAmount", "");		  
				;
	},
	
	_onEntryModeChange_: function() {
		var r = this._getController_().getRecord(), mode=r.data.entryMode;
				this._doEnableEntryFields_(mode);
				r.beginEdit();
				r.set("unitPrice", "");		
				r.set("netAmount", "");
				r.set("taxAmount", "");
				r.set("lineAmount", "");
				r.endEdit();
				;
	},
	
	_doEnableEntryFields_: function(mode) {
		
				if (mode == "price") {
					this._getElement_("unitPrice").enable();
					this._getElement_("docLineNetAmount").disable();
					this._getElement_("docLineTaxAmount").disable();
					this._getElement_("docLineAmount").disable();
					return;
				}  
				if (mode == "amount") {
					this._getElement_("unitPrice").disable();
					this._getElement_("docLineNetAmount").enable();
					this._getElement_("docLineTaxAmount").enable();
					this._getElement_("docLineAmount").enable();
					return;
				}
				 
				;
	},
	
	_afterBind_: function(record) {
		if (record) {
					this._doEnableEntryFields_(record.data.entryMode);
				};
	}
});
