/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxInvoice", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDsParam",
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxInvoice$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.sd_account_dc_CustomerAccountCtxInvoice$Filter",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.bd.currency.lovs.Currencies", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "currencyId"} 
					]}})
			.addLov({xtype:"md_mm_price_lovs_PriceListSales", name:"priceList", dataIndex:"priceList", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.mm.price.lovs.PriceListSales", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "priceListId"} 
					]}})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesSI", name:"docType", dataIndex:"docType", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.base.tx.lovs.TxDocTypesSI", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "docTypeId"} 
					]}})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethod", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "paymentMethodId"} 
					]}})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"paymentTerm", dataIndex:"paymentTerm", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.base.tx.lovs.PaymentTerm", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "paymentTermId"} 
					]}})
			.addTextField({ name:"salesOrderCode", dataIndex:"salesOrderCode", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"confirmed", dataIndex:"confirmed", anchor:"-20"})
			.addBooleanField({ name:"posted", dataIndex:"posted", anchor:"-20"})
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxInvoice$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_account_dc_CustomerAccountCtxInvoice$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"supplierCode", dataIndex:"supplier", hidden:true, width:100})
			.addTextColumn({ name:"customerCode", dataIndex:"customerCode", hidden:true, width:100})
			.addTextColumn({ name:"customer", dataIndex:"customer", hidden:true, width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:60})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addBooleanColumn({ name:"posted", dataIndex:"posted"})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
