/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.client.frame.MyClient_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.client.frame.MyClient_UI",
	_name_: "net.nan21.dnet.module.ad.client.frame.MyClient_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("client", new net.nan21.dnet.module.ad.client.dc.MyClient({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFormView("client", {name:"clientEdit", xtype:"ad_client_dc_MyClient$Edit"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["clientEdit"], ["center"])
			.addToolbarTo("canvas1", "clientEditTlb")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("clientEditTlb", {dc: "client"}).addSave().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Client info"})
			.end()
			;
	}

	
	,loadCurrentClient: function() {	
		this._getDc_("client").doQuery();
	}
	,_afterDefineDcs_: function() {
		this.loadCurrentClient();
	}
});
