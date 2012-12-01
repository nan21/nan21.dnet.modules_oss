/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.MenuItemRtLovDs", {
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
		{name:"menu", type:"string"},
		{name:"menuId", type:"int", useNull:true},
		{name:"menuItem", type:"string"},
		{name:"menuItemId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"text", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	validations: [
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.MenuItemRtLovDsFilter", {
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
		{name:"menu", type:"string"},
		{name:"menuId", type:"int", useNull:true},
		{name:"menuId_From",type:"int", useNull:true},
		{name:"menuId_To",type:"int", useNull:true},
		{name:"menuItem", type:"string"},
		{name:"menuItemId", type:"int", useNull:true},
		{name:"menuItemId_From",type:"int", useNull:true},
		{name:"menuItemId_To",type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"text", type:"string"},
		{name:"uuid", type:"string"}
	]
});
