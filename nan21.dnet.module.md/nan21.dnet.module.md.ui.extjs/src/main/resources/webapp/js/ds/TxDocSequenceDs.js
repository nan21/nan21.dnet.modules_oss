/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.base.tx.ds.model.TxDocSequenceDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"firstNo", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"incrementBy", type:"int", useNull:true},
		{name:"lastNo", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"nextNo", type:"int", useNull:true},
		{name:"prefix", type:"string"},
		{name:"suffix", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	validations: [
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.md.base.tx.ds.model.TxDocSequenceDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"firstNo", type:"int", useNull:true},
		{name:"firstNo_From",type:"int", useNull:true},
		{name:"firstNo_To",type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"incrementBy", type:"int", useNull:true},
		{name:"incrementBy_From",type:"int", useNull:true},
		{name:"incrementBy_To",type:"int", useNull:true},
		{name:"lastNo", type:"int", useNull:true},
		{name:"lastNo_From",type:"int", useNull:true},
		{name:"lastNo_To",type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"nextNo", type:"int", useNull:true},
		{name:"nextNo_From",type:"int", useNull:true},
		{name:"nextNo_To",type:"int", useNull:true},
		{name:"prefix", type:"string"},
		{name:"suffix", type:"string"},
		{name:"uuid", type:"string"}
	]
});
