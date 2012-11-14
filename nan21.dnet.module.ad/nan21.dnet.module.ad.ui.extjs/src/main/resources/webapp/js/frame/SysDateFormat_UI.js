/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/dc/SysDateFormat", "nan21.dnet.module.ad.ui.extjs/ds/SysDateFormatDs"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.SysDateFormat_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.system.frame.SysDateFormat_UI",
	_name_: "net.nan21.dnet.module.ad.system.frame.SysDateFormat_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("fmt", new net.nan21.dnet.module.ad.system.dc.SysDateFormat({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("fmt", {name:"fmtFilter", height:80, xtype:"ad_system_dc_SysDateFormat$Filter"})
			.addDcEditGridView("fmt", {name:"fmtEditList", xtype:"ad_system_dc_SysDateFormat$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["fmtFilter", "fmtEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbFmtEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbFmtEditList", {dc: "fmt"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Date formats"})
			.end()
			;
	}

});
