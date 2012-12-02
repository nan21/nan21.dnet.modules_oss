/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.acc.ds.model.AccOperationDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accDocLineId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"bpartner", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"crAccount", type:"string"},
		{name:"crAmount", type:"float", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dbAccount", type:"string"},
		{name:"dbAmount", type:"float", useNull:true},
		{name:"docNo", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"period", type:"string"},
		{name:"periodId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.md.tx.acc.ds.model.AccOperationDs",
	fields: [
		{name:"eventDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dbAmount_From",type:"float", useNull:true},
		{name:"dbAmount_To",type:"float", useNull:true},
		{name:"crAmount_From",type:"float", useNull:true},
		{name:"crAmount_To",type:"float", useNull:true}
	]
});
