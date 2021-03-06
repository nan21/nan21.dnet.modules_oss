/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.bp.frame.Contact_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.bp.frame.Contact_UI",
	_name_: "net.nan21.dnet.module.md.bp.frame.Contact_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("c", new net.nan21.dnet.module.md.bp.dc.Contact({}))
			.addDc("communic", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true}))
	
			.linkDc("communic", "c",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("c", {name:"cFilter", height:80, xtype:"md_bp_dc_Contact$Filter"})
			.addDcGridView("c", {name:"cList", xtype:"md_bp_dc_Contact$List"})
			.addDcFormView("c", {name:"cEdit", height:120, xtype:"md_bp_dc_Contact$Edit"})
			.addDcEditGridView("communic", {name:"communicEditList", title:"Communication", xtype:"bd_contact_dc_CommunicationChannel$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"bpDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["cFilter", "cList"], ["north", "center"])
			.addChildrenTo("canvas2", ["cEdit", "bpDetailsTab"], ["north", "center"])
			.addChildrenTo("bpDetailsTab", ["communicEditList"])
			.addToolbarTo("canvas1", "tlbTList")
			.addToolbarTo("canvas2", "tlbTEdit")
			.addToolbarTo("communicEditList", "tlbCommunicEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTList", {dc: "c"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Contacts"})
			.end()
			.beginToolbar("tlbTEdit", {dc: "c"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Contact"})
			.end()
			.beginToolbar("tlbCommunicEditList", {dc: "communic"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Communication"})
			.end()
			;
	}

});
