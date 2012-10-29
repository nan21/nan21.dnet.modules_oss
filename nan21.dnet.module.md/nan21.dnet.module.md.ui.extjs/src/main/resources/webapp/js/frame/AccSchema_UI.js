/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/dc/AccSchema", "nan21.dnet.module.md.ui.extjs/ds/AccSchemaDs"]);

Ext.define("net.nan21.dnet.module.md.acc.frame.AccSchema_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.acc.frame.AccSchema_UI",
	_name_: "net.nan21.dnet.module.md.acc.frame.AccSchema_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("schema", new net.nan21.dnet.module.md.acc.dc.AccSchema({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("schema", {name:"schemaFilter", xtype:"md_acc_dc_AccSchema$Filter"})
			.addDcEditGridView("schema", {name:"schemaEditList", xtype:"md_acc_dc_AccSchema$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["schemaFilter", "schemaEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbSchemaEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSchemaEditList", {dc: "schema"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Accounting schema"})
			.end()
	}

});
