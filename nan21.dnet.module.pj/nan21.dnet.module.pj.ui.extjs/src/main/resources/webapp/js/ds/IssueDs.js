/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"assignee", type:"string"},
		{name:"assigneeId", type:"int", useNull:true},
		{name:"assigneeRole", type:"string"},
		{name:"assigneeRoleId", type:"int", useNull:true},
		{name:"businessObject", type:"string"},
		{name:"businessValue", type:"int", useNull:true},
		{name:"clarity", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"entityFQN", type:"string"},
		{name:"estimatedEffort", type:"int", useNull:true},
		{name:"fixedInVersion", type:"string"},
		{name:"fixedInVersionId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"priority", type:"string"},
		{name:"priorityId", type:"int", useNull:true},
		{name:"project", type:"string"},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectName", type:"string"},
		{name:"reportedVersion", type:"string"},
		{name:"reportedVersionId", type:"int", useNull:true},
		{name:"resolution", type:"string"},
		{name:"resolutionDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"resolutionId", type:"int", useNull:true},
		{name:"severity", type:"string"},
		{name:"severityId", type:"int", useNull:true},
		{name:"status", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"summary", type:"string"},
		{name:"targetVersion", type:"string"},
		{name:"targetVersionId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	validations: [
		{field: "summary", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"affectedComponent", type:"string"},
		{name:"affectedComponentId", type:"int", useNull:true},
		{name:"affectedVersion", type:"string"},
		{name:"affectedVersionId", type:"int", useNull:true}
	]
});
