/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItemTax", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemTaxDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemTaxDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceItemTaxDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItemTax$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_invoice_dc_PurchaseInvoiceItemTax$CtxList",
	_noImport_: true,
	_noExport_: true,
	_noPrint_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"tax", dataIndex:"tax", width:120})
			.addNumberColumn({ name:"baseAmount", dataIndex:"baseAmount", decimals:2})
			.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount", decimals:2})
			.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"purchaseInvoiceItemId", dataIndex:"purchaseInvoiceItemId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
