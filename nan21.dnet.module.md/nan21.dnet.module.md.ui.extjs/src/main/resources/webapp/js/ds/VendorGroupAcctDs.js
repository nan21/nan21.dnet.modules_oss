/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.bp.ds.model.VendorGroupAcctDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"prepayAccount", type:"string"},
		{name:"prepayAccountId", type:"int", useNull:true},
		{name:"prepayAccountName", type:"string"},
		{name:"purchaseAccount", type:"string"},
		{name:"purchaseAccountId", type:"int", useNull:true},
		{name:"purchaseAccountName", type:"string"},
		{name:"uuid", type:"string"},
		{name:"vendorGroup", type:"string"},
		{name:"vendorGroupId", type:"int", useNull:true},
		{name:"version", type:"int", useNull:true}
	]
});
