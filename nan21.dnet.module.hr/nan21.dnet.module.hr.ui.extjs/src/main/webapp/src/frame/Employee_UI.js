/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/dc/EmployeeLicense", "nan21.dnet.module.hr.ui.extjs/ds/GradeLovDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeContact", "nan21.dnet.module.hr.ui.extjs/lov/Positions", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeContactRelationshipLovDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannel", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeDs", "nan21.dnet.module.hr.ui.extjs/lov/Payrolls", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs", "nan21.dnet.module.bd.ui.extjs/lov/Countries", "nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes", "nan21.dnet.module.hr.ui.extjs/lov/EmployeeContactRelationships", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeSkillDs", "nan21.dnet.module.hr.ui.extjs/ds/EducationTypeLovDs", "nan21.dnet.module.hr.ui.extjs/lov/Skills", "nan21.dnet.module.hr.ui.extjs/lov/Jobs", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeEducation", "nan21.dnet.module.hr.ui.extjs/lov/EmploymentTypes", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeLicenseDs", "nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationLovDs", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeAssignmentDs", "nan21.dnet.module.hr.ui.extjs/lov/RatingLevels", "nan21.dnet.module.hr.ui.extjs/dc/Employee", "nan21.dnet.module.hr.ui.extjs/ds/PositionLovDs", "nan21.dnet.module.hr.ui.extjs/ds/EmploymentTypeLovDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeWorkExperience", "nan21.dnet.module.hr.ui.extjs/lov/Grades", "nan21.dnet.module.hr.ui.extjs/ds/PayrollLovDs", "nan21.dnet.module.bd.ui.extjs/lov/CommunicationChannelTypes", "nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs", "nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeContactDs", "nan21.dnet.module.hr.ui.extjs/lov/LicenseTypes", "nan21.dnet.module.hr.ui.extjs/ds/JobLovDs", "nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs", "nan21.dnet.module.hr.ui.extjs/ds/LicenseTypeLovDs", "nan21.dnet.module.hr.ui.extjs/lov/EducationTypes", "nan21.dnet.module.bd.ui.extjs/lov/Regions", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeEducationDs", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeLovDs", "nan21.dnet.module.bd.ui.extjs/dc/Location", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeAssignment", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeSkill", "nan21.dnet.module.bd.ui.extjs/lov/Organizations", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeWorkExperienceDs"]);

