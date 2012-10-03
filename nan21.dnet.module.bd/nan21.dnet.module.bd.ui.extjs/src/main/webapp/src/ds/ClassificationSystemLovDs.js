/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.standards.ds.model.ClassificationSystemLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"useInContext", type:"string"}
	]});
Ext.define("net.nan21.dnet.module.bd.standards.ds.model.ClassificationSystemLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"useInContext", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.bd.standards.ds.param.ClassificationSystemLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
