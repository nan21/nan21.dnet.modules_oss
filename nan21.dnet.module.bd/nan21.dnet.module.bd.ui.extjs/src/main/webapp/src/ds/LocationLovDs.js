/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"asString", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"targetType", type:"string"},
		{name:"targetUuid", type:"string"}
	]});
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"asString", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"targetType", type:"string"},
		{name:"targetUuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.LocationLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
