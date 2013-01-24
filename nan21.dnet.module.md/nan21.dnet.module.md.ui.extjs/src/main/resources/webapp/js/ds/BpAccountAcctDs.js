/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpAccountAcctDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"bpAccountId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"custPrepayAccount", type:"string"},
		{name:"custPrepayAccountId", type:"int", useNull:true},
		{name:"custSalesAccount", type:"string"},
		{name:"custSalesAccountId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"uuid", type:"string"},
		{name:"vendorPrepayAccount", type:"string"},
		{name:"vendorPrepayAccountId", type:"int", useNull:true},
		{name:"vendorPurchaseAccount", type:"string"},
		{name:"vendorPurchaseAccountId", type:"int", useNull:true},
		{name:"version", type:"int", useNull:true}
	]
});
