/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderTax", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderTaxDs",
	filterModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderTaxDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderTax$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_order_dc_SalesOrderTax$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"tax", dataIndex:"tax", width:120})
			.addNumberColumn({ name:"baseAmount", dataIndex:"baseAmount", decimals:2})
			.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount", decimals:2})
			.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
