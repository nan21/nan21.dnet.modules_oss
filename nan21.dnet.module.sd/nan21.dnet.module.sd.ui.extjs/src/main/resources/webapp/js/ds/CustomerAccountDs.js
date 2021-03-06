/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sd.account.ds.model.CustomerAccountDs", {
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
		{name:"custAnaliticSegment", type:"string"},
		{name:"customer", type:"boolean"},
		{name:"customerGroup", type:"string"},
		{name:"customerGroupId", type:"int", useNull:true},
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
		{name:"version", type:"int", useNull:true}
	]
});
