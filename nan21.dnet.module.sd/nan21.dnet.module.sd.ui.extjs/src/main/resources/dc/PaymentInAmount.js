/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.invoice.dc.PaymentInAmount", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.PaymentInAmountDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.PaymentInAmountDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.PaymentInAmountDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.PaymentInAmount$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.sd_invoice_dc_PaymentInAmount$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"invoiceCode", dataIndex:"invoiceCode", width:100})
			.addTextColumn({name:"invoiceDocNo", dataIndex:"invoiceDocNo", width:200})
			.addDateColumn({name:"invoiceDocDate", dataIndex:"invoiceDocDate", format: Dnet.DATE_FORMAT
			})
			.addNumberColumn({name:"expectedAmount", dataIndex:"expectedAmount", align:"right", decimals:2})
			.addNumberColumn({name:"payedAmount", dataIndex:"payedAmount", align:"right", decimals:2})
			.addNumberColumn({name:"dueAmount", dataIndex:"dueAmount", align:"right", decimals:2})
			.addNumberColumn({name:"amount", dataIndex:"amount", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"paymentId", dataIndex:"paymentId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"txAmountId", dataIndex:"txAmountId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
