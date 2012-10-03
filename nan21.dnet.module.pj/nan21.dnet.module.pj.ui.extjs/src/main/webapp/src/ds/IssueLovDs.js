/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"summary", type:"string"}
	]});
Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"summary", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.pj.md.ds.param.IssueLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
