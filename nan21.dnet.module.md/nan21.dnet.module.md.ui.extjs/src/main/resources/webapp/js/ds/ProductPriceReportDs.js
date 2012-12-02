/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceReportDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"price", type:"float", useNull:true},
		{name:"priceList", type:"string"},
		{name:"priceListId", type:"int", useNull:true},
		{name:"priceListVersion", type:"string"},
		{name:"priceListVersionId", type:"int", useNull:true},
		{name:"product", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productName", type:"string"},
		{name:"uom", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"version", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceReportDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"productCategory", type:"string"},
		{name:"productCategoryId", type:"int", useNull:true},
		{name:"validAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
