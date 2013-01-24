/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderTax", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderTaxDs"
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderTax$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_order_dc_PurchaseOrderTax$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"tax", dataIndex:"tax", width:120})
			.addNumberColumn({ name:"baseAmount", dataIndex:"baseAmount", decimals:2})
			.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount", decimals:2})
			.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"purchaseOrderId", dataIndex:"purchaseOrderId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
