/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"assignee", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"duration", type:"int", useNull:true},
		{name:"durationText", type:"string"},
		{name:"endTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"executionId", type:"string"},
		{name:"id", type:"string"},
		{name:"name", type:"string"},
		{name:"priority", type:"int", useNull:true},
		{name:"process", type:"string"},
		{name:"processId", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"taskKey", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"hideActive", type:"boolean"},
		{name:"hideCompleted", type:"boolean"}
	]
});
