/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
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

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.UserDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accountType", type:"string"},
		{name:"accountTypeId", type:"int", useNull:true},
		{name:"accountTypeId_From",type:"int", useNull:true},
		{name:"accountTypeId_To",type:"int", useNull:true},
		{name:"active", type:"boolean", useNull:true},
		{name:"code", type:"string"},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dateFormat", type:"string"},
		{name:"dateFormatId", type:"int", useNull:true},
		{name:"dateFormatId_From",type:"int", useNull:true},
		{name:"dateFormatId_To",type:"int", useNull:true},
		{name:"decimalSeparator", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"locked", type:"boolean", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"thousandSeparator", type:"string"},
		{name:"uuid", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.param.UserDsParam", {
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
