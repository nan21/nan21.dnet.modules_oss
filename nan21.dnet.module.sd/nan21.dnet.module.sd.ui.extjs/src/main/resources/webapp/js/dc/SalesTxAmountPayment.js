/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmountPayment", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountPaymentDs"
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmountPayment$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_invoice_dc_SalesTxAmountPayment$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"paymentCode", dataIndex:"paymentCode", width:100})
			.addTextColumn({ name:"paymentDocNo", dataIndex:"paymentDocNo", width:80})
			.addDateColumn({ name:"paymentDocDate", dataIndex:"paymentDocDate", format: Dnet.DATE_FORMAT})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addNumberColumn({ name:"paymentId", dataIndex:"paymentId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"txAmountId", dataIndex:"txAmountId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
