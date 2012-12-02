/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"price", type:"float", useNull:true},
		{name:"priceListVersion", type:"string"},
		{name:"priceListVersionId", type:"int", useNull:true},
		{name:"product", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productName", type:"string"},
		{name:"uom", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"productCategory", type:"string"},
		{name:"productCategoryId", type:"int", useNull:true}
	]
});
