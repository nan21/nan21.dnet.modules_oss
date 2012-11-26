/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sc_invoice_dc_PurchaseInvoice$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesPI", name:"docType", dataIndex:"docType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "docTypeId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethodOut", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"paymentTerm", dataIndex:"paymentTerm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentTermId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"customer", dataIndex:"customer", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "customerId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"supplier", dataIndex:"supplier", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
				]})
			.addBooleanField({ name:"confirmed", dataIndex:"confirmed", anchor:"-20"})
			.addBooleanField({ name:"posted", dataIndex:"posted", anchor:"-20"})
			.addDateField({name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
			.addDateField({name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
			.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"})
				.addChildrenTo("docDate",["docDate_From", "docDate_To"])
			.addNumberField({name:"totalAmount_From", dataIndex:"totalAmount_From", emptyText:"From" })
			.addNumberField({name:"totalAmount_To", dataIndex:"totalAmount_To", emptyText:"To" })
			.addFieldContainer({name: "totalAmount", fieldLabel:"Total Amount"})
				.addChildrenTo("totalAmount",["totalAmount_From", "totalAmount_To"])
			.addNumberField({name:"totalNetAmount_From", dataIndex:"totalNetAmount_From", emptyText:"From" })
			.addNumberField({name:"totalNetAmount_To", dataIndex:"totalNetAmount_To", emptyText:"To" })
			.addFieldContainer({name: "totalNetAmount", fieldLabel:"Total Net Amount"})
				.addChildrenTo("totalNetAmount",["totalNetAmount_From", "totalNetAmount_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:200, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
			.addPanel({ name:"col4", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["customer", "supplier", "docType"])
			.addChildrenTo("col2", ["code", "docNo", "currency"])
			.addChildrenTo("col3", ["docDate", "totalAmount", "totalNetAmount"])
			.addChildrenTo("col4", ["confirmed", "posted"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_invoice_dc_PurchaseInvoice$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:70})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"customer", dataIndex:"customer", width:100})
			.addTextColumn({ name:"supplierCode", dataIndex:"supplierCode", hidden:true, width:100})
			.addTextColumn({ name:"supplier", dataIndex:"supplier", width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:60})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addBooleanColumn({ name:"posted", dataIndex:"posted"})
			.addNumberColumn({ name:"purchaseOrderId", dataIndex:"purchaseOrderId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: CopyLinesForm ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$CopyLinesForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sc_invoice_dc_PurchaseInvoice$CopyLinesForm",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"sc_invoice_lovs_PurchaseInvoice", name:"copyFrom", paramIndex:"copyFrom", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "copyFromId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["copyFrom"])
		;
	}});


/* ================= EDITOR: EditMain ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$EditMain", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sc_invoice_dc_PurchaseInvoice$EditMain",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addDateField({name:"docDate", dataIndex:"docDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesPI", name:"docType", dataIndex:"docType", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "docTypeId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"customer", dataIndex:"customer", noUpdate:true, allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "customerId"} 
				]})
			.addLov({xtype:"md_bp_lovs_VendorsName", name:"supplier", dataIndex:"supplier", noUpdate:true, allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"bpartnerId", dsField: "supplierId"} 
				],
				filterFieldMapping: [
					{lovField:"orgId",dsField: "customerId"} 
				]})
			.addDisplayFieldNumber({ name:"totalNetAmount", dataIndex:"totalNetAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldNumber({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldNumber({ name:"totalAmount", dataIndex:"totalAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed", anchor:"-20" })
			.addDisplayFieldBoolean({ name:"posted", dataIndex:"posted", anchor:"-20" })
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:200, layout:"form"})
			.addPanel({ name:"col3", width:220, layout:"form"})
			.addPanel({ name:"col4", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["customer", "supplier", "docType", "currency"])
			.addChildrenTo("col2", ["docDate", "docNo", "code"])
			.addChildrenTo("col3", ["totalNetAmount", "totalTaxAmount", "totalAmount"])
			.addChildrenTo("col4", ["confirmed", "posted"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_beforeApplyStates_: function(record) {
		
					if (record.get("confirmed") || record.get("posted") ) {
						this._disableAllFields_();
						return false;
					}
	},
	
	_endDefine_: function() {
		
					this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
					 	this._applyStates_(dc.record);
					 } , this )
	}
});


/* ================= EDITOR: EditDetails ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$EditDetails", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sc_invoice_dc_PurchaseInvoice$EditDetails",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addBooleanField({ name:"selfPayed", dataIndex:"selfPayed", anchor:"-20",listeners:{
				change:{scope:this, fn:this._onSelfPayedChange_}
			}
			})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethodOut", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"paymentTerm", dataIndex:"paymentTerm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentTermId"} 
				]})
			.addLov({xtype:"md_org_lovs_FinancialAccounts", name:"fromAccount", dataIndex:"fromAccount", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "fromAccountId"} 
				],
				filterFieldMapping: [
					{lovField:"currencyId",dsField: "currencyId"}, {lovField:"type",value: "cash"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1"})
			.addPanel({ name:"col2", width:400, layout:"form"})
			.addPanel({ name:"panelPayment", title:"Payment", width:350, layout:"form", xtype:"fieldset", border:true, collapsible:true})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["panelPayment"])
			.addChildrenTo("col2", ["description"])
			.addChildrenTo("panelPayment", ["selfPayed", "fromAccount", "paymentMethod", "paymentTerm"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_beforeApplyStates_: function(record) {
		
					if (record.get("confirmed") || record.get("posted") ) {
						this._disableAllFields_();
						return false;
					}
	},
	
	_endDefine_: function() {
		
					this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
					 	this._applyStates_(dc.record);
					 } , this )
	},
	
	_onSelfPayedChange_: function() {
		var r = this._getController_().getRecord();
				if (!r.get("selfPayed")) {			 
		            r.set("fromAccountId", "");
		            r.set("fromAccount", "");            
				}
				this._doEnableFromAccount_(r.data.selfPayed);
	},
	
	_doEnableFromAccount_: function(enable) {
		if (enable) {
					this._getElement_("fromAccount").enable();
					this._getElement_("paymentMethod").disable();
					this._getElement_("paymentTerm").disable();
				} else {
					this._getElement_("fromAccount").disable();	
					this._getElement_("paymentMethod").enable();
					this._getElement_("paymentTerm").enable();		 
				}
	},
	
	_afterBind_: function(record) {
		if (record) {
					this._doEnableFromAccount_(record.data.selfPayed);
				}
	}
});
