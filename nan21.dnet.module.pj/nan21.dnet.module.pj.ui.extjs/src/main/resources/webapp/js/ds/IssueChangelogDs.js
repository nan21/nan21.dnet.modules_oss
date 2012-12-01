/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueChangelogDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fixedInVersion", type:"string"},
		{name:"fixedInVersionDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
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
	]});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueChangelogDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fixedInVersion", type:"string"},
		{name:"fixedInVersionDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fixedInVersionDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fixedInVersionDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fixedInVersionId", type:"int", useNull:true},
		{name:"fixedInVersionId_From",type:"int", useNull:true},
		{name:"fixedInVersionId_To",type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"project", type:"string"},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectId_From",type:"int", useNull:true},
		{name:"projectId_To",type:"int", useNull:true},
		{name:"projectName", type:"string"},
		{name:"status", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"statusId_From",type:"int", useNull:true},
		{name:"statusId_To",type:"int", useNull:true},
		{name:"summary", type:"string"},
		{name:"targetVersion", type:"string"},
		{name:"targetVersionDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"targetVersionDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"targetVersionDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"targetVersionId", type:"int", useNull:true},
		{name:"targetVersionId_From",type:"int", useNull:true},
		{name:"targetVersionId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
