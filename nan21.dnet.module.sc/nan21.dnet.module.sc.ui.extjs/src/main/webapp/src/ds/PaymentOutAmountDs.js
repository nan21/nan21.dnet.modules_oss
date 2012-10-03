/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutAmountDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"amount", type:"float", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dueAmount", type:"float", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"expectedAmount", type:"float", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"invoiceCode", type:"string"},
		{name:"invoiceDocDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"invoiceDocNo", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"payedAmount", type:"float", useNull:true},
		{name:"paymentId", type:"int", useNull:true},
		{name:"txAmountId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutAmountDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"amount", type:"float", useNull:true},
		{name:"amount_From",type:"float", useNull:true},
		{name:"amount_To",type:"float", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dueAmount", type:"float", useNull:true},
		{name:"dueAmount_From",type:"float", useNull:true},
		{name:"dueAmount_To",type:"float", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"expectedAmount", type:"float", useNull:true},
		{name:"expectedAmount_From",type:"float", useNull:true},
		{name:"expectedAmount_To",type:"float", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"invoiceCode", type:"string"},
		{name:"invoiceDocDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"invoiceDocDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"invoiceDocDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"invoiceDocNo", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"payedAmount", type:"float", useNull:true},
		{name:"payedAmount_From",type:"float", useNull:true},
		{name:"payedAmount_To",type:"float", useNull:true},
		{name:"paymentId", type:"int", useNull:true},
		{name:"paymentId_From",type:"int", useNull:true},
		{name:"paymentId_To",type:"int", useNull:true},
		{name:"txAmountId", type:"int", useNull:true},
		{name:"txAmountId_From",type:"int", useNull:true},
		{name:"txAmountId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.sc.invoice.ds.param.PaymentOutAmountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
