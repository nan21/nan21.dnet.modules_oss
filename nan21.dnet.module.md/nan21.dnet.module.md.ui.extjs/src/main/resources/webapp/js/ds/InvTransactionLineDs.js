/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionLineDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fromInventoryId", type:"int", useNull:true},
		{name:"fromLocator", type:"string"},
		{name:"fromLocatorId", type:"int", useNull:true},
		{name:"fromSubInventory", type:"string"},
		{name:"fromSubInventoryId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"item", type:"string"},
		{name:"itemCode", type:"string"},
		{name:"itemId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"toInventoryId", type:"int", useNull:true},
		{name:"toLocator", type:"string"},
		{name:"toLocatorId", type:"int", useNull:true},
		{name:"toSubInventory", type:"string"},
		{name:"toSubInventoryId", type:"int", useNull:true},
		{name:"transactionId", type:"int", useNull:true},
		{name:"uom", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],

	validations: [
		{field: "itemCode", type: 'presence'},
		{field: "quantity", type: 'presence'},
		{field: "uom", type: 'presence'}
	]
});
