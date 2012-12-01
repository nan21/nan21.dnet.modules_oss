/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeAssignmentDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"assignToPosition", type:"boolean"},
		{name:"baseSalary", type:"float", useNull:true},
		{name:"className", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"employeeCode", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"employerCode", type:"string"},
		{name:"employerId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"firstName", type:"string"},
		{name:"gradeCode", type:"string"},
		{name:"gradeId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"jobCode", type:"string"},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"middleName", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"payroll", type:"string"},
		{name:"payrollId", type:"int", useNull:true},
		{name:"posOrg", type:"string"},
		{name:"posOrgId", type:"int", useNull:true},
		{name:"positionCode", type:"string"},
		{name:"positionId", type:"int", useNull:true},
		{name:"positionName", type:"string"},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"version", type:"int", useNull:true}
	]});

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeAssignmentDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"assignToPosition", type:"boolean", useNull:true},
		{name:"baseSalary", type:"float", useNull:true},
		{name:"baseSalary_From",type:"float", useNull:true},
		{name:"baseSalary_To",type:"float", useNull:true},
		{name:"className", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"employeeCode", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeId_From",type:"int", useNull:true},
		{name:"employeeId_To",type:"int", useNull:true},
		{name:"employerCode", type:"string"},
		{name:"employerId", type:"int", useNull:true},
		{name:"employerId_From",type:"int", useNull:true},
		{name:"employerId_To",type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"firstName", type:"string"},
		{name:"gradeCode", type:"string"},
		{name:"gradeId", type:"int", useNull:true},
		{name:"gradeId_From",type:"int", useNull:true},
		{name:"gradeId_To",type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"jobCode", type:"string"},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobId_From",type:"int", useNull:true},
		{name:"jobId_To",type:"int", useNull:true},
		{name:"jobName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"middleName", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"orgId_From",type:"int", useNull:true},
		{name:"orgId_To",type:"int", useNull:true},
		{name:"payroll", type:"string"},
		{name:"payrollId", type:"int", useNull:true},
		{name:"payrollId_From",type:"int", useNull:true},
		{name:"payrollId_To",type:"int", useNull:true},
		{name:"posOrg", type:"string"},
		{name:"posOrgId", type:"int", useNull:true},
		{name:"posOrgId_From",type:"int", useNull:true},
		{name:"posOrgId_To",type:"int", useNull:true},
		{name:"positionCode", type:"string"},
		{name:"positionId", type:"int", useNull:true},
		{name:"positionId_From",type:"int", useNull:true},
		{name:"positionId_To",type:"int", useNull:true},
		{name:"positionName", type:"string"},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});

Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmployeeAssignmentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"validAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
