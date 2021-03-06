/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueRoadmapDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fixedInVersion", type:"string"},
		{name:"fixedInVersionId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"project", type:"string"},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectName", type:"string"},
		{name:"status", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"summary", type:"string"},
		{name:"targetVersion", type:"string"},
		{name:"targetVersionDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"targetVersionId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.pj.md.ds.model.IssueRoadmapDs",
	fields: [
		{name:"targetVersionDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"targetVersionDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
