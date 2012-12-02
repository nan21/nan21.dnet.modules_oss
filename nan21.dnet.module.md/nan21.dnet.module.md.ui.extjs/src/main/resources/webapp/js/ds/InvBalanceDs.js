/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.model.InvBalanceDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"inventory", type:"string"},
		{name:"inventoryId", type:"int", useNull:true},
		{name:"item", type:"string"},
		{name:"itemId", type:"int", useNull:true},
		{name:"itemName", type:"string"},
		{name:"locator", type:"string"},
		{name:"locatorId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"subInventory", type:"string"},
		{name:"subInventoryId", type:"int", useNull:true},
		{name:"uom", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
