/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/ds/SysDateFormatLovDs", "nan21.dnet.module.ad.ui.extjs/dc/MyUserSettings", "nan21.dnet.module.ad.ui.extjs/lov/SysDateFormats", "nan21.dnet.module.ad.ui.extjs/ds/MyUserSettingsDs"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.MyUserSettings_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.frame.MyUserSettings_UI",
	_name_: "net.nan21.dnet.module.ad.usr.frame.MyUserSettings_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("usr", new net.nan21.dnet.module.ad.usr.dc.MyUserSettings({}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFormView("usr", {name:"usrEdit", xtype:"ad_usr_dc_MyUserSettings$Edit"})
			.addPanel({name:"main", layout:"fit"})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["usrEdit"])
			.addToolbarTo("main", "tlbUsrEdit")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbUsrEdit", {dc: "usr"}).addSave().addCancel()
			.addReports()
			.end()
	}

	,loadCurrentUser: function() {
		
		  		var client = this._getDc_('usr');
				client.getFilter().set('id',getApplication().getSession().getUser().id ) ;
				client.doQuery();
	}
	,_afterDefineDcs_: function() {
		this.loadCurrentUser();
	}
});
