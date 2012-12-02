/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesDeliveryDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"carrier", type:"string"},
		{name:"carrierId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"confirmed", type:"boolean"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"customer", type:"string"},
		{name:"customerCode", type:"string"},
		{name:"customerId", type:"int", useNull:true},
		{name:"deliveryContact", type:"string"},
		{name:"deliveryContactId", type:"int", useNull:true},
		{name:"deliveryLocation", type:"string"},
		{name:"deliveryLocationId", type:"int", useNull:true},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docNo", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"posted", type:"boolean"},
		{name:"salesOrder", type:"string"},
		{name:"salesOrderId", type:"int", useNull:true},
		{name:"salesOrderUuid", type:"string"},
		{name:"transactionType", type:"string"},
		{name:"transactionTypeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"warehouse", type:"string"},
		{name:"warehouseId", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.sd.order.ds.model.SalesDeliveryDs",
	fields: [
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
