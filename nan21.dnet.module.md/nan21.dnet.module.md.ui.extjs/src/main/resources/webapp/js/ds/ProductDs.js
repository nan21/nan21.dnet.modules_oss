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
		{name:"iconLocation", type:"string"},
		{name:"iconUrl", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"imageLocation", type:"string"},
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
	]
});

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"productCategory", type:"string"},
		{name:"productCategoryId", type:"int", useNull:true}
	]
});
