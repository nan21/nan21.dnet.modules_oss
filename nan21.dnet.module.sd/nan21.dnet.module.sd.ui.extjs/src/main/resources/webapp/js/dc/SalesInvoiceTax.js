/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceTax", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceTaxDs"
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceTax$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_invoice_dc_SalesInvoiceTax$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"tax", dataIndex:"tax", width:120})
			.addNumberColumn({ name:"baseAmount", dataIndex:"baseAmount", decimals:2})
			.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount", decimals:2})
			.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"salesInvoiceId", dataIndex:"salesInvoiceId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
