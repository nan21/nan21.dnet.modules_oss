/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountOverviewDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"customer", type:"string"},
		{name:"customerId", type:"int", useNull:true},
		{name:"dueAmount", type:"float", useNull:true},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueInDays", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"invoiceCode", type:"string"},
		{name:"invoiceDocDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"invoiceDocNo", type:"string"},
		{name:"invoiceId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"orderId", type:"int", useNull:true},
		{name:"outstandingAmount", type:"float", useNull:true},
		{name:"payedAmount", type:"float", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"supplier", type:"string"},
		{name:"supplierCode", type:"string"},
		{name:"supplierId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountOverviewDs",
	fields: [
		{name:"dueDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueAmount_From",type:"float", useNull:true},
		{name:"dueAmount_To",type:"float", useNull:true},
		{name:"payedAmount_From",type:"float", useNull:true},
		{name:"payedAmount_To",type:"float", useNull:true},
		{name:"outstandingAmount_From",type:"float", useNull:true},
		{name:"outstandingAmount_To",type:"float", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountOverviewDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"overDue", type:"boolean"}
	]
});
