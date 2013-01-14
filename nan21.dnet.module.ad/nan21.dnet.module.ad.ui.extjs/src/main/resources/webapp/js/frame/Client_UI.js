/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/ds/ImportJobLovDs", "nan21.dnet.module.ad.ui.extjs/ds/ClientDs", "nan21.dnet.module.ad.ui.extjs/dc/Client", "nan21.dnet.module.ad.ui.extjs/lov/ImportJob"]);

Ext.define("net.nan21.dnet.module.ad.client.frame.Client_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.client.frame.Client_UI",
	_name_: "net.nan21.dnet.module.ad.client.frame.Client_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("client", new net.nan21.dnet.module.ad.client.dc.Client({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("client", {name:"clientFilter", height:80, xtype:"ad_client_dc_Client$Filter"})
			.addDcGridView("client", {name:"clientList", xtype:"ad_client_dc_Client$List"})
			.addDcFormView("client", {name:"clientEdit", xtype:"ad_client_dc_Client$Edit"})
			.addDcFormView("client", {name:"clientCreate", xtype:"ad_client_dc_Client$Create"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas3", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2", "canvas3"])
			.addChildrenTo("canvas1", ["clientFilter", "clientList"], ["north", "center"])
			.addChildrenTo("canvas2", ["clientEdit"], ["center"])
			.addChildrenTo("canvas3", ["clientCreate"], ["center"])
			.addToolbarTo("canvas1", "tlbClientList")
			.addToolbarTo("canvas2", "tlbClientEdit")
			.addToolbarTo("canvas3", "tlbClientCreate")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbClientList", {dc: "client"}).addQuery().addEdit().addNew({autoEdit:"false",showView:"canvas3"})
			.addReports().addSeparator().addSeparator().addTitle({text: "Clients"})
			.end()
			.beginToolbar("tlbClientEdit", {dc: "client"}).addBack().addSave().addNew({autoEdit:"false",showView:"canvas3"}).addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Client"})
			.end()
			.beginToolbar("tlbClientCreate", {dc: "client"}).addBack().addSave().addNew({autoEdit:"false",showView:"canvas3"}).addCancel().addPrevRec().addNextRec()
			.addReports()
			.end()
			;
	}

});
