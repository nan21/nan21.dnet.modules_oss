/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"attributeSet", type:"string"},
		{name:"attributeSetId", type:"int", useNull:true},
		{name:"businessObject", type:"string"},
		{name:"className", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"defaultUomCode", type:"string"},
		{name:"defaultUomId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"description", type:"string"},
		{name:"dimDepth", type:"float", useNull:true},
		{name:"dimHeight", type:"float", useNull:true},
		{name:"dimUomCode", type:"string"},
		{name:"dimUomId", type:"int", useNull:true},
		{name:"dimWidth", type:"float", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"iconUrl", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"imageUrl", type:"string"},
		{name:"manufacturerCode", type:"string"},
		{name:"manufacturerId", type:"int", useNull:true},
		{name:"manufacturerProductNo", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"purchase", type:"boolean"},
		{name:"sale", type:"boolean"},
		{name:"showInCatalog", type:"boolean"},
		{name:"storable", type:"boolean"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"volume", type:"float", useNull:true},
		{name:"volumeUomCode", type:"string"},
		{name:"volumeUomId", type:"int", useNull:true},
		{name:"weight", type:"float", useNull:true},
		{name:"weightUomCode", type:"string"},
		{name:"weightUomId", type:"int", useNull:true}
	],
	validations: [
		{field: "name", type: 'presence'}
	]});

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"attributeSet", type:"string"},
		{name:"attributeSetId", type:"int", useNull:true},
		{name:"attributeSetId_From",type:"int", useNull:true},
		{name:"attributeSetId_To",type:"int", useNull:true},
		{name:"businessObject", type:"string"},
		{name:"className", type:"string"},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"defaultUomCode", type:"string"},
		{name:"defaultUomId", type:"int", useNull:true},
		{name:"defaultUomId_From",type:"int", useNull:true},
		{name:"defaultUomId_To",type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"description", type:"string"},
		{name:"dimDepth", type:"float", useNull:true},
		{name:"dimDepth_From",type:"float", useNull:true},
		{name:"dimDepth_To",type:"float", useNull:true},
		{name:"dimHeight", type:"float", useNull:true},
		{name:"dimHeight_From",type:"float", useNull:true},
		{name:"dimHeight_To",type:"float", useNull:true},
		{name:"dimUomCode", type:"string"},
		{name:"dimUomId", type:"int", useNull:true},
		{name:"dimUomId_From",type:"int", useNull:true},
		{name:"dimUomId_To",type:"int", useNull:true},
		{name:"dimWidth", type:"float", useNull:true},
		{name:"dimWidth_From",type:"float", useNull:true},
		{name:"dimWidth_To",type:"float", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"iconUrl", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"imageUrl", type:"string"},
		{name:"manufacturerCode", type:"string"},
		{name:"manufacturerId", type:"int", useNull:true},
		{name:"manufacturerId_From",type:"int", useNull:true},
		{name:"manufacturerId_To",type:"int", useNull:true},
		{name:"manufacturerProductNo", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"purchase", type:"boolean", useNull:true},
		{name:"sale", type:"boolean", useNull:true},
		{name:"showInCatalog", type:"boolean", useNull:true},
		{name:"storable", type:"boolean", useNull:true},
		{name:"uuid", type:"string"},
		{name:"volume", type:"float", useNull:true},
		{name:"volume_From",type:"float", useNull:true},
		{name:"volume_To",type:"float", useNull:true},
		{name:"volumeUomCode", type:"string"},
		{name:"volumeUomId", type:"int", useNull:true},
		{name:"volumeUomId_From",type:"int", useNull:true},
		{name:"volumeUomId_To",type:"int", useNull:true},
		{name:"weight", type:"float", useNull:true},
		{name:"weight_From",type:"float", useNull:true},
		{name:"weight_To",type:"float", useNull:true},
		{name:"weightUomCode", type:"string"},
		{name:"weightUomId", type:"int", useNull:true},
		{name:"weightUomId_From",type:"int", useNull:true},
		{name:"weightUomId_To",type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.param.ProductDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"productCategory", type:"string"},
		{name:"productCategoryId", type:"int", useNull:true}
	]
});
