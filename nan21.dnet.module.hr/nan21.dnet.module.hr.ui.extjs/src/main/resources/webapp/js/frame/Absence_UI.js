/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.time.frame.Absence_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.time.frame.Absence_UI",
	_name_: "net.nan21.dnet.module.hr.time.frame.Absence_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("absence", new net.nan21.dnet.module.hr.time.dc.Absence({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("absence", {name:"absenceFilter", height:120, xtype:"hr_time_dc_Absence$Filter"})
			.addDcGridView("absence", {name:"absenceList", xtype:"hr_time_dc_Absence$List"})
			.addDcFormView("absence", {name:"absenceEdit", xtype:"hr_time_dc_Absence$Edit"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["absenceFilter", "absenceList"], ["north", "center"])
			.addChildrenTo("canvas2", ["absenceEdit"], ["center"])
			.addToolbarTo("canvas1", "tlbAbsenceList")
			.addToolbarTo("canvas2", "tlbAbsenceEdit")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAbsenceList", {dc: "absence"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Absences"})
			.end()
			.beginToolbar("tlbAbsenceEdit", {dc: "absence"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Absence"})
			.end()
			;
	}

});
