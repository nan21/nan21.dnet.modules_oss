/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"planDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"projectId", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"planDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"planDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"planDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectId_From",type:"int", useNull:true},
		{name:"projectId_To",type:"int", useNull:true}
	]
});
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectVersionLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
