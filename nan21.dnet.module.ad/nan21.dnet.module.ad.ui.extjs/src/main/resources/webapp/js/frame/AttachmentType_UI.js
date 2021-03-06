/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.data.frame.AttachmentType_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.data.frame.AttachmentType_UI",
	_name_: "net.nan21.dnet.module.ad.data.frame.AttachmentType_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("attchType", new net.nan21.dnet.module.ad.data.dc.AttachmentType({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("attchType", {name:"attchTypeFilter", height:80, xtype:"ad_data_dc_AttachmentType$Filter"})
			.addDcEditGridView("attchType", {name:"attchTypeEditList", xtype:"ad_data_dc_AttachmentType$EditList", frame:true})
			.addPanel({name:"main", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["attchTypeFilter", "attchTypeEditList"], ["north", "center"])
			.addToolbarTo("main", "tlbAttchTypeEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAttchTypeEditList", {dc: "attchType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Attachment types"})
			.end()
			;
	}

});
