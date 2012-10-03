/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.acc.ds.model.AccountLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]});
Ext.define("net.nan21.dnet.module.md.acc.ds.model.AccountLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"active", type:"boolean", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.md.acc.ds.param.AccountLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
