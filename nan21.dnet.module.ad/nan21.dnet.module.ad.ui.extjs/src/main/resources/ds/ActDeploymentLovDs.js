/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"fullName", type:"string"},
		{name:"id", type:"string"},
		{name:"name", type:"string"}
	]});
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"fullName", type:"string"},
		{name:"id", type:"string"},
		{name:"name", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActDeploymentLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
