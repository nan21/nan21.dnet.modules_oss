/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.BookmarkDs", {
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
		{name:"leafNode", type:"boolean"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"owner", type:"string"},
		{name:"parent", type:"string"},
		{name:"parentId", type:"int", useNull:true},
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
