/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOutAmount", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutAmountDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutAmountDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOutAmount$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_invoice_dc_PaymentOutAmount$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"invoiceCode", dataIndex:"invoiceCode", width:80})
			.addTextColumn({ name:"invoiceDocNo", dataIndex:"invoiceDocNo", width:80})
			.addDateColumn({ name:"invoiceDocDate", dataIndex:"invoiceDocDate", format: Dnet.DATE_FORMAT})
			.addNumberColumn({ name:"dueAmount", dataIndex:"dueAmount", decimals:2})
			.addNumberColumn({ name:"payedAmount", dataIndex:"payedAmount", decimals:2})
			.addNumberColumn({ name:"outstandingAmount", dataIndex:"outstandingAmount", decimals:2})
			.addNumberColumn({ name:"currentPayment", dataIndex:"currentPayment", decimals:2})
			.addNumberColumn({ name:"paymentId", dataIndex:"paymentId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"txAmountId", dataIndex:"txAmountId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
