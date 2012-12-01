/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsEventLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"dataSourceId", type:"int", useNull:true},
		{name:"dataSourceName", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsEventLovDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"dataSourceId", type:"int", useNull:true},
		{name:"dataSourceId_From",type:"int", useNull:true},
		{name:"dataSourceId_To",type:"int", useNull:true},
		{name:"dataSourceName", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]
});
