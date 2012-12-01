/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueLinkDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"linkType", type:"string"},
		{name:"linkTypeId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"sourceIssue", type:"string"},
		{name:"sourceIssueId", type:"int", useNull:true},
		{name:"sourceSummary", type:"string"},
		{name:"targetIssue", type:"string"},
		{name:"targetIssueId", type:"int", useNull:true},
		{name:"targetSummary", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueLinkDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"linkType", type:"string"},
		{name:"linkTypeId", type:"int", useNull:true},
		{name:"linkTypeId_From",type:"int", useNull:true},
		{name:"linkTypeId_To",type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"sourceIssue", type:"string"},
		{name:"sourceIssueId", type:"int", useNull:true},
		{name:"sourceIssueId_From",type:"int", useNull:true},
		{name:"sourceIssueId_To",type:"int", useNull:true},
		{name:"sourceSummary", type:"string"},
		{name:"targetIssue", type:"string"},
		{name:"targetIssueId", type:"int", useNull:true},
		{name:"targetIssueId_From",type:"int", useNull:true},
		{name:"targetIssueId_To",type:"int", useNull:true},
		{name:"targetSummary", type:"string"},
		{name:"uuid", type:"string"}
	]
});
