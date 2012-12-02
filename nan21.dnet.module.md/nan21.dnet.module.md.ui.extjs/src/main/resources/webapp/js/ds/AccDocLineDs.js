/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.acc.ds.model.AccDocLineDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accDocId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"crAccount", type:"string"},
		{name:"crAmount", type:"float", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dbAccount", type:"string"},
		{name:"dbAmount", type:"float", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
