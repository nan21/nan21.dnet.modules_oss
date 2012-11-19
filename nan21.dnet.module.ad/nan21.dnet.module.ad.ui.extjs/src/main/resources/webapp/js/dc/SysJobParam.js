/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.system.dc.SysJobParam", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysJobParamDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysJobParamDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysJobParamDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= E-GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysJobParam$CtxList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_system_dc_SysJobParam$CtxList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"dataType", dataIndex:"dataType", width:150,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}});
