/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/ds/EmploymentTypeLovDs", "nan21.dnet.module.hr.ui.extjs/lov/WorkRequirements", "nan21.dnet.module.hr.ui.extjs/lov/Courses", "nan21.dnet.module.hr.ui.extjs/lov/Skills", "nan21.dnet.module.hr.ui.extjs/dc/JobSkill", "nan21.dnet.module.hr.ui.extjs/ds/CourseLovDs", "nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementLovDs", "nan21.dnet.module.hr.ui.extjs/lov/EmploymentTypes", "nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs", "nan21.dnet.module.hr.ui.extjs/ds/JobDs", "nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeAssignment", "nan21.dnet.module.hr.ui.extjs/ds/JobTypeLovDs", "nan21.dnet.module.hr.ui.extjs/ds/JobSkillDs", "nan21.dnet.module.hr.ui.extjs/ds/JobRequirementDs", "nan21.dnet.module.hr.ui.extjs/dc/JobRequirement", "nan21.dnet.module.hr.ui.extjs/dc/JobCourse", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeAssignmentDs", "nan21.dnet.module.hr.ui.extjs/ds/JobCourseDs", "nan21.dnet.module.hr.ui.extjs/lov/RatingLevels", "nan21.dnet.module.hr.ui.extjs/dc/Job", "nan21.dnet.module.hr.ui.extjs/lov/JobTypes"]);

Ext.define("net.nan21.dnet.module.hr.job.frame.Job_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.job.frame.Job_UI",
	_name_: "net.nan21.dnet.module.hr.job.frame.Job_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("job", new net.nan21.dnet.module.hr.job.dc.Job({}))
			.addDc("skill", new net.nan21.dnet.module.hr.skill.dc.JobSkill({multiEdit:true}))
			.addDc("req", new net.nan21.dnet.module.hr.job.dc.JobRequirement({multiEdit:true}))
			.addDc("course", new net.nan21.dnet.module.hr.training.dc.JobCourse({multiEdit:true}))
			.addDc("asgn", new net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment({}))
	
			.linkDc("skill", "job",{fields:[
				{childField:"jobId", parentField:"id"}]}
			)
			.linkDc("req", "job",{fields:[
				{childField:"jobId", parentField:"id"}]}
			)
			.linkDc("course", "job",{fields:[
				{childField:"jobId", parentField:"id"}]}
			)
			.linkDc("asgn", "job",{fields:[
				{childField:"jobId", parentField:"id"}]}
			)
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("job", {name:"jobFilter", height:80, xtype:"hr_job_dc_Job$Filter"})	
			.addDcGridView("job", {name:"jobList", xtype:"hr_job_dc_Job$List"})	
			.addDcEditGridView("job", {name:"jobEditList", xtype:"hr_job_dc_Job$EditList", frame:true})	
			.addDcFormView("job", {name:"jobEdit", height:140, xtype:"hr_job_dc_Job$Edit"})	
			.addDcEditGridView("skill", {name:"skillCtxEditList", title:"Competences", xtype:"hr_skill_dc_JobSkill$CtxEditList", frame:true})	
			.addDcEditGridView("req", {name:"reqCtxEditList", title:"Requirements", xtype:"hr_job_dc_JobRequirement$CtxEditList", frame:true})	
			.addDcEditGridView("course", {name:"courseCtxEditList", title:"Courses", xtype:"hr_training_dc_JobCourse$JobCtxEditList", frame:true})	
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
			.addChildrenTo("canvas1", ["jobFilter", "jobList"], ["north", "center"])
			.addChildrenTo("canvas2", ["jobEdit", "detailsTab"], ["north", "center"])
			.addChildrenTo("detailsTab", ["asgnPanel", "reqCtxEditList", "skillCtxEditList", "courseCtxEditList"])
			.addChildrenTo("asgnPanel", ["asgnFilter", "asgnList"], ["west", "center"])
			.addToolbarTo("canvas1", "tlbJobList")
			.addToolbarTo("canvas2", "tlbJobEdit")
			.addToolbarTo("skillCtxEditList", "tlbSkillCtxEditList")
			.addToolbarTo("reqCtxEditList", "tlbReqCtxEditList")
			.addToolbarTo("courseCtxEditList", "tlbCourseCtxEditList")
			.addToolbarTo("asgnPanel", "tlbAsgnList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbJobList", {dc: "job"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Jobs"})
			.end()
			.beginToolbar("tlbJobEdit", {dc: "job"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Job"})
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
