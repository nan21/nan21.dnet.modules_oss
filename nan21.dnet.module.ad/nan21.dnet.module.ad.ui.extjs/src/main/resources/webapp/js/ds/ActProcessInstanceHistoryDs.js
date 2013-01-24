/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"deleteReason", type:"string"},
		{name:"duration", type:"int", useNull:true},
		{name:"durationText", type:"string"},
		{name:"endAction", type:"string"},
		{name:"endTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"id", type:"string"},
		{name:"process", type:"string"},
		{name:"processId", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"processVersion", type:"int", useNull:true},
		{name:"startAction", type:"string"},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startedBy", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"processFullName", type:"string"}
	]
});
