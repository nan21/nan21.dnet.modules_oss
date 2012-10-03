/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpClassificationDs" ,{
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
	]});
Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpClassificationDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"businessPartner", type:"string"},
		{name:"businessPartnerBO", type:"string"},
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"businessPartnerId_From",type:"int", useNull:true},
		{name:"businessPartnerId_To",type:"int", useNull:true},
		{name:"classificationCode", type:"string"},
		{name:"classificationId", type:"int", useNull:true},
		{name:"classificationId_From",type:"int", useNull:true},
		{name:"classificationId_To",type:"int", useNull:true},
		{name:"classificationName", type:"string"},
		{name:"classificationSystem", type:"string"},
		{name:"classificationSystemId", type:"int", useNull:true},
		{name:"classificationSystemId_From",type:"int", useNull:true},
		{name:"classificationSystemId_To",type:"int", useNull:true},
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
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.md.bp.ds.param.BpClassificationDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
