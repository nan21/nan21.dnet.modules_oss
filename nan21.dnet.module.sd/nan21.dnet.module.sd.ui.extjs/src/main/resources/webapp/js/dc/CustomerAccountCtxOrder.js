/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxOrder", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDsFilter",
	paramModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDsParam",
	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxOrder$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.sd_account_dc_CustomerAccountCtxOrder$Filter",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_DeliveryMethods", name:"deliveryMethod", dataIndex:"deliveryMethod", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.base.tx.lovs.DeliveryMethods", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "deliveryMethodId"} 
					]}})
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
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesSO", name:"docType", dataIndex:"docType", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.base.tx.lovs.TxDocTypesSO", selectOnFocus:true,
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
			.addLov({xtype:"bd_org_lovs_WarehouseOrganizations", name:"warehouse", dataIndex:"inventory", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.bd.org.lovs.WarehouseOrganizations", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "inventoryId"} 
					]}})
			.addBooleanField({ name:"confirmed", dataIndex:"confirmed", anchor:"-20"})
			.addBooleanField({ name:"invoiced", dataIndex:"invoiced", anchor:"-20"})
			.addBooleanField({ name:"delivered", dataIndex:"delivered", anchor:"-20"})
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxOrder$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_account_dc_CustomerAccountCtxOrder$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"supplierCode", dataIndex:"supplier", hidden:true, width:100})
			.addTextColumn({ name:"inventory", dataIndex:"inventory", hidden:true, width:100})
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:70})
			.addTextColumn({ name:"customerCode", dataIndex:"customerCode", hidden:true, width:100})
			.addTextColumn({ name:"customer", dataIndex:"customer", hidden:true, width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed", width:70})
			.addBooleanColumn({ name:"invoiced", dataIndex:"invoiced", hidden:true, width:70})
			.addBooleanColumn({ name:"delivered", dataIndex:"delivered", hidden:true, width:70})
			.addTextColumn({ name:"priceList", dataIndex:"priceList", width:120})
			.addTextColumn({ name:"deliveryMethod", dataIndex:"deliveryMethod", hidden:true, width:120})
			.addTextColumn({ name:"billTo", dataIndex:"billTo", hidden:true, width:200})
			.addTextColumn({ name:"billToCode", dataIndex:"billToCode", hidden:true, width:100})
			.addTextColumn({ name:"shipTo", dataIndex:"shipTo", hidden:true, width:200})
			.addTextColumn({ name:"shipToCode", dataIndex:"shipToCode", hidden:true, width:100})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"billToId", dataIndex:"billToId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"shipToId", dataIndex:"shipToId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"deliveryMethodId", dataIndex:"deliveryMethodId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"priceListId", dataIndex:"priceListId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
