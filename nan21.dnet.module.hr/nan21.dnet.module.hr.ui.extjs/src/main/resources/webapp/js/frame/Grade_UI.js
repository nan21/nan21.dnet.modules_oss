/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/ds/GradeDs", "nan21.dnet.module.hr.ui.extjs/dc/Grade"]);

Ext.define("net.nan21.dnet.module.hr.grade.frame.Grade_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.grade.frame.Grade_UI",
	_name_: "net.nan21.dnet.module.hr.grade.frame.Grade_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("m", new net.nan21.dnet.module.hr.grade.dc.Grade({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("m", {name:"mFilter", height:80, xtype:"hr_grade_dc_Grade$Filter"})
			.addDcEditGridView("m", {name:"mEditList", xtype:"hr_grade_dc_Grade$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["mFilter", "mEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlb")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlb", {dc: "m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Grades"})
			.end()
	}

});
