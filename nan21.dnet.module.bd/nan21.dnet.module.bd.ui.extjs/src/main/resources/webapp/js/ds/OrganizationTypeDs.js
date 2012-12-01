/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accountingEnabled", type:"boolean"},
		{name:"active", type:"boolean"},
		{name:"carrier", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"external", type:"boolean"},
		{name:"id", type:"int", useNull:true},
		{name:"inventory", type:"boolean"},
		{name:"legalEntity", type:"boolean"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"virtualEntity", type:"boolean"},
		{name:"warehouse", type:"boolean"}
	],
	validations: [
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accountingEnabled", type:"boolean", useNull:true},
		{name:"active", type:"boolean", useNull:true},
		{name:"carrier", type:"boolean", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"external", type:"boolean", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"inventory", type:"boolean", useNull:true},
		{name:"legalEntity", type:"boolean", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"uuid", type:"string"},
		{name:"virtualEntity", type:"boolean", useNull:true},
		{name:"warehouse", type:"boolean", useNull:true}
	]
});
