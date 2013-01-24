/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskHistoryDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"deleteReason", type:"string"},
		{name:"description", type:"string"},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"duration", type:"int", useNull:true},
		{name:"durationText", type:"string"},
		{name:"endTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
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
	]
});
