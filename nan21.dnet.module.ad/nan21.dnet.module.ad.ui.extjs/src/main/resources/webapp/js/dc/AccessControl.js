/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.AccessControlDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.AccessControlDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.AccessControlDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_usr_dc_AccessControl$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"ad_usr_lovs_Roles", name:"withRole", paramIndex:"withRole", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "withRoleId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "withRole"])
			.addChildrenTo("col2", ["active"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_usr_dc_AccessControl$EditList",
	_bulkEditFields_: ["active","description"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:300,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});


/* ================= EDITOR: CopyRulesFromSource ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl$CopyRulesFromSource", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_usr_dc_AccessControl$CopyRulesFromSource",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"ad_usr_lovs_AccessControls", name:"copyFrom", paramIndex:"copyFrom", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "copyFromId"} 
				]})
			.addBooleanField({ name:"skipDs", paramIndex:"skipDs", anchor:"-20"})
			.addBooleanField({ name:"skipAsgn", paramIndex:"skipAsgn", anchor:"-20"})
			.addBooleanField({ name:"resetRules", paramIndex:"resetRules", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["copyFrom", "skipDs", "skipAsgn", "resetRules"])
		;
	}});
