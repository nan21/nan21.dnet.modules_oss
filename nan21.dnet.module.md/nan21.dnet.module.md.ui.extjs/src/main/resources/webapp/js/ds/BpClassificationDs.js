/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpClassificationDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"businessPartner", type:"string"},
		{name:"businessPartnerBO", type:"string"},
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"classificationCode", type:"string"},
		{name:"classificationId", type:"int", useNull:true},
		{name:"classificationName", type:"string"},
		{name:"classificationSystem", type:"string"},
		{name:"classificationSystemId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
