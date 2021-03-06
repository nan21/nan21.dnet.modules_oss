/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.AccessControlDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	
	validations: [
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.AccessControlDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"copyFrom", type:"string"},
		{name:"copyFromId", type:"int", useNull:true},
		{name:"resetRules", type:"boolean"},
		{name:"skipAsgn", type:"boolean"},
		{name:"skipDs", type:"boolean"},
		{name:"withRole", type:"string"},
		{name:"withRoleId", type:"int", useNull:true}
	]
});
