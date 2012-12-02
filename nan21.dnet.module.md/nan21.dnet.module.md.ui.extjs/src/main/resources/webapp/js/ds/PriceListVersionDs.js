/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.price.ds.model.PriceListVersionDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"priceList", type:"string"},
		{name:"priceListId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"version", type:"int", useNull:true}
	],
	validations: [
		{field: "validFrom", type: 'presence'},
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.price.ds.model.PriceListVersionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"copyFromVersion", type:"string"},
		{name:"copyFromVersionId", type:"int", useNull:true},
		{name:"productCategory", type:"string"},
		{name:"productCategoryId", type:"int", useNull:true}
	]
});
