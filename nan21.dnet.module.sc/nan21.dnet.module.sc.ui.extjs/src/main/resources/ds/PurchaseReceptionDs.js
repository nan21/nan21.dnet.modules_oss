/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseReceptionDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"carrier", type:"string"},
		{name:"carrierId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"confirmed", type:"boolean"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docNo", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"posted", type:"boolean"},
		{name:"purchaseOrder", type:"string"},
		{name:"purchaseOrderId", type:"int", useNull:true},
		{name:"purchaseOrderUuid", type:"string"},
		{name:"supplier", type:"string"},
		{name:"supplierCode", type:"string"},
		{name:"supplierId", type:"int", useNull:true},
		{name:"transactionType", type:"string"},
		{name:"transactionTypeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"warehouse", type:"string"},
		{name:"warehouseId", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseReceptionDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"carrier", type:"string"},
		{name:"carrierId", type:"int", useNull:true},
		{name:"carrierId_From",type:"int", useNull:true},
		{name:"carrierId_To",type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"confirmed", type:"boolean", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docNo", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"posted", type:"boolean", useNull:true},
		{name:"purchaseOrder", type:"string"},
		{name:"purchaseOrderId", type:"int", useNull:true},
		{name:"purchaseOrderId_From",type:"int", useNull:true},
		{name:"purchaseOrderId_To",type:"int", useNull:true},
		{name:"purchaseOrderUuid", type:"string"},
		{name:"supplier", type:"string"},
		{name:"supplierCode", type:"string"},
		{name:"supplierId", type:"int", useNull:true},
		{name:"supplierId_From",type:"int", useNull:true},
		{name:"supplierId_To",type:"int", useNull:true},
		{name:"transactionType", type:"string"},
		{name:"transactionTypeId", type:"int", useNull:true},
		{name:"transactionTypeId_From",type:"int", useNull:true},
		{name:"transactionTypeId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"warehouse", type:"string"},
		{name:"warehouseId", type:"int", useNull:true},
		{name:"warehouseId_From",type:"int", useNull:true},
		{name:"warehouseId_To",type:"int", useNull:true}
	]
});
Ext.define("net.nan21.dnet.module.sc.order.ds.param.PurchaseReceptionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
