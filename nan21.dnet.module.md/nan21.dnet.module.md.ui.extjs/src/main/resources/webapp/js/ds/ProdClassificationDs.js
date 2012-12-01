/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProdClassificationDs", {
	extend: 'Ext.data.Model',
	fields: [
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
		{name:"productCode", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProdClassificationDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
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
		{name:"productCode", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productId_From",type:"int", useNull:true},
		{name:"productId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
