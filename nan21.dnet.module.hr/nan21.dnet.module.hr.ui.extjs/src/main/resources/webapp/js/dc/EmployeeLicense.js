/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeLicense", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeLicenseDs"
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeLicense$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_employee_dc_EmployeeLicense$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"licenseTypeId", dataIndex:"licenseTypeId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"licenseType", dataIndex:"licenseType", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_employee_lovs_LicenseTypes", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "licenseTypeId"} 
						]}})
			.addTextColumn({name:"documentNo", dataIndex:"documentNo", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"issuedBy", dataIndex:"issuedBy", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"validTo", dataIndex:"validTo", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});
