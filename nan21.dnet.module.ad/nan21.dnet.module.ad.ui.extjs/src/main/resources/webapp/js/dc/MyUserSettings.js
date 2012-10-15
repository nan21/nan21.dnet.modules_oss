/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.usr.dc.MyUserSettings", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.MyUserSettingsDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.MyUserSettingsDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.MyUserSettingsDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.MyUserSettings$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_usr_dc_MyUserSettings$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextField({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"decimalSeparator", dataIndex:"decimalSeparator", anchor:"-20",
				store:[ ".", ","]
			})
			.addCombo({ xtype:"combo", name:"thousandSeparator", dataIndex:"thousandSeparator", anchor:"-20",
				store:[ ".", ","]
			})
			.addLov({xtype:"ad_system_lovs_SysDateFormats", name:"dateFormat", dataIndex:"dateFormat", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "dateFormatId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", title:"Regional settings", width:300, layout:"form", xtype:"fieldset", border:true, collapsible:false})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["dateFormat", "decimalSeparator", "thousandSeparator"])
		;
	}});
