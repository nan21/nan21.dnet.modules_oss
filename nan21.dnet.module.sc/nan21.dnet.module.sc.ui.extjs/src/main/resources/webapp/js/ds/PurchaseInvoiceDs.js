/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"businessObject", type:"string"},
		{name:"className", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"confirmed", type:"boolean"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"customer", type:"string"},
		{name:"customerId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docNo", type:"string"},
		{name:"docType", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"fromAccount", type:"string"},
		{name:"fromAccountId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethodType", type:"string"},
		{name:"paymentTerm", type:"string"},
		{name:"paymentTermId", type:"int", useNull:true},
		{name:"posted", type:"boolean"},
		{name:"purchaseOrderId", type:"int", useNull:true},
		{name:"selfPayed", type:"boolean"},
		{name:"supplier", type:"string"},
		{name:"supplierCode", type:"string"},
		{name:"supplierId", type:"int", useNull:true},
		{name:"supplierUuid", type:"string"},
		{name:"totalAmount", type:"float", useNull:true},
		{name:"totalNetAmount", type:"float", useNull:true},
		{name:"totalTaxAmount", type:"float", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],

	validations: [
		{field: "docDate", type: 'presence'}
	],
	
	initRecord: function() {
		this.set("docDate", new Date());
		this.set("totalNetAmount", 0);
		this.set("totalTaxAmount", 0);
		this.set("totalAmount", 0);
	}
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs",
	fields: [
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"totalNetAmount_From",type:"float", useNull:true},
		{name:"totalNetAmount_To",type:"float", useNull:true},
		{name:"totalAmount_From",type:"float", useNull:true},
		{name:"totalAmount_To",type:"float", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"copyFrom", type:"string"},
		{name:"copyFromId", type:"int", useNull:true}
	]
});
