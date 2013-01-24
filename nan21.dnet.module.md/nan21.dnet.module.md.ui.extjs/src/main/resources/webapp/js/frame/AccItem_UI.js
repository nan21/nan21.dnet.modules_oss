/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.acc.frame.AccItem_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.acc.frame.AccItem_UI",
	_name_: "net.nan21.dnet.module.md.acc.frame.AccItem_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("item", new net.nan21.dnet.module.md.acc.dc.AccItem({multiEdit:true}))
			.addDc("acct", new net.nan21.dnet.module.md.acc.dc.AccItemAcct({multiEdit:true}))
	
			.linkDc("acct", "item",{fields:[
				{childField:"accItemId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("item", {name:"itemFilter", xtype:"md_acc_dc_AccItem$Filter"})
			.addDcEditGridView("item", {name:"itemEditList", width:500, xtype:"md_acc_dc_AccItem$EditList", frame:true})
			.addDcEditGridView("acct", {name:"acctEditList", xtype:"md_acc_dc_AccItemAcct$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["itemFilter", "itemEditList", "acctEditList"], ["north", "west", "center"])
			.addToolbarTo("canvas1", "tlbItemList")
			.addToolbarTo("acctEditList", "tlbAcctList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbItemList", {dc: "item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "G/L Items"})
			.end()
			.beginToolbar("tlbAcctList", {dc: "acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			;
	}

});
