/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.data.ds.model.AttachmentDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"baseUrl", type:"string"},
		{name:"category", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"location", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"targetType", type:"string"},
		{name:"targetUuid", type:"string"},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"url", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	validations: [
		{field: "type", type: 'presence'},
		{field: "name", type: 'presence'}
	]});
Ext.define("net.nan21.dnet.module.ad.data.ds.model.AttachmentDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"baseUrl", type:"string"},
		{name:"category", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"location", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"targetType", type:"string"},
		{name:"targetUuid", type:"string"},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"url", type:"string"},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.ad.data.ds.param.AttachmentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
