/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.client.ds.model.ClientDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"adminRole", type:"string"},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"defaultDsAccessRule", type:"string"},
		{name:"defaultExportPath", type:"string"},
		{name:"defaultImportPath", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"maintenanceLanguage", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"systemClient", type:"boolean"},
		{name:"tempPath", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.ad.client.ds.model.ClientDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"adminRole", type:"string"},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"defaultDsAccessRule", type:"string"},
		{name:"defaultExportPath", type:"string"},
		{name:"defaultImportPath", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"maintenanceLanguage", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"systemClient", type:"boolean", useNull:true},
		{name:"tempPath", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.ad.client.ds.param.ClientDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"adminPassword", type:"string"},
		{name:"adminUserCode", type:"string"},
		{name:"adminUserName", type:"string"}
	]
});
