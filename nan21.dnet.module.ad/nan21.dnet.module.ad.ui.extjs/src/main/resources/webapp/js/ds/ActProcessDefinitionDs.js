/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"category", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"deploymentId", type:"string"},
		{name:"diagramResourceName", type:"string"},
		{name:"fullName", type:"string"},
		{name:"hasStartForm", type:"boolean"},
		{name:"id", type:"string"},
		{name:"key", type:"string"},
		{name:"name", type:"string"},
		{name:"procDefVersion", type:"int", useNull:true},
		{name:"resourceName", type:"string"}
	]});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"category", type:"string"},
		{name:"deploymentId", type:"string"},
		{name:"diagramResourceName", type:"string"},
		{name:"fullName", type:"string"},
		{name:"hasStartForm", type:"boolean", useNull:true},
		{name:"id", type:"string"},
		{name:"key", type:"string"},
		{name:"name", type:"string"},
		{name:"procDefVersion", type:"int", useNull:true},
		{name:"procDefVersion_From",type:"int", useNull:true},
		{name:"procDefVersion_To",type:"int", useNull:true},
		{name:"resourceName", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActProcessDefinitionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"deployment", type:"string"}
	]
});
