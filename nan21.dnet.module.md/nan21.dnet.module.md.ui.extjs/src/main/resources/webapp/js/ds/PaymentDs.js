/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.fin.ds.model.PaymentDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"amount", type:"float", useNull:true},
		{name:"businessPartner", type:"string"},
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"confirmed", type:"boolean"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docNo", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fromAccount", type:"string"},
		{name:"fromAccountId", type:"int", useNull:true},
		{name:"fromOrg", type:"string"},
		{name:"fromOrgId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"posted", type:"boolean"},
		{name:"toAccount", type:"string"},
		{name:"toAccountId", type:"int", useNull:true},
		{name:"toOrg", type:"string"},
		{name:"toOrgId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentDs",
	fields: [
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"amount_From",type:"float", useNull:true},
		{name:"amount_To",type:"float", useNull:true}
	]
});
