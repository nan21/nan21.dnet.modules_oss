/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.elem.ds.model.EngineLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"type", type:"string"}
	]});
Ext.define("net.nan21.dnet.module.bd.elem.ds.model.EngineLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"type", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.bd.elem.ds.param.EngineLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
