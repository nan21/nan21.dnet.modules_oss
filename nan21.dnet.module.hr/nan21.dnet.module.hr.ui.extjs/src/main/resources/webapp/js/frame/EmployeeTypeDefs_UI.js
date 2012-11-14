/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/dc/EducationType", "nan21.dnet.module.hr.ui.extjs/ds/EmploymentTypeDs", "nan21.dnet.module.hr.ui.extjs/ds/EducationTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/LicenseType", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeContactRelationshipDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeContactRelationship", "nan21.dnet.module.hr.ui.extjs/ds/LicenseTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/EmploymentType"]);

Ext.define("net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI",
	_name_: "net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("educType", new net.nan21.dnet.module.hr.employee.dc.EducationType({multiEdit:true}))
			.addDc("contactRel", new net.nan21.dnet.module.hr.employee.dc.EmployeeContactRelationship({multiEdit:true}))
			.addDc("licType", new net.nan21.dnet.module.hr.employee.dc.LicenseType({multiEdit:true}))
			.addDc("asgnType", new net.nan21.dnet.module.hr.employee.dc.EmploymentType({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("educType", {name:"educTypeFilter", height:80, xtype:"hr_employee_dc_EducationType$Filter"})
			.addDcEditGridView("educType", {name:"educTypeEditList", xtype:"hr_employee_dc_EducationType$EditList", frame:true})
			.addDcFilterFormView("contactRel", {name:"contactRelFilter", height:80, xtype:"hr_employee_dc_EmployeeContactRelationship$Filter"})
			.addDcEditGridView("contactRel", {name:"contactRelEditList", xtype:"hr_employee_dc_EmployeeContactRelationship$EditList", frame:true})
			.addDcFilterFormView("licType", {name:"licTypeFilter", height:80, xtype:"hr_employee_dc_LicenseType$Filter"})
			.addDcEditGridView("licType", {name:"licTypeEditList", xtype:"hr_employee_dc_LicenseType$EditList", frame:true})
			.addDcFilterFormView("asgnType", {name:"asgnTypeFilter", height:80, xtype:"hr_employee_dc_EmploymentType$Filter"})
			.addDcEditGridView("asgnType", {name:"asgnTypeEditList", xtype:"hr_employee_dc_EmploymentType$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasEducType", title:"Education type", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasContactRel", title:"Contact relationship", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasLicType", title:"License types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasAsgnType", title:"Employment types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasEducType","canvasContactRel","canvasLicType","canvasAsgnType"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasEducType", "canvasContactRel", "canvasLicType", "canvasAsgnType"])
			.addChildrenTo("canvasEducType", ["educTypeFilter", "educTypeEditList"], ["north", "center"])
			.addChildrenTo("canvasContactRel", ["contactRelFilter", "contactRelEditList"], ["north", "center"])
			.addChildrenTo("canvasLicType", ["licTypeFilter", "licTypeEditList"], ["north", "center"])
			.addChildrenTo("canvasAsgnType", ["asgnTypeFilter", "asgnTypeEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasEducType", "educTypeTlb")
			.addToolbarTo("canvasContactRel", "contactRelTlb")
			.addToolbarTo("canvasLicType", "licTypeTlb")
			.addToolbarTo("canvasAsgnType", "asgnTypeTlb")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("educTypeTlb", {dc: "educType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Education type"})
			.end()
			.beginToolbar("contactRelTlb", {dc: "contactRel"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Contact relationship"})
			.end()
			.beginToolbar("licTypeTlb", {dc: "licType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "License types"})
			.end()
			.beginToolbar("asgnTypeTlb", {dc: "asgnType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Employment types"})
			.end()
			;
	}

});
