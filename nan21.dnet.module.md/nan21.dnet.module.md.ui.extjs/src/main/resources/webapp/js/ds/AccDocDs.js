/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.acc.ds.model.AccDocDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"bpartner", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"crAmount", type:"float", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dbAmount", type:"float", useNull:true},
		{name:"difference", type:"float", useNull:true},
		{name:"docAmount", type:"float", useNull:true},
		{name:"docCurrency", type:"string"},
		{name:"docCurrencyId", type:"int", useNull:true},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docNetAmount", type:"float", useNull:true},
		{name:"docNo", type:"string"},
		{name:"docTaxAmount", type:"float", useNull:true},
		{name:"docType", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"journal", type:"string"},
		{name:"journalId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"period", type:"string"},
		{name:"periodId", type:"int", useNull:true},
		{name:"posted", type:"boolean"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.md.tx.acc.ds.model.AccDocDs",
	fields: [
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docAmount_From",type:"float", useNull:true},
		{name:"docAmount_To",type:"float", useNull:true},
		{name:"dbAmount_From",type:"float", useNull:true},
		{name:"dbAmount_To",type:"float", useNull:true},
		{name:"crAmount_From",type:"float", useNull:true},
		{name:"crAmount_To",type:"float", useNull:true},
		{name:"difference_From",type:"float", useNull:true},
		{name:"difference_To",type:"float", useNull:true}
	]
});
