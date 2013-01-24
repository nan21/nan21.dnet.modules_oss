/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxOrder", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDsFilter",
	paramModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDsParam",
	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxOrder$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.sc_account_dc_VendorAccountCtxOrder$Filter",

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
			.addLov({xtype:"md_mm_price_lovs_PriceListPurchase", name:"priceList", dataIndex:"priceList", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.mm.price.lovs.PriceListPurchase", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "priceListId"} 
					]}})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.bd.currency.lovs.Currencies", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "currencyId"} 
					]}})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesPO", name:"docType", dataIndex:"docType", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.base.tx.lovs.TxDocTypesPO", selectOnFocus:true,
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
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxOrder$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_account_dc_VendorAccountCtxOrder$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"customer", dataIndex:"customer", hidden:true, width:100})
			.addTextColumn({ name:"inventory", dataIndex:"inventory", hidden:true, width:100})
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:70})
			.addTextColumn({ name:"supplierCode", dataIndex:"supplier", hidden:true, width:200})
			.addTextColumn({ name:"supplier", dataIndex:"supplier", hidden:true, width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"deliveryMethodId", dataIndex:"deliveryMethodId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"deliveryMethod", dataIndex:"deliveryMethod", hidden:true, width:120})
			.addDefaults();
	}
});
