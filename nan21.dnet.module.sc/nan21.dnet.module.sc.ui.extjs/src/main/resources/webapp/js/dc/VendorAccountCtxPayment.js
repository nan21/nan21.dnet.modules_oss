/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxPayment", {
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


Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxPayment$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.sc_account_dc_VendorAccountCtxPayment$Filter",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", width:80, maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", width:80})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.bd.currency.lovs.Currencies", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "currencyId"} 
					]}})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethodOut", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethodOut", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "paymentMethodId"} 
					]}})
			.addLov({xtype:"md_org_lovs_FinancialAccounts", name:"fromAccount", dataIndex:"fromAccount", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.org.lovs.FinancialAccounts", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "fromAccountId"} 
					]}})
			.addBooleanField({ name:"confirmed", dataIndex:"confirmed", anchor:"-20"})
			.addBooleanField({ name:"posted", dataIndex:"posted", anchor:"-20"})
		;
	},

});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxPayment$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_account_dc_VendorAccountCtxPayment$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode", hidden:true, width:100})
			.addTextColumn({ name:"bpartner", dataIndex:"bpartner", hidden:true, width:200})
			.addTextColumn({ name:"org", dataIndex:"org", hidden:true, width:100})
			.addTextColumn({ name:"fromAccount", dataIndex:"fromAccount", width:120})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:100})
			.addTextColumn({ name:"paymentMethod", dataIndex:"paymentMethod", width:120})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addBooleanColumn({ name:"posted", dataIndex:"posted"})
			.addNumberColumn({ name:"bpartnerId", dataIndex:"bpartnerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
