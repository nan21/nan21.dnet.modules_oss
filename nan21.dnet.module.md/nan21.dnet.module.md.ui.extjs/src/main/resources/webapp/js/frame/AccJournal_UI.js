/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/ds/AccJournalDs", "nan21.dnet.module.md.ui.extjs/dc/AccJournal"]);

Ext.define("net.nan21.dnet.module.md.acc.frame.AccJournal_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.acc.frame.AccJournal_UI",
	_name_: "net.nan21.dnet.module.md.acc.frame.AccJournal_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("journal", new net.nan21.dnet.module.md.acc.dc.AccJournal({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("journal", {name:"journalFilter", xtype:"md_acc_dc_AccJournal$Filter"})
			.addDcEditGridView("journal", {name:"journalEditList", xtype:"md_acc_dc_AccJournal$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["journalFilter", "journalEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbItemList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbItemList", {dc: "journal"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
			.end()
	}

});
