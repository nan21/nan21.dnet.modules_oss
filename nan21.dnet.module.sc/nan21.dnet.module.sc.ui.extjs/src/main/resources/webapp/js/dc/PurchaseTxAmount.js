/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseTxAmount", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseTxAmount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sc_invoice_dc_PurchaseTxAmount$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDateField({name:"dueDate", dataIndex:"dueDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addNumberField({name:"outstandingAmount", dataIndex:"outstandingAmount", anchor:"-20", decimals:2})
			.addNumberField({name:"payedAmount", dataIndex:"payedAmount", anchor:"-20", decimals:2})
			.addNumberField({name:"dueAmount", dataIndex:"dueAmount", anchor:"-20", decimals:2})
			.addTextField({ name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["paymentMethod"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseTxAmount$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_invoice_dc_PurchaseTxAmount$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"invoiceCode", dataIndex:"invoiceCode", width:80})
			.addDateColumn({ name:"invoiceDocDate", dataIndex:"invoiceDocDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"invoiceDocNo", dataIndex:"invoiceDocNo", width:80})
			.addDateColumn({ name:"dueDate", dataIndex:"dueDate", format: Dnet.DATE_FORMAT})
			.addNumberColumn({ name:"dueAmount", dataIndex:"dueAmount", decimals:2})
			.addNumberColumn({ name:"payedAmount", dataIndex:"payedAmount", decimals:2})
			.addNumberColumn({ name:"outstandingAmount", dataIndex:"outstandingAmount", decimals:2})
			.addTextColumn({ name:"paymentMethod", dataIndex:"paymentMethod", width:120})
			.addNumberColumn({ name:"invoiceId", dataIndex:"invoiceId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"orderId", dataIndex:"orderId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
