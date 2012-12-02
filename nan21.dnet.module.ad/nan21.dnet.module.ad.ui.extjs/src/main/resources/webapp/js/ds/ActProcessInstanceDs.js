/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
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

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"from", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"processFullName", type:"string"},
		{name:"reasonToKill", type:"string"},
		{name:"to", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
