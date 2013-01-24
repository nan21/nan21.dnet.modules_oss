/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI",
	_name_: "net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("ctype", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("ctype", {name:"ctypeFilter", height:80, xtype:"bd_contact_dc_CommunicationChannelType$Filter"})
			.addDcEditGridView("ctype", {name:"ctypeEditList", xtype:"bd_contact_dc_CommunicationChannelType$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["ctypeFilter", "ctypeEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbCtypeEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCtypeEditList", {dc: "ctype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Communication methods"})
			.end()
			;
	}

});
