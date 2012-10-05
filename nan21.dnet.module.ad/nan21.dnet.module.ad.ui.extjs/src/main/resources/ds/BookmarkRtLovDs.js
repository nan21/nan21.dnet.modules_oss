/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.BookmarkRtLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"bundle", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"frame", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"leaf", type:"boolean"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"parent", type:"string"},
		{name:"parentId", type:"int", useNull:true},
		{name:"separatorAfter", type:"boolean"},
		{name:"separatorBefore", type:"boolean"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"text", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	validations: [
		{field: "name", type: 'presence'}
	]
});
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.BookmarkRtLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"bundle", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"frame", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"leaf", type:"boolean", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"parent", type:"string"},
		{name:"parentId", type:"int", useNull:true},
		{name:"parentId_From",type:"int", useNull:true},
		{name:"parentId_To",type:"int", useNull:true},
		{name:"separatorAfter", type:"boolean", useNull:true},
		{name:"separatorBefore", type:"boolean", useNull:true},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"text", type:"string"},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.BookmarkRtLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
