/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.base.tax.ds.model.TaxAcctDs" ,{
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
	]});
Ext.define("net.nan21.dnet.module.md.base.tax.ds.model.TaxAcctDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"nonDeductAccount", type:"string"},
		{name:"nonDeductAccountId", type:"int", useNull:true},
		{name:"nonDeductAccountId_From",type:"int", useNull:true},
		{name:"nonDeductAccountId_To",type:"int", useNull:true},
		{name:"nonDeductAccountName", type:"string"},
		{name:"purchaseAccount", type:"string"},
		{name:"purchaseAccountId", type:"int", useNull:true},
		{name:"purchaseAccountId_From",type:"int", useNull:true},
		{name:"purchaseAccountId_To",type:"int", useNull:true},
		{name:"purchaseAccountName", type:"string"},
		{name:"salesAccount", type:"string"},
		{name:"salesAccountId", type:"int", useNull:true},
		{name:"salesAccountId_From",type:"int", useNull:true},
		{name:"salesAccountId_To",type:"int", useNull:true},
		{name:"salesAccountName", type:"string"},
		{name:"tax", type:"string"},
		{name:"taxId", type:"int", useNull:true},
		{name:"taxId_From",type:"int", useNull:true},
		{name:"taxId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.md.base.tax.ds.param.TaxAcctDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
