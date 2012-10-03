/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.org.ds.model.CarrierOrganizationLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"carrier", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]});
Ext.define("net.nan21.dnet.module.bd.org.ds.model.CarrierOrganizationLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"carrier", type:"boolean", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.bd.org.ds.param.CarrierOrganizationLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
