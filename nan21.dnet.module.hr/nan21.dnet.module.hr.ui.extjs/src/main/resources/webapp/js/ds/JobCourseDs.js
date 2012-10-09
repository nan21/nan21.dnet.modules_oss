/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.training.ds.model.JobCourseDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"courseCode", type:"string"},
		{name:"courseId", type:"int", useNull:true},
		{name:"courseName", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"jobCode", type:"string"},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobName", type:"string"},
		{name:"mandatory", type:"boolean"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"uuid", type:"string"},
		{name:"validFor", type:"int", useNull:true},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.hr.training.ds.model.JobCourseDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"courseCode", type:"string"},
		{name:"courseId", type:"int", useNull:true},
		{name:"courseId_From",type:"int", useNull:true},
		{name:"courseId_To",type:"int", useNull:true},
		{name:"courseName", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"jobCode", type:"string"},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobId_From",type:"int", useNull:true},
		{name:"jobId_To",type:"int", useNull:true},
		{name:"jobName", type:"string"},
		{name:"mandatory", type:"boolean", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"uuid", type:"string"},
		{name:"validFor", type:"int", useNull:true},
		{name:"validFor_From",type:"int", useNull:true},
		{name:"validFor_To",type:"int", useNull:true}
	]
});
Ext.define("net.nan21.dnet.module.hr.training.ds.param.JobCourseDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
