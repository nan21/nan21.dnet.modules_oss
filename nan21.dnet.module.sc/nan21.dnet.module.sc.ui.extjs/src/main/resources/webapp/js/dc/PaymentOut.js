/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOut", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PaymentOutDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOut$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sc_invoice_dc_PaymentOut$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"bpartner", dataIndex:"bpartner", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "bpartnerId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethodOut", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			.addLov({xtype:"md_org_lovs_FinancialAccounts", name:"fromAccount", dataIndex:"fromAccount", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "fromAccountId"} 
				]})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addDateField({name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
			.addDateField({name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
			.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"})
				.addChildrenTo("docDate",["docDate_From", "docDate_To"])
			.addNumberField({name:"amount_From", dataIndex:"amount_From", emptyText:"From" })
			.addNumberField({name:"amount_To", dataIndex:"amount_To", emptyText:"To" })
			.addFieldContainer({name: "amount", fieldLabel:"Amount"})
				.addChildrenTo("amount",["amount_From", "amount_To"])
			.addBooleanField({ name:"confirmed", dataIndex:"confirmed", anchor:"-20"})
			.addBooleanField({ name:"posted", dataIndex:"posted", anchor:"-20"})
			.addBooleanField({ name:"generated", dataIndex:"generated", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
			.addPanel({ name:"col4", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["bpartner", "org", "paymentMethod", "fromAccount"])
			.addChildrenTo("col2", ["docNo", "code", "currency"])
			.addChildrenTo("col3", ["docDate", "amount"])
			.addChildrenTo("col4", ["generated", "confirmed", "posted"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOut$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_invoice_dc_PaymentOut$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode", width:100})
			.addTextColumn({ name:"bpartner", dataIndex:"bpartner", width:200})
			.addTextColumn({ name:"org", dataIndex:"org", width:100})
			.addTextColumn({ name:"fromAccount", dataIndex:"fromAccount", width:120})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:100})
			.addTextColumn({ name:"paymentMethod", dataIndex:"paymentMethod", width:120})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addBooleanColumn({ name:"generated", dataIndex:"generated"})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addBooleanColumn({ name:"posted", dataIndex:"posted"})
			.addNumberColumn({ name:"bpartnerId", dataIndex:"bpartnerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOut$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sc_invoice_dc_PaymentOut$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addDateField({name:"docDate", dataIndex:"docDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"md_bp_lovs_VendorsName", name:"bpartner", dataIndex:"bpartner", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"bpartnerId", dsField: "bpartnerId"} 
				]})
			.addLov({xtype:"md_org_lovs_FinancialAccounts", name:"fromAccount", dataIndex:"fromAccount", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "fromAccountId"} 
				],
				filterFieldMapping: [
					{lovField:"currencyId",dsField: "currencyId"}, {lovField:"type",dsField: "paymentMethodType"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethodOut", name:"paymentMethod", dataIndex:"paymentMethod", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} ,{lovField:"type", dsField: "paymentMethodType"} 
				]})
			.addNumberField({name:"amount", dataIndex:"amount", allowBlank:false, anchor:"-20", decimals:2})
			.addDisplayFieldBoolean({ name:"generated", dataIndex:"generated", anchor:"-20" })
			.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed", anchor:"-20" })
			.addDisplayFieldBoolean({ name:"posted", dataIndex:"posted", anchor:"-20" })
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:280, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
			.addPanel({ name:"col4", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["org", "bpartner", "amount", "currency"])
			.addChildrenTo("col2", ["docDate", "docNo", "code"])
			.addChildrenTo("col3", ["paymentMethod", "fromAccount"])
			.addChildrenTo("col4", ["generated", "confirmed", "posted"])
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
