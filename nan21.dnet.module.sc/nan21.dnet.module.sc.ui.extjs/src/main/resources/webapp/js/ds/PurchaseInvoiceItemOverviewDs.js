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
	]});

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemOverviewDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"confirmed", type:"boolean", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"customerCode", type:"string"},
		{name:"customerId", type:"int", useNull:true},
		{name:"customerId_From",type:"int", useNull:true},
		{name:"customerId_To",type:"int", useNull:true},
		{name:"customerName", type:"string"},
		{name:"description", type:"string"},
		{name:"docCode", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docId", type:"int", useNull:true},
		{name:"docId_From",type:"int", useNull:true},
		{name:"docId_To",type:"int", useNull:true},
		{name:"docNo", type:"string"},
		{name:"docType", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docTypeId_From",type:"int", useNull:true},
		{name:"docTypeId_To",type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"entryMode", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"lineAmount", type:"float", useNull:true},
		{name:"lineAmount_From",type:"float", useNull:true},
		{name:"lineAmount_To",type:"float", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"netAmount", type:"float", useNull:true},
		{name:"netAmount_From",type:"float", useNull:true},
		{name:"netAmount_To",type:"float", useNull:true},
		{name:"posted", type:"boolean", useNull:true},
		{name:"productCode", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productId_From",type:"int", useNull:true},
		{name:"productId_To",type:"int", useNull:true},
		{name:"productName", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"quantity_From",type:"float", useNull:true},
		{name:"quantity_To",type:"float", useNull:true},
		{name:"supplierCode", type:"string"},
		{name:"supplierId", type:"int", useNull:true},
		{name:"supplierId_From",type:"int", useNull:true},
		{name:"supplierId_To",type:"int", useNull:true},
		{name:"supplierName", type:"string"},
		{name:"tax", type:"string"},
		{name:"taxAmount", type:"float", useNull:true},
		{name:"taxAmount_From",type:"float", useNull:true},
		{name:"taxAmount_To",type:"float", useNull:true},
		{name:"taxId", type:"int", useNull:true},
		{name:"taxId_From",type:"int", useNull:true},
		{name:"taxId_To",type:"int", useNull:true},
		{name:"unitPrice", type:"float", useNull:true},
		{name:"unitPrice_From",type:"float", useNull:true},
		{name:"unitPrice_To",type:"float", useNull:true},
		{name:"uomCode", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomId_From",type:"int", useNull:true},
		{name:"uomId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
