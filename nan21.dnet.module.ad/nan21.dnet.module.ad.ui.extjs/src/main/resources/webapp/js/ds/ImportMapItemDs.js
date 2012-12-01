/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataSource", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fileName", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"importMapId", type:"int", useNull:true},
		{name:"importMapName", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"path", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"ukFieldName", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});

Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataSource", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fileName", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"importMapId", type:"int", useNull:true},
		{name:"importMapId_From",type:"int", useNull:true},
		{name:"importMapId_To",type:"int", useNull:true},
		{name:"importMapName", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"path", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"ukFieldName", type:"string"},
		{name:"uuid", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.impex.ds.param.ImportMapItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"importDataSource", type:"string"},
		{name:"importFileLocation", type:"string"},
		{name:"importUkFieldName", type:"string"}
	]
});
