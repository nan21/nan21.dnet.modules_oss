/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.fi.asset.ds.model.AmortizationDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"amount", type:"float", useNull:true},
		{name:"asset", type:"string"},
		{name:"assetCategory", type:"string"},
		{name:"assetCategoryId", type:"int", useNull:true},
		{name:"assetId", type:"int", useNull:true},
		{name:"assetName", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"percentage", type:"float", useNull:true},
		{name:"periodType", type:"string"},
		{name:"postingDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.fi.asset.ds.model.AmortizationDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"amount", type:"float", useNull:true},
		{name:"amount_From",type:"float", useNull:true},
		{name:"amount_To",type:"float", useNull:true},
		{name:"asset", type:"string"},
		{name:"assetCategory", type:"string"},
		{name:"assetCategoryId", type:"int", useNull:true},
		{name:"assetCategoryId_From",type:"int", useNull:true},
		{name:"assetCategoryId_To",type:"int", useNull:true},
		{name:"assetId", type:"int", useNull:true},
		{name:"assetId_From",type:"int", useNull:true},
		{name:"assetId_To",type:"int", useNull:true},
		{name:"assetName", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"orgId_From",type:"int", useNull:true},
		{name:"orgId_To",type:"int", useNull:true},
		{name:"percentage", type:"float", useNull:true},
		{name:"percentage_From",type:"float", useNull:true},
		{name:"percentage_To",type:"float", useNull:true},
		{name:"periodType", type:"string"},
		{name:"postingDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"postingDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"postingDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.fi.asset.ds.param.AmortizationDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
