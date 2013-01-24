/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.acc.frame.Account_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.acc.frame.Account_UI",
	_name_: "net.nan21.dnet.module.md.acc.frame.Account_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("account", new net.nan21.dnet.module.md.acc.dc.Account({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("account", {name:"accountFilter", height:80, xtype:"md_acc_dc_Account$Filter"})
			.addDcGridView("account", {name:"accountList", xtype:"md_acc_dc_Account$List"})
			.addDcEditGridView("account", {name:"accountEditList", xtype:"md_acc_dc_Account$EditList", frame:true})
			.addDcFormView("account", {name:"accountEdit", xtype:"md_acc_dc_Account$Edit"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["accountFilter", "accountEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbSchemaList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSchemaList", {dc: "account"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Accounts chart"})
			.end()
			;
	}

});
