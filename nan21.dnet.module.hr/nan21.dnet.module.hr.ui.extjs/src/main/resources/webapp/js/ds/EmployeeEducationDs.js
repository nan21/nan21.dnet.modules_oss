/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeEducationDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"degree", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"fromDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"id", type:"int", useNull:true},
		{name:"institute", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"toDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
