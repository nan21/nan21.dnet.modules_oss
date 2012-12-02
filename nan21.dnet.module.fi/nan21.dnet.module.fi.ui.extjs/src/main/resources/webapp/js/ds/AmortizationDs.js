/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.fi.asset.ds.model.AmortizationDs", {
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
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.fi.asset.ds.model.AmortizationDs",
	fields: [
		{name:"postingDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"postingDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
