/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/dc/AsgnAccessControl", "nan21.dnet.module.ad.ui.extjs/ds/AccessControlLovDs", "nan21.dnet.module.ad.ui.extjs/lov/SysDataSourceAsgn", "nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceAsgnLovDs", "nan21.dnet.module.ad.ui.extjs/lov/AccessControls", "nan21.dnet.module.ad.ui.extjs/ds/AsgnAccessControlDs"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.AsgnAccessControl_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.frame.AsgnAccessControl_UI",
	_name_: "net.nan21.dnet.module.ad.usr.frame.AsgnAccessControl_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("asgnAccess", new net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("asgnAccess", {name:"asgnAccessFilter", height:80, xtype:"ad_usr_dc_AsgnAccessControl$Filter"})	
			.addDcEditGridView("asgnAccess", {name:"asgnAccessEditList", xtype:"ad_usr_dc_AsgnAccessControl$EditList", frame:true})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["asgnAccessFilter", "asgnAccessEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbAsgnAccessEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAsgnAccessEditList", {dc: "asgnAccess"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "ASGN rules"})
			.end()
	}

});
