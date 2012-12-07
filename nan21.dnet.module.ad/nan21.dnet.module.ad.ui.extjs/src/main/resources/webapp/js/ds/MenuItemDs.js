/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.MenuItemDs", {
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
		{name:"iconUrl", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"menu", type:"string"},
		{name:"menuId", type:"int", useNull:true},
		{name:"menuItem", type:"string"},
		{name:"menuItemId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"separatorAfter", type:"boolean"},
		{name:"separatorBefore", type:"boolean"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"title", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	
	validations: [
		{field: "name", type: 'presence'}
	]
});
