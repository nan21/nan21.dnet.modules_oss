/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseInventoryTransactionDs", {
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
	]
});
