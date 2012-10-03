/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.system.dc.SysDsField", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDsFieldDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysDsFieldDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysDsFieldDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_system_dc_SysDsField$CtxList",
	_noImport_: true,
	_noExport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"dataType", dataIndex:"dataType", width:150})
			.addDefaults();
	}});
