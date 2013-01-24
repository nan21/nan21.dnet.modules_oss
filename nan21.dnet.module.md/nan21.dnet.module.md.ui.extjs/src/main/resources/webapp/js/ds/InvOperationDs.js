/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.model.InvOperationDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"direction", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"id", type:"int", useNull:true},
		{name:"inventory", type:"string"},
		{name:"inventoryId", type:"int", useNull:true},
		{name:"inventoryName", type:"string"},
		{name:"item", type:"string"},
		{name:"itemCode", type:"string"},
		{name:"itemId", type:"int", useNull:true},
		{name:"locator", type:"string"},
		{name:"locatorId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"subInventory", type:"string"},
		{name:"subInventoryId", type:"int", useNull:true},
		{name:"transactionId", type:"int", useNull:true},
		{name:"transactionLineId", type:"int", useNull:true},
		{name:"uom", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvOperationDs",
	fields: [
		{name:"eventDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
