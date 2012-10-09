/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.org.ds.model.FinancialAccountAcctDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"depositAccount", type:"string"},
		{name:"depositAccountId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"financialAccount", type:"string"},
		{name:"financialAccountId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"withdrawalAccount", type:"string"},
		{name:"withdrawalAccountId", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.md.org.ds.model.FinancialAccountAcctDsFilter" ,{
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
		{name:"depositAccount", type:"string"},
		{name:"depositAccountId", type:"int", useNull:true},
		{name:"depositAccountId_From",type:"int", useNull:true},
		{name:"depositAccountId_To",type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"financialAccount", type:"string"},
		{name:"financialAccountId", type:"int", useNull:true},
		{name:"financialAccountId_From",type:"int", useNull:true},
		{name:"financialAccountId_To",type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"uuid", type:"string"},
		{name:"withdrawalAccount", type:"string"},
		{name:"withdrawalAccountId", type:"int", useNull:true},
		{name:"withdrawalAccountId_From",type:"int", useNull:true},
		{name:"withdrawalAccountId_To",type:"int", useNull:true}
	]
});
Ext.define("net.nan21.dnet.module.md.org.ds.param.FinancialAccountAcctDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
