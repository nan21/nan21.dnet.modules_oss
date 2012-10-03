/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.usr.dc.User", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.UserDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.UserDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.UserDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.User$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_usr_dc_User$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addLov({xtype:"ad_usr_lovs_UserTypes", name:"accountType", dataIndex:"accountType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "accountTypeId"} 
				]})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"locked", dataIndex:"locked", anchor:"-20"})
			.addLov({xtype:"ad_usr_lovs_Roles", name:"withRole", paramIndex:"withRole", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "withRoleId"} 
				]})
			.addLov({xtype:"ad_usr_lovs_UserGroups", name:"inGroup", paramIndex:"inGroup", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "inGroupId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["accountType", "withRole", "inGroup"])
			.addChildrenTo("col3", ["active", "locked"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.User$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_usr_dc_User$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addBooleanColumn({ name:"locked", dataIndex:"locked"})
			.addTextColumn({ name:"accountType", dataIndex:"accountType", width:120})
			.addTextColumn({ name:"decimalSeparator", dataIndex:"decimalSeparator", hidden:true, width:50})
			.addTextColumn({ name:"thousandSeparator", dataIndex:"thousandSeparator", hidden:true, width:50})
			.addTextColumn({ name:"dateFormat", dataIndex:"dateFormat", hidden:true, width:120})
			.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.User$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_usr_dc_User$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", allowBlank:false, anchor:"-20", maxLength:32})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addLov({xtype:"ad_usr_lovs_UserTypes", name:"accountType", dataIndex:"accountType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "accountTypeId"} 
				]})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"locked", dataIndex:"locked", anchor:"-20"})
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
			.addPanel({ name:"col1", width:350, layout:"form"})
			.addPanel({ name:"col2",title:"Regional settings", width:280, layout:"form", xtype:"fieldset", border:true, collapsible:false})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "code", "accountType", "notes", "active", "locked"])
			.addChildrenTo("col2", ["dateFormat", "decimalSeparator", "thousandSeparator"])
		;
	}});


/* ================= EDITOR: ChangePasswordForm ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.User$ChangePasswordForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_usr_dc_User$ChangePasswordForm",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"newPassword", paramIndex:"newPassword", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"confirmPassword", paramIndex:"confirmPassword", allowBlank:false, anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, width:350, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["newPassword", "confirmPassword"])
		;
	}});
