/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxInvoice", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDsParam",
	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxInvoice$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.sc_account_dc_VendorAccountCtxInvoice$Filter",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesPI", name:"docType", dataIndex:"docType", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.base.tx.lovs.TxDocTypesPI", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "docTypeId"} 
					]}})
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
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"paymentTerm", dataIndex:"paymentTerm", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.base.tx.lovs.PaymentTerm", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "paymentTermId"} 
					]}})
			.addBooleanField({ name:"confirmed", dataIndex:"confirmed", anchor:"-20"})
			.addBooleanField({ name:"posted", dataIndex:"posted", anchor:"-20"})
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxInvoice$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_account_dc_VendorAccountCtxInvoice$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:70})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"customer", dataIndex:"customer", hidden:true, width:100})
			.addTextColumn({ name:"supplierCode", dataIndex:"supplierCode", hidden:true, width:100})
			.addTextColumn({ name:"supplier", dataIndex:"supplier", hidden:true, width:200})
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
	}
});
