/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.prod.frame.ProductAccountGroup_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.frame.ProductAccountGroup_UI",
	_name_: "net.nan21.dnet.module.md.mm.prod.frame.ProductAccountGroup_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("account", new net.nan21.dnet.module.md.mm.prod.dc.ProductAccountGroup({multiEdit:true}))
			.addDc("acct", new net.nan21.dnet.module.md.mm.prod.dc.ProductAccountGroupAcct({multiEdit:true}))
	
			.linkDc("acct", "account",{fields:[
				{childField:"groupId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("account", {name:"accountFilter", height:80, xtype:"md_mm_prod_dc_ProductAccountGroup$Filter"})
			.addDcEditGridView("account", {name:"accountEditList", xtype:"md_mm_prod_dc_ProductAccountGroup$EditList", frame:true})
			.addDcEditGridView("acct", {name:"acctEditList", height:240, xtype:"md_mm_prod_dc_ProductAccountGroupAcct$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["accountFilter", "accountEditList", "acctEditList"], ["north", "center", "south"])
			.addToolbarTo("canvas1", "tlbAccount")
			.addToolbarTo("acctEditList", "tlbAcct")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAccount", {dc: "account"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Product account groups"})
			.end()
			.beginToolbar("tlbAcct", {dc: "acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			;
	}

});