Ext.define("net.nan21.dnet.module.hr.employee.frame.Employee_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.employee.frame.Employee_UI",
	_name_: "net.nan21.dnet.module.hr.employee.frame.Employee_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("emp", new net.nan21.dnet.module.hr.employee.dc.Employee({}))
			.addDc("asgn", new net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment({}))
			.addDc("skill", new net.nan21.dnet.module.hr.skill.dc.EmployeeSkill({multiEdit:true}))
			.addDc("cont", new net.nan21.dnet.module.hr.employee.dc.EmployeeContact({multiEdit:true}))
			.addDc("communic", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true}))
			.addDc("educ", new net.nan21.dnet.module.hr.employee.dc.EmployeeEducation({multiEdit:true}))
			.addDc("work", new net.nan21.dnet.module.hr.employee.dc.EmployeeWorkExperience({multiEdit:true}))
			.addDc("lic", new net.nan21.dnet.module.hr.employee.dc.EmployeeLicense({multiEdit:true}))
			.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
			.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
			.addDc("address", new net.nan21.dnet.module.bd.geo.dc.Location({}))
	
			.linkDc("asgn", "emp",{fields:[
				{childField:"employeeId", parentField:"id"}]}
			)
			.linkDc("skill", "emp",{fields:[
				{childField:"employeeId", parentField:"id"}]}
			)
			.linkDc("cont", "emp",{fields:[
				{childField:"employeeId", parentField:"id"}]}
			)
			.linkDc("communic", "emp",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
			.linkDc("educ", "emp",{fields:[
				{childField:"employeeId", parentField:"id"}]}
			)
			.linkDc("work", "emp",{fields:[
				{childField:"employeeId", parentField:"id"}]}
			)
			.linkDc("lic", "emp",{fields:[
				{childField:"employeeId", parentField:"id"}]}
			)
			.linkDc("atch", "emp",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"entityFQN"}]}
			)
			.linkDc("note", "emp",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
			.linkDc("address", "emp",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnViewAttachment", text:"View", tooltip:"View the selected attachment", iconCls:"icon-action-view", disabled:true,
					handler: this.onBtnViewAttachment, scope:this, stateManager:{name:"selected_one", dc:"atch" }})
			.addButton({name:"btnUploadAttachment", text:"Upload...", tooltip:"Upload attachment file.", disabled:true,
					handler: this.onBtnUploadAttachment, scope:this, stateManager:{name:"selected_one_clean", dc:"atch" }})
			
			.addDcFilterFormView("emp", {name:"empFilter", height:140, xtype:"hr_employee_dc_Employee$Filter"})	
			.addDcGridView("emp", {name:"empList", xtype:"hr_employee_dc_Employee$List"})	
			.addDcFormView("emp", {name:"empEditMain", height:140, xtype:"hr_employee_dc_Employee$EditMain"})	
			.addDcFormView("emp", {name:"empEditOther", title:"Details", xtype:"hr_employee_dc_Employee$EditOther"})	
			.addDcGridView("asgn", {name:"asgnList", xtype:"hr_employee_dc_EmployeeAssignment$CtxList"})	
			.addDcFormView("asgn", {name:"asgnEdit", xtype:"hr_employee_dc_EmployeeAssignment$Edit"})	
			.addDcEditGridView("cont", {name:"contEditList", title:"Contacts", xtype:"hr_employee_dc_EmployeeContact$CtxEditList", frame:true})	
			.addDcEditGridView("skill", {name:"skillEditList", title:"Competences", xtype:"hr_skill_dc_EmployeeSkill$EditList", frame:true})	
			.addDcEditGridView("educ", {name:"educEditList", title:"Education", xtype:"hr_employee_dc_EmployeeEducation$EditList", frame:true})	
			.addDcEditGridView("work", {name:"workEditList", title:"Work experience", xtype:"hr_employee_dc_EmployeeWorkExperience$EditList", frame:true})	
			.addDcEditGridView("lic", {name:"licEditList", title:"Licenses", xtype:"hr_employee_dc_EmployeeLicense$EditList", frame:true})	
			.addDcEditGridView("atch", {name:"atchEditList", title:"Attachments", xtype:"ad_data_dc_Attachment$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnViewAttachment"), this._elems_.get("btnUploadAttachment")]}]})	
			.addDcEditGridView("communic", {name:"communicEditList", title:"Communication", xtype:"bd_contact_dc_CommunicationChannel$EditList", frame:true})	
			.addDcGridView("note", {name:"noteList", width:300, xtype:"ad_data_dc_Note$List"})	
			.addDcFormView("note", {name:"noteEdit", xtype:"ad_data_dc_Note$Edit"})	
			.addDcGridView("address", {name:"addressList", xtype:"bd_geo_dc_Location$ListCtx"})	
			.addDcFormView("address", {name:"addressEdit", xtype:"bd_geo_dc_Location$EditCtx"})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"empDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"notesPanel", title:"Notes", layout:"border", defaults:{split:true}})
			.addPanel({name:"asgnPanel", title:"Assignments", layout:"card", activeItem:0})
			.addPanel({name:"asgnEditWrapper", layout:"fit"})
			.addPanel({name:"addressPanel", title:"Address", layout:"card", activeItem:0})
			.addPanel({name:"addressEditWrapper", layout:"fit"})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["empFilter", "empList"], ["north", "center"])
			.addChildrenTo("canvas2", ["empEditMain", "empDetailsTab"], ["north", "center"])
			.addChildrenTo("empDetailsTab", ["empEditOther", "asgnPanel", "communicEditList", "addressPanel", "contEditList", "skillEditList", "licEditList", "atchEditList", "educEditList", "workEditList", "notesPanel"])
			.addChildrenTo("notesPanel", ["noteList", "noteEdit"], ["west", "center"])
			.addChildrenTo("asgnPanel", ["asgnList", "asgnEditWrapper"])
			.addChildrenTo("asgnEditWrapper", ["asgnEdit"])
			.addChildrenTo("addressPanel", ["addressList", "addressEditWrapper"])
			.addChildrenTo("addressEditWrapper", ["addressEdit"])
			.addToolbarTo("canvas1", "tlbEmpList")
			.addToolbarTo("canvas2", "tlbEmpEdit")
			.addToolbarTo("skillEditList", "tlbSkillList")
			.addToolbarTo("contEditList", "tlbContList")
			.addToolbarTo("educEditList", "tlbEducList")
			.addToolbarTo("workEditList", "tlbWorkList")
			.addToolbarTo("licEditList", "tlbLicList")
			.addToolbarTo("atchEditList", "tlbAtchList")
			.addToolbarTo("communicEditList", "tlbCommunicEditList")
			.addToolbarTo("noteList", "tlbNoteList")
			.addToolbarTo("noteEdit", "tlbNoteEdit")
			.addToolbarTo("addressList", "tlbAddressList")
			.addToolbarTo("addressEditWrapper", "tlbAddressEdit")
			.addToolbarTo("asgnList", "tlbAsgnList")
			.addToolbarTo("asgnEditWrapper", "tlbAsgnEdit")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbEmpList", {dc: "emp"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Employees"})
			.end()
			.beginToolbar("tlbEmpEdit", {dc: "emp"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Employee"})
			.end()
			.beginToolbar("tlbSkillList", {dc: "skill"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Competences"})
			.end()
			.beginToolbar("tlbContList", {dc: "cont"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Contacts"})
			.end()
			.beginToolbar("tlbEducList", {dc: "educ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Education"})
			.end()
			.beginToolbar("tlbWorkList", {dc: "work"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Work experience"})
			.end()
			.beginToolbar("tlbLicList", {dc: "lic"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Licenses"})
			.end()
			.beginToolbar("tlbAtchList", {dc: "atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Attachments"})
			.end()
			.beginToolbar("tlbCommunicEditList", {dc: "communic"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Communication"})
			.end()
			.beginToolbar("tlbNoteList", {dc: "note"}).addQuery()
			.addSeparator().addAutoLoad().addReports()
			.end()
			.beginToolbar("tlbNoteEdit", {dc: "note"}).addSave().addNew().addCancel()
			.addSeparator().addAutoLoad().addReports()
			.end()
			.beginToolbar("tlbAddressList", {dc: "address"}).addQuery(
			).addEdit(
			{inContainer:"addressPanel",showView:"addressEditWrapper"}
			).addNew(
			).addCopy(
			).addDeleteSelected(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Addresses"})
			.end()
			.beginToolbar("tlbAddressEdit", {dc: "address"}).addBack(
			{inContainer:"addressPanel",showView:"addressList"}
			).addSave(
			).addNew(
			).addCopy(
			).addCancel(
			).addPrevRec(
			).addNextRec(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Address"})
			.end()
			.beginToolbar("tlbAsgnList", {dc: "asgn"}).addQuery(
			).addEdit(
			{inContainer:"asgnPanel",showView:"asgnEditWrapper"}
			).addNew(
			).addCopy(
			).addDeleteSelected(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Assignments"})
			.end()
			.beginToolbar("tlbAsgnEdit", {dc: "asgn"}).addBack(
			{inContainer:"asgnPanel",showView:"asgnList"}
			).addSave(
			).addNew(
			).addCopy(
			).addCancel(
			).addPrevRec(
			).addNextRec(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Assignment"})
			.end()
	}

	,onUploadSuccess: function() {	
		this._getDc_("atch").doQuery();
	}
	,onBtnUploadAttachment: function() {
		var w=new dnet.core.base.FileUploadWindow({
		    		_nameFieldValue_: this._getDc_("atch").getRecord().get("name"),
		    		_p1Value_: this._getDc_("atch").getRecord().get("id"),
		    		_uploadUrl_:"/nan21.dnet.core.web/upload/adDataAttachment",
		    		_succesCallbackFn_ : this.onUploadSuccess,
		    		_succesCallbackScope_: this
		    	});w.show();
	}
	,onBtnViewAttachment: function() {
		
					var url = this._getDc_("atch").getRecord().get("url");
					window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
});
