/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"birthdate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"businessObject", type:"string"},
		{name:"citizenshipCode", type:"string"},
		{name:"citizenshipId", type:"int", useNull:true},
		{name:"className", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currentHireDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"employerCode", type:"string"},
		{name:"employerId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"firstHireDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"firstName", type:"string"},
		{name:"gender", type:"string"},
		{name:"hasDisability", type:"boolean"},
		{name:"id", type:"int", useNull:true},
		{name:"lastName", type:"string"},
		{name:"maritalStatus", type:"string"},
		{name:"middleName", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"officeEmail", type:"string"},
		{name:"passportNo", type:"string"},
		{name:"photoLocation", type:"string"},
		{name:"photoUrl", type:"string"},
		{name:"sinNo", type:"string"},
		{name:"ssnNo", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],

	validations: [
		{field: "firstName", type: 'presence'},
		{field: "lastName", type: 'presence'}
	]
});
