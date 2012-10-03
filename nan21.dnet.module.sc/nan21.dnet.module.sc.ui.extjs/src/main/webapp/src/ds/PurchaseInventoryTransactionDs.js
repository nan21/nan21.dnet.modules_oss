/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseInventoryTransactionDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fromInventory", type:"string"},
		{name:"fromInventoryId", type:"int", useNull:true},
		{name:"hasFromInventory", type:"boolean"},
		{name:"hasToInventory", type:"boolean"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"supplier", type:"string"},
		{name:"supplierId", type:"int", useNull:true},
		{name:"toInventory", type:"string"},
		{name:"toInventoryId", type:"int", useNull:true},
		{name:"transactionType", type:"string"},
		{name:"transactionTypeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseInventoryTransactionDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fromInventory", type:"string"},
		{name:"fromInventoryId", type:"int", useNull:true},
		{name:"fromInventoryId_From",type:"int", useNull:true},
		{name:"fromInventoryId_To",type:"int", useNull:true},
		{name:"hasFromInventory", type:"boolean", useNull:true},
		{name:"hasToInventory", type:"boolean", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"supplier", type:"string"},
		{name:"supplierId", type:"int", useNull:true},
		{name:"supplierId_From",type:"int", useNull:true},
		{name:"supplierId_To",type:"int", useNull:true},
		{name:"toInventory", type:"string"},
		{name:"toInventoryId", type:"int", useNull:true},
		{name:"toInventoryId_From",type:"int", useNull:true},
		{name:"toInventoryId_To",type:"int", useNull:true},
		{name:"transactionType", type:"string"},
		{name:"transactionTypeId", type:"int", useNull:true},
		{name:"transactionTypeId_From",type:"int", useNull:true},
		{name:"transactionTypeId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.sc.order.ds.param.PurchaseInventoryTransactionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
