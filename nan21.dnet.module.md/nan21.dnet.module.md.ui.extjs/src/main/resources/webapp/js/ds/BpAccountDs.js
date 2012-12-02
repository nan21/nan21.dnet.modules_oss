/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpAccountDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"analiticSegment", type:"string"},
		{name:"businessPartnerCode", type:"string"},
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"businessPartnerName", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"custAnaliticSegment", type:"string"},
		{name:"customer", type:"boolean"},
		{name:"customerCreditLimit", type:"float", useNull:true},
		{name:"customerGroup", type:"string"},
		{name:"customerGroupId", type:"int", useNull:true},
		{name:"customerPaymentMethod", type:"string"},
		{name:"customerPaymentMethodId", type:"int", useNull:true},
		{name:"customerPaymentTerm", type:"string"},
		{name:"customerPaymentTermId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"vendAnaliticSegment", type:"string"},
		{name:"vendor", type:"boolean"},
		{name:"vendorCreditLimit", type:"float", useNull:true},
		{name:"vendorGroup", type:"string"},
		{name:"vendorGroupId", type:"int", useNull:true},
		{name:"vendorPaymentMethod", type:"string"},
		{name:"vendorPaymentMethodId", type:"int", useNull:true},
		{name:"vendorPaymentTerm", type:"string"},
		{name:"vendorPaymentTermId", type:"int", useNull:true},
		{name:"version", type:"int", useNull:true}
	]
});
