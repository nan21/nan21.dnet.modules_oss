/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"calendar", type:"string"},
		{name:"calendarId", type:"int", useNull:true},
		{name:"className", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"valid", type:"boolean"},
		{name:"version", type:"int", useNull:true}
	],
	validations: [
		{field: "code", type: 'presence'},
		{field: "name", type: 'presence'}
	]

});
