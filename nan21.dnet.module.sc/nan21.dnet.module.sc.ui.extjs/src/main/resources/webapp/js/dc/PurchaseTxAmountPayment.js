/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseTxAmountPayment", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountPaymentDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountPaymentDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PurchaseTxAmountPaymentDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseTxAmountPayment$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_invoice_dc_PurchaseTxAmountPayment$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"paymentCode", dataIndex:"paymentCode", width:100})
			.addTextColumn({ name:"paymentDocNo", dataIndex:"paymentDocNo", width:200})
			.addDateColumn({ name:"paymentDocDate", dataIndex:"paymentDocDate", format: Dnet.DATE_FORMAT})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addNumberColumn({ name:"paymentId", dataIndex:"paymentId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"txAmountId", dataIndex:"txAmountId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
