/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeEducation", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeEducationDs",
	filterModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeEducationDsFilter",
	paramModel: "net.nan21.dnet.module.hr.employee.ds.param.EmployeeEducationDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeEducation$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_employee_dc_EmployeeEducation$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"typeId", dataIndex:"typeId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_employee_lovs_EducationTypes", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "typeId"} 
						]}})
			.addDateColumn({name:"fromDate", dataIndex:"fromDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"toDate", dataIndex:"toDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addTextColumn({name:"institute", dataIndex:"institute", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"degree", dataIndex:"degree", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}});
