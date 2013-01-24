/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.UserDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accountType", type:"string"},
		{name:"accountTypeId", type:"int", useNull:true},
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dateFormat", type:"string"},
		{name:"dateFormatId", type:"int", useNull:true},
		{name:"decimalSeparator", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"locked", type:"boolean"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"thousandSeparator", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	
	validations: [
		{field: "code", type: 'presence'},
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.UserDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"confirmPassword", type:"string"},
		{name:"inGroup", type:"string"},
		{name:"inGroupId", type:"int", useNull:true},
		{name:"newPassword", type:"string"},
		{name:"withRole", type:"string"},
		{name:"withRoleId", type:"int", useNull:true}
	]
});
