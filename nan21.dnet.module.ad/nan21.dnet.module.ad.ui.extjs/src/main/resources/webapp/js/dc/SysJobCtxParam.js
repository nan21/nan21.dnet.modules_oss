/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.system.dc.SysJobCtxParam", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysJobCtxParamDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysJobCtxParamDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysJobCtxParamDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysJobCtxParam$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_system_dc_SysJobCtxParam$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"jobParam", dataIndex:"jobParam", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"dataType", dataIndex:"dataType", width:150})
			.addDefaults();
	}});
