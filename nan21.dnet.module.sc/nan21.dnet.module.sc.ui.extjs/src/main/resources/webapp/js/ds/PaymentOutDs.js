/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"amount", type:"float", useNull:true},
		{name:"bpartner", type:"string"},
		{name:"bpartnerCode", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
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
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethodType", type:"string"},
		{name:"posted", type:"boolean"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"amount", type:"float", useNull:true},
		{name:"amount_From",type:"float", useNull:true},
		{name:"amount_To",type:"float", useNull:true},
		{name:"bpartner", type:"string"},
		{name:"bpartnerCode", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartnerId_From",type:"int", useNull:true},
		{name:"bpartnerId_To",type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"confirmed", type:"boolean", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docNo", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fromAccount", type:"string"},
		{name:"fromAccountId", type:"int", useNull:true},
		{name:"fromAccountId_From",type:"int", useNull:true},
		{name:"fromAccountId_To",type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"orgId_From",type:"int", useNull:true},
		{name:"orgId_To",type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethodId_From",type:"int", useNull:true},
		{name:"paymentMethodId_To",type:"int", useNull:true},
		{name:"paymentMethodType", type:"string"},
		{name:"posted", type:"boolean", useNull:true},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.sc.invoice.ds.param.PaymentOutDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
