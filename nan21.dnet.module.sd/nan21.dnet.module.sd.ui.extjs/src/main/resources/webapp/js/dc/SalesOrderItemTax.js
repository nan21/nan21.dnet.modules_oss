/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItemTax", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemTaxDs"
});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItemTax$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_order_dc_SalesOrderItemTax$CtxList",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"tax", dataIndex:"tax", width:120})
			.addNumberColumn({ name:"baseAmount", dataIndex:"baseAmount", decimals:2})
			.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount", decimals:2})
			.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"salesOrderItemId", dataIndex:"salesOrderItemId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
