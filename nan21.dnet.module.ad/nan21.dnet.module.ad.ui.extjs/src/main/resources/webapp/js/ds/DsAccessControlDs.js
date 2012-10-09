/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accessControl", type:"string"},
		{name:"accessControlId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"deleteAllowed", type:"boolean"},
		{name:"dsName", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"exportAllowed", type:"boolean"},
		{name:"id", type:"int", useNull:true},
		{name:"importAllowed", type:"boolean"},
		{name:"insertAllowed", type:"boolean"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"queryAllowed", type:"boolean"},
		{name:"updateAllowed", type:"boolean"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accessControl", type:"string"},
		{name:"accessControlId", type:"int", useNull:true},
		{name:"accessControlId_From",type:"int", useNull:true},
		{name:"accessControlId_To",type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"deleteAllowed", type:"boolean", useNull:true},
		{name:"dsName", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"exportAllowed", type:"boolean", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"importAllowed", type:"boolean", useNull:true},
		{name:"insertAllowed", type:"boolean", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"queryAllowed", type:"boolean", useNull:true},
		{name:"updateAllowed", type:"boolean", useNull:true},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.DsAccessControlDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
