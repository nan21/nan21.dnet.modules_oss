/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BusinessPartnerDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"birthDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"businessObject", type:"string"},
		{name:"className", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"companyName", type:"string"},
		{name:"countryCode", type:"string"},
		{name:"countryId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"firstName", type:"string"},
		{name:"gender", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"identityCardNo", type:"string"},
		{name:"lastName", type:"string"},
		{name:"legalForm", type:"string"},
		{name:"legalFormId", type:"int", useNull:true},
		{name:"middleName", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"passportNo", type:"string"},
		{name:"registrationDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"registrationNo", type:"string"},
		{name:"taxPayerNo", type:"string"},
		{name:"type", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],

	validations: [
		{field: "name", type: 'presence'}
	]
});
