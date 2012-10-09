/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.Payment", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.PaymentDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.Payment$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_fin_dc_Payment$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"fromOrg", dataIndex:"fromOrg", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "fromOrgId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"toOrg", dataIndex:"toOrg", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "toOrgId"} 
				]})
			.addLov({xtype:"md_org_lovs_FinancialAccounts", name:"fromAccount", dataIndex:"fromAccount", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "fromAccountId"} 
				]})
			.addLov({xtype:"md_org_lovs_FinancialAccounts", name:"toAccount", dataIndex:"toAccount", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "toAccountId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"businessPartner", dataIndex:"businessPartner", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "businessPartnerId"} 
				]})
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
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:280, layout:"form"})
			.addPanel({ name:"col3", width:180, layout:"form"})
			.addPanel({ name:"col4", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["fromOrg", "toOrg", "docNo", "code"])
			.addChildrenTo("col2", ["fromAccount", "toAccount", "businessPartner", "paymentMethod"])
			.addChildrenTo("col3", ["currency", "confirmed", "posted"])
			.addChildrenTo("col4", ["docDate", "amount"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.Payment$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_fin_dc_Payment$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"fromOrg", dataIndex:"fromOrg", width:100})
			.addTextColumn({ name:"toOrg", dataIndex:"toOrg", width:100})
			.addTextColumn({ name:"businessPartner", dataIndex:"businessPartner", width:100})
			.addTextColumn({ name:"fromAccount", dataIndex:"fromAccount", width:120})
			.addTextColumn({ name:"toAccount", dataIndex:"toAccount", width:120})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:100})
			.addTextColumn({ name:"paymentMethod", dataIndex:"paymentMethod", width:80})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed", width:60})
			.addBooleanColumn({ name:"posted", dataIndex:"posted", width:60})
			.addNumberColumn({ name:"fromOrgId", dataIndex:"fromOrgId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"toOrgId", dataIndex:"toOrgId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"fromAccountId", dataIndex:"fromAccountId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"toAccountId", dataIndex:"toAccountId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"businessPartnerd", dataIndex:"businessPartnerId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
