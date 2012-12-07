/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.fi.asset.ds.model.AssetDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"calculation", type:"string"},
		{name:"category", type:"string"},
		{name:"categoryId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"deprecEndDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"deprecStartDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"depreciationAmount", type:"float", useNull:true},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"initialDeprecAmount", type:"float", useNull:true},
		{name:"initialValue", type:"float", useNull:true},
		{name:"method", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"periodPercenatge", type:"int", useNull:true},
		{name:"periodType", type:"string"},
		{name:"periodValue", type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productName", type:"string"},
		{name:"purchaseDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"residualValue", type:"float", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"withDepreciation", type:"boolean"}
	],
	
	validations: [
		{field: "code", type: 'presence'},
		{field: "name", type: 'presence'}
	]
});
