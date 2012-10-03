/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.base.ds.model.IssueTaskStatusLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]});
Ext.define("net.nan21.dnet.module.pj.base.ds.model.IssueTaskStatusLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.pj.base.ds.param.IssueTaskStatusLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
