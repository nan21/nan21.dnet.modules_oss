/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"providerCode", type:"string"},
		{name:"providerId", type:"int", useNull:true},
		{name:"sourceCode", type:"string"},
		{name:"sourceId", type:"int", useNull:true},
		{name:"targetCode", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"validAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"value", type:"float", useNull:true},
		{name:"version", type:"int", useNull:true}
	]
});
