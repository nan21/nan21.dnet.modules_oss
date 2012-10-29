/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/dc/UserType", "nan21.dnet.module.ad.ui.extjs/ds/UserTypeDs"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.UserTypes_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.frame.UserTypes_UI",
	_name_: "net.nan21.dnet.module.ad.usr.frame.UserTypes_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("userType", new net.nan21.dnet.module.ad.usr.dc.UserType({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("userType", {name:"filterUserType", height:80, xtype:"ad_usr_dc_UserType$Filter"})
			.addDcEditGridView("userType", {name:"listUserType", xtype:"ad_usr_dc_UserType$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["filterUserType", "listUserType"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbGroupEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbGroupEditList", {dc: "userType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "User types"})
			.end()
	}

});
