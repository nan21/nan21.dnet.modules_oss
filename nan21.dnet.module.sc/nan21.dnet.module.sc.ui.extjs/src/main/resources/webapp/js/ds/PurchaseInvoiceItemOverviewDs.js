/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemOverviewDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"confirmed", type:"boolean"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"customerCode", type:"string"},
		{name:"customerId", type:"int", useNull:true},
		{name:"customerName", type:"string"},
		{name:"description", type:"string"},
		{name:"docCode", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docId", type:"int", useNull:true},
		{name:"docNo", type:"string"},
		{name:"docType", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"entryMode", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"lineAmount", type:"float", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"netAmount", type:"float", useNull:true},
		{name:"posted", type:"boolean"},
		{name:"productCode", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productName", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"supplierCode", type:"string"},
		{name:"supplierId", type:"int", useNull:true},
		{name:"supplierName", type:"string"},
		{name:"tax", type:"string"},
		{name:"taxAmount", type:"float", useNull:true},
		{name:"taxId", type:"int", useNull:true},
		{name:"unitPrice", type:"float", useNull:true},
		{name:"uomCode", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemOverviewDs",
	fields: [
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
