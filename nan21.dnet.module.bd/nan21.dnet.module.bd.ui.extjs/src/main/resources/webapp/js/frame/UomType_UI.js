/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/ds/UomTypeDs", "nan21.dnet.module.bd.ui.extjs/dc/UomType"]);

Ext.define("net.nan21.dnet.module.bd.uom.frame.UomType_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.uom.frame.UomType_UI",
	_name_: "net.nan21.dnet.module.bd.uom.frame.UomType_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("type", new net.nan21.dnet.module.bd.uom.dc.UomType({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("type", {name:"typeFilter", height:80, xtype:"bd_uom_dc_UomType$Filter"})
			.addDcEditGridView("type", {name:"typeEditList", xtype:"bd_uom_dc_UomType$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["typeFilter", "typeEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbTypeEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTypeEditList", {dc: "type"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "UoM types"})
			.end()
			;
	}

});
