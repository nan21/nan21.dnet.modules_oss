/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.base.tax.ds.model.TaxAcctDs", {
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
		{name:"nonDeductAccount", type:"string"},
		{name:"nonDeductAccountId", type:"int", useNull:true},
		{name:"nonDeductAccountName", type:"string"},
		{name:"purchaseAccount", type:"string"},
		{name:"purchaseAccountId", type:"int", useNull:true},
		{name:"purchaseAccountName", type:"string"},
		{name:"salesAccount", type:"string"},
		{name:"salesAccountId", type:"int", useNull:true},
		{name:"salesAccountName", type:"string"},
		{name:"tax", type:"string"},
		{name:"taxId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
