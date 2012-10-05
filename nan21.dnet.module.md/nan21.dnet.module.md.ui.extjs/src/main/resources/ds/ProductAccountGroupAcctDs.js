/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountGroupAcctDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"expenseAccount", type:"string"},
		{name:"expenseAccountId", type:"int", useNull:true},
		{name:"expenseAccountName", type:"string"},
		{name:"group", type:"string"},
		{name:"groupId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"revenueAccount", type:"string"},
		{name:"revenueAccountId", type:"int", useNull:true},
		{name:"revenueAccountName", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountGroupAcctDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"expenseAccount", type:"string"},
		{name:"expenseAccountId", type:"int", useNull:true},
		{name:"expenseAccountId_From",type:"int", useNull:true},
		{name:"expenseAccountId_To",type:"int", useNull:true},
		{name:"expenseAccountName", type:"string"},
		{name:"group", type:"string"},
		{name:"groupId", type:"int", useNull:true},
		{name:"groupId_From",type:"int", useNull:true},
		{name:"groupId_To",type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"revenueAccount", type:"string"},
		{name:"revenueAccountId", type:"int", useNull:true},
		{name:"revenueAccountId_From",type:"int", useNull:true},
		{name:"revenueAccountId_To",type:"int", useNull:true},
		{name:"revenueAccountName", type:"string"},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.param.ProductAccountGroupAcctDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
