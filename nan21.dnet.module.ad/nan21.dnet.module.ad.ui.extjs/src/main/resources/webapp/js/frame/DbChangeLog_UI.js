/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/ds/DbChangeLogDs", "nan21.dnet.module.ad.ui.extjs/dc/DbChangeLog"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.DbChangeLog_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.system.frame.DbChangeLog_UI",
	_name_: "net.nan21.dnet.module.ad.system.frame.DbChangeLog_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("dblog", new net.nan21.dnet.module.ad.system.dc.DbChangeLog({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("dblog", {name:"dblogFilter", xtype:"ad_system_dc_DbChangeLog$Filter"})
			.addDcGridView("dblog", {name:"dblogList", xtype:"ad_system_dc_DbChangeLog$List"})
			.addPanel({name:"main", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["dblogFilter", "dblogList"], ["north", "center"])
			.addToolbarTo("main", "tlbdblogList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbdblogList", {dc: "dblog"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Database changelog"})
			.end()
			;
	}

});
