/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/ds/BankDs", "nan21.dnet.module.md.ui.extjs/dc/Bank"]);

Ext.define("net.nan21.dnet.module.md.bp.frame.Bank_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.bp.frame.Bank_UI",
	_name_: "net.nan21.dnet.module.md.bp.frame.Bank_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("bank", new net.nan21.dnet.module.md.bp.dc.Bank({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("bank", {name:"bankFilter", height:80, xtype:"md_bp_dc_Bank$Filter"})
			.addDcEditGridView("bank", {name:"bankEditList", xtype:"md_bp_dc_Bank$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["bankFilter", "bankEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlb")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlb", {dc: "bank"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Banks"})
			.end()
	}

});
