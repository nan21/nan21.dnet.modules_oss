/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.data.frame.Attachments_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.data.frame.Attachments_UI",
	_name_: "net.nan21.dnet.module.ad.data.frame.Attachments_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("atch", {name:"atchFilter", xtype:"ad_data_dc_Attachment$Filter"})
			.addDcGridView("atch", {name:"atchList", xtype:"ad_data_dc_Attachment$List"})
			.addPanel({name:"main", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["atchFilter", "atchList"], ["north", "center"])
			.addToolbarTo("main", "tlbAtchList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAtchList", {dc: "atch"}).addQuery().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Attachments"})
			.end()
			;
	}

});
