/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActAvailableTaskDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"executionId", type:"string"},
		{name:"id", type:"string"},
		{name:"name", type:"string"},
		{name:"owner", type:"string"},
		{name:"priority", type:"int", useNull:true},
		{name:"process", type:"string"},
		{name:"processId", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"taskKey", type:"string"}
	]});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActAvailableTaskDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"description", type:"string"},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"executionId", type:"string"},
		{name:"id", type:"string"},
		{name:"name", type:"string"},
		{name:"owner", type:"string"},
		{name:"priority", type:"int", useNull:true},
		{name:"priority_From",type:"int", useNull:true},
		{name:"priority_To",type:"int", useNull:true},
		{name:"process", type:"string"},
		{name:"processId", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startTime_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startTime_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"taskKey", type:"string"}
	]
});
