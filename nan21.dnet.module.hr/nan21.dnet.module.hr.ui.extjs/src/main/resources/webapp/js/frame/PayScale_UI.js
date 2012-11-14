/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/dc/PayScale", "nan21.dnet.module.hr.ui.extjs/ds/PayScalePointDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScalePoint", "nan21.dnet.module.hr.ui.extjs/ds/PayScaleDs"]);

Ext.define("net.nan21.dnet.module.hr.grade.frame.PayScale_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.grade.frame.PayScale_UI",
	_name_: "net.nan21.dnet.module.hr.grade.frame.PayScale_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("scale", new net.nan21.dnet.module.hr.grade.dc.PayScale({}))
			.addDc("point", new net.nan21.dnet.module.hr.grade.dc.PayScalePoint({multiEdit:true}))
	
			.linkDc("point", "scale",{fields:[
				{childField:"payScaleId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("scale", {name:"scaleFilter", height:80, xtype:"hr_grade_dc_PayScale$Filter"})
			.addDcGridView("scale", {name:"scaleList", xtype:"hr_grade_dc_PayScale$List"})
			.addDcFormView("scale", {name:"scaleEdit", height:120, xtype:"hr_grade_dc_PayScale$Edit"})
			.addDcEditGridView("point", {name:"pointEditList", xtype:"hr_grade_dc_PayScalePoint$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["scaleFilter", "scaleList"], ["north", "center"])
			.addChildrenTo("canvas2", ["scaleEdit", "pointEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbScaleList")
			.addToolbarTo("canvas2", "tlbScaleEdit")
			.addToolbarTo("pointEditList", "tlbPointEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbScaleList", {dc: "scale"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Pay scales"})
			.end()
			.beginToolbar("tlbScaleEdit", {dc: "scale"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Pay scale"})
			.end()
			.beginToolbar("tlbPointEditList", {dc: "point"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Progression points"})
			.end()
			;
	}

});
