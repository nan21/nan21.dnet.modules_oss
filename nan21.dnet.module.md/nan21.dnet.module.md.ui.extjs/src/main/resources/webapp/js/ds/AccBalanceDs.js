/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.acc.ds.model.AccBalanceDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"account", type:"string"},
		{name:"amount", type:"float", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"initialAmount", type:"float", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"period", type:"string"},
		{name:"periodId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.md.tx.acc.ds.model.AccBalanceDs",
	fields: [
		{name:"amount_From",type:"float", useNull:true},
		{name:"amount_To",type:"float", useNull:true},
		{name:"initialAmount_From",type:"float", useNull:true},
		{name:"initialAmount_To",type:"float", useNull:true}
	]
});
