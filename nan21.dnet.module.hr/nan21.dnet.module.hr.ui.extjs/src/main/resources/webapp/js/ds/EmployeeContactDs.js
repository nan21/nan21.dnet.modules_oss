/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"birthDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"firstName", type:"string"},
		{name:"gender", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"isDependent", type:"boolean"},
		{name:"lastName", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"relationship", type:"string"},
		{name:"relationshipId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"birthDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeId_From",type:"int", useNull:true},
		{name:"employeeId_To",type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"firstName", type:"string"},
		{name:"gender", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"isDependent", type:"boolean", useNull:true},
		{name:"lastName", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"relationship", type:"string"},
		{name:"relationshipId", type:"int", useNull:true},
		{name:"relationshipId_From",type:"int", useNull:true},
		{name:"relationshipId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
