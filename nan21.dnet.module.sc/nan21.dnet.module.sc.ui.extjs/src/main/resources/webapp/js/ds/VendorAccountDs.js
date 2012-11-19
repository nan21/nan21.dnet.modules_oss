/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.account.ds.model.VendorAccountDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"analiticSegment", type:"string"},
		{name:"businessPartnerCode", type:"string"},
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"businessPartnerName", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"creditLimit", type:"float", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentTerm", type:"string"},
		{name:"paymentTermId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"vendAnaliticSegment", type:"string"},
		{name:"vendor", type:"boolean"},
		{name:"vendorGroup", type:"string"},
		{name:"vendorGroupId", type:"int", useNull:true},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.sc.account.ds.model.VendorAccountDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"analiticSegment", type:"string"},
		{name:"businessPartnerCode", type:"string"},
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"businessPartnerId_From",type:"int", useNull:true},
		{name:"businessPartnerId_To",type:"int", useNull:true},
		{name:"businessPartnerName", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"creditLimit", type:"float", useNull:true},
		{name:"creditLimit_From",type:"float", useNull:true},
		{name:"creditLimit_To",type:"float", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"orgId_From",type:"int", useNull:true},
		{name:"orgId_To",type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethodId_From",type:"int", useNull:true},
		{name:"paymentMethodId_To",type:"int", useNull:true},
		{name:"paymentTerm", type:"string"},
		{name:"paymentTermId", type:"int", useNull:true},
		{name:"paymentTermId_From",type:"int", useNull:true},
		{name:"paymentTermId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"vendAnaliticSegment", type:"string"},
		{name:"vendor", type:"boolean", useNull:true},
		{name:"vendorGroup", type:"string"},
		{name:"vendorGroupId", type:"int", useNull:true},
		{name:"vendorGroupId_From",type:"int", useNull:true},
		{name:"vendorGroupId_To",type:"int", useNull:true}
	]
});
Ext.define("net.nan21.dnet.module.sc.account.ds.param.VendorAccountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
