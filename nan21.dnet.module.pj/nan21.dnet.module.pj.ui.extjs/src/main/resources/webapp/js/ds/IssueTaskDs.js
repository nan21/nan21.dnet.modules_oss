/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueTaskDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"assignee", type:"string"},
		{name:"assigneeId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"issue", type:"string"},
		{name:"issueBusinessObject", type:"string"},
		{name:"issueClassName", type:"string"},
		{name:"issueId", type:"int", useNull:true},
		{name:"issuePriority", type:"string"},
		{name:"issuePriorityId", type:"int", useNull:true},
		{name:"issuePrioritySequenceNo", type:"int", useNull:true},
		{name:"issueSeverity", type:"string"},
		{name:"issueSeverityId", type:"int", useNull:true},
		{name:"issueStatus", type:"string"},
		{name:"issueStatusId", type:"int", useNull:true},
		{name:"issueSummary", type:"string"},
		{name:"issueType", type:"string"},
		{name:"issueTypeId", type:"int", useNull:true},
		{name:"issueUuId", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"project", type:"string"},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectName", type:"string"},
		{name:"status", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
