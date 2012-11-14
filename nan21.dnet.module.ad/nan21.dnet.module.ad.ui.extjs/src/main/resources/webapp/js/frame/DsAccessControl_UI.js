/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/dc/DsAccessControl", "nan21.dnet.module.ad.ui.extjs/ds/DsAccessControlDs", "nan21.dnet.module.ad.ui.extjs/ds/AccessControlLovDs", "nan21.dnet.module.ad.ui.extjs/lov/SysDataSourceDs", "nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceDsLovDs", "nan21.dnet.module.ad.ui.extjs/lov/AccessControls"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.DsAccessControl_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.frame.DsAccessControl_UI",
	_name_: "net.nan21.dnet.module.ad.usr.frame.DsAccessControl_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("dsAccess", new net.nan21.dnet.module.ad.usr.dc.DsAccessControl({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("dsAccess", {name:"dsAccessFilter", height:120, xtype:"ad_usr_dc_DsAccessControl$Filter"})
			.addDcEditGridView("dsAccess", {name:"dsAccessEditList", xtype:"ad_usr_dc_DsAccessControl$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["dsAccessFilter", "dsAccessEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbDsAccessEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbDsAccessEditList", {dc: "dsAccess"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "DS rules"})
			.end()
			;
	}

});
