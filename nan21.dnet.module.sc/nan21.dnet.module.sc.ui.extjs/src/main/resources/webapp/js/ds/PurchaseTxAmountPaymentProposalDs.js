/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountPaymentProposalDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currentPayment", type:"float", useNull:true},
		{name:"dueAmount", type:"float", useNull:true},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"invoiceCode", type:"string"},
		{name:"invoiceDocDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"invoiceDocNo", type:"string"},
		{name:"invoiceId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"orderCode", type:"string"},
		{name:"orderDocDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"orderDocNo", type:"string"},
		{name:"orderId", type:"int", useNull:true},
		{name:"orgId", type:"int", useNull:true},
		{name:"outstandingAmount", type:"float", useNull:true},
		{name:"payedAmount", type:"float", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"remainingAmount", type:"float", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountPaymentProposalDs",
	fields: [
		{name:"dueDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueAmount_From",type:"float", useNull:true},
		{name:"dueAmount_To",type:"float", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountPaymentProposalDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"businessPartner", type:"string"},
		{name:"paymentCurrency", type:"string"},
		{name:"paymentId", type:"int", useNull:true},
		{name:"receivedAmount", type:"float", useNull:true},
		{name:"unAllocatedAmount", type:"float", useNull:true}
	]
});
