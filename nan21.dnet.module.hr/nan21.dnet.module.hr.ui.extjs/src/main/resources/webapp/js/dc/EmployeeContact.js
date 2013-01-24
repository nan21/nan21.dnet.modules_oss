/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeContact", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDs"
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeContact$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_employee_dc_EmployeeContact$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"firstName", dataIndex:"firstName", width:200,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addTextColumn({name:"lastName", dataIndex:"lastName", width:200,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addDateColumn({name:"birthDate", dataIndex:"birthDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addComboColumn({name:"gender", dataIndex:"gender", width:60,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, allowBlank:false, triggerAction:'all', forceSelection:true, store:[ "male", "female"]}})
			.addNumberColumn({name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"relationshipId", dataIndex:"relationshipId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"relationship", dataIndex:"relationship", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_employee_lovs_EmployeeContactRelationships", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "relationshipId"} 
						]}})
			.addBooleanColumn({name:"isDependent", dataIndex:"isDependent"})
			.addDefaults();
	}
});
