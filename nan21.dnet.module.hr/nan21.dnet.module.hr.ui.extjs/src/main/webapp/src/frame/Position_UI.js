/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/dc/PositionCourse", "nan21.dnet.module.hr.ui.extjs/ds/EmploymentTypeLovDs", "nan21.dnet.module.hr.ui.extjs/lov/WorkRequirements", "nan21.dnet.module.hr.ui.extjs/ds/PositionDs", "nan21.dnet.module.hr.ui.extjs/lov/Courses", "nan21.dnet.module.hr.ui.extjs/lov/Skills", "nan21.dnet.module.hr.ui.extjs/lov/Jobs", "nan21.dnet.module.hr.ui.extjs/ds/CourseLovDs", "nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementLovDs", "nan21.dnet.module.hr.ui.extjs/lov/EmploymentTypes", "nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs", "nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs", "nan21.dnet.module.hr.ui.extjs/ds/PositionCourseDs", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationLovDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeAssignment", "nan21.dnet.module.hr.ui.extjs/dc/PositionRequirement", "nan21.dnet.module.hr.ui.extjs/dc/Position", "nan21.dnet.module.hr.ui.extjs/ds/PositionSkillDs", "nan21.dnet.module.hr.ui.extjs/ds/PositionRequirementDs", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeAssignmentDs", "nan21.dnet.module.bd.ui.extjs/lov/Organizations", "nan21.dnet.module.hr.ui.extjs/ds/JobLovDs", "nan21.dnet.module.hr.ui.extjs/lov/RatingLevels", "nan21.dnet.module.hr.ui.extjs/dc/PositionSkill"]);

Ext.define("net.nan21.dnet.module.hr.job.frame.Position_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.job.frame.Position_UI",
	_name_: "net.nan21.dnet.module.hr.job.frame.Position_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("pos", new net.nan21.dnet.module.hr.job.dc.Position({}))
			.addDc("skill", new net.nan21.dnet.module.hr.skill.dc.PositionSkill({multiEdit:true}))
			.addDc("req", new net.nan21.dnet.module.hr.job.dc.PositionRequirement({multiEdit:true}))
			.addDc("course", new net.nan21.dnet.module.hr.training.dc.PositionCourse({multiEdit:true}))
			.addDc("asgn", new net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment({}))
	
			.linkDc("skill", "pos",{fields:[
				{childField:"positionId", parentField:"id"}]}
			)
			.linkDc("req", "pos",{fields:[
				{childField:"positionId", parentField:"id"}]}
			)
			.linkDc("course", "pos",{fields:[
				{childField:"positionId", parentField:"id"}]}
			)
			.linkDc("asgn", "pos",{fields:[
				{childField:"positionId", parentField:"id"}]}
			)
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("pos", {name:"posFilter", height:80, xtype:"hr_job_dc_Position$Filter"})	
			.addDcGridView("pos", {name:"posList", xtype:"hr_job_dc_Position$List"})	
			.addDcFormView("pos", {name:"posEdit", height:180, xtype:"hr_job_dc_Position$Edit"})	
			.addDcEditGridView("skill", {name:"skillCtxEditList", title:"Competences", xtype:"hr_skill_dc_PositionSkill$CtxEditList", frame:true})	
			.addDcEditGridView("req", {name:"reqCtxEditList", title:"Requirements", xtype:"hr_job_dc_PositionRequirement$CtxEditList", frame:true})	
			.addDcEditGridView("course", {name:"courseCtxEditList", title:"Courses", xtype:"hr_training_dc_PositionCourse$PositionCtxEditList", frame:true})	
			.addDcFilterFormView("asgn", {name:"asgnFilter", width:300, xtype:"hr_employee_dc_EmployeeAssignment$FilterCtx"})	
			.addDcGridView("asgn", {name:"asgnList", xtype:"hr_employee_dc_EmployeeAssignment$CtxListJobPos"})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"detailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"asgnPanel", title:"Assignments", layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["posFilter", "posList"], ["north", "center"])
			.addChildrenTo("canvas2", ["posEdit", "detailsTab"], ["north", "center"])
			.addChildrenTo("detailsTab", ["asgnPanel", "reqCtxEditList", "skillCtxEditList", "courseCtxEditList"])
			.addChildrenTo("asgnPanel", ["asgnFilter", "asgnList"], ["west", "center"])
			.addToolbarTo("canvas1", "tlbPosList")
			.addToolbarTo("canvas2", "tlbPosEdit")
			.addToolbarTo("skillCtxEditList", "tlbSkillCtxEditList")
			.addToolbarTo("reqCtxEditList", "tlbReqCtxEditList")
			.addToolbarTo("courseCtxEditList", "tlbCourseCtxEditList")
			.addToolbarTo("asgnPanel", "tlbAsgnList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPosList", {dc: "pos"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Positions"})
			.end()
			.beginToolbar("tlbPosEdit", {dc: "pos"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Position"})
			.end()
			.beginToolbar("tlbSkillCtxEditList", {dc: "skill"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Competences"})
			.end()
			.beginToolbar("tlbReqCtxEditList", {dc: "req"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Requirements"})
			.end()
			.beginToolbar("tlbCourseCtxEditList", {dc: "course"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Courses"})
			.end()
			.beginToolbar("tlbAsgnList", {dc: "asgn"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Assignments"})
			.end()
	}

});
