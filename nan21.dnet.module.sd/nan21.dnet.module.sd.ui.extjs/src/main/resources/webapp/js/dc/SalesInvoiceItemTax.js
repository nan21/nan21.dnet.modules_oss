/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItemTax", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemTaxDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemTaxDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItemTax$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_invoice_dc_SalesInvoiceItemTax$CtxList",
	_noImport_: true,
	_noExport_: true,
	_noPrint_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"tax", dataIndex:"tax", width:120})
			.addNumberColumn({ name:"baseAmount", dataIndex:"baseAmount", decimals:2})
			.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount", decimals:2})
			.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"salesInvoiceItemId", dataIndex:"salesInvoiceItemId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
