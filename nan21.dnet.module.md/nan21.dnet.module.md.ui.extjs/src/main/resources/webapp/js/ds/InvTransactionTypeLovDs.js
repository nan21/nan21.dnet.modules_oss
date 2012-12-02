/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionTypeLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"docType", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]
});
