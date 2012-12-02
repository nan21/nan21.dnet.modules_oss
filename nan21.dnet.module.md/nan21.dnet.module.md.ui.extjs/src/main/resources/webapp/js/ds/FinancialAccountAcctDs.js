/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.org.ds.model.FinancialAccountAcctDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"depositAccount", type:"string"},
		{name:"depositAccountId", type:"int", useNull:true},
		{name:"depositAccountName", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"financialAccount", type:"string"},
		{name:"financialAccountId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"withdrawalAccount", type:"string"},
		{name:"withdrawalAccountId", type:"int", useNull:true},
		{name:"withdrawalAccountName", type:"string"}
	]
});
