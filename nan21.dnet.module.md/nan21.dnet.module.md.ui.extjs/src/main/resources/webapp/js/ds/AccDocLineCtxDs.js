/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.acc.ds.model.AccDocLineCtxDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accDocId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"crAccount", type:"string"},
		{name:"crAmount", type:"float", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dbAccount", type:"string"},
		{name:"dbAmount", type:"float", useNull:true},
		{name:"docType", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docUuid", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.md.tx.acc.ds.model.AccDocLineCtxDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accDocId", type:"int", useNull:true},
		{name:"accDocId_From",type:"int", useNull:true},
		{name:"accDocId_To",type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"crAccount", type:"string"},
		{name:"crAmount", type:"float", useNull:true},
		{name:"crAmount_From",type:"float", useNull:true},
		{name:"crAmount_To",type:"float", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dbAccount", type:"string"},
		{name:"dbAmount", type:"float", useNull:true},
		{name:"dbAmount_From",type:"float", useNull:true},
		{name:"dbAmount_To",type:"float", useNull:true},
		{name:"docType", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docTypeId_From",type:"int", useNull:true},
		{name:"docTypeId_To",type:"int", useNull:true},
		{name:"docUuid", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.md.tx.acc.ds.param.AccDocLineCtxDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
