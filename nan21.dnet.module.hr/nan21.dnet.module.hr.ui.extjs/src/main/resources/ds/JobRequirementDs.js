/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.job.ds.model.JobRequirementDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"jobId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"requirement", type:"string"},
		{name:"requirementId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.hr.job.ds.model.JobRequirementDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobId_From",type:"int", useNull:true},
		{name:"jobId_To",type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"requirement", type:"string"},
		{name:"requirementId", type:"int", useNull:true},
		{name:"requirementId_From",type:"int", useNull:true},
		{name:"requirementId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.hr.job.ds.param.JobRequirementDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
