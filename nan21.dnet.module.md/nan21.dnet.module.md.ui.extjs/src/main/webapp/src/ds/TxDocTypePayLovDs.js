/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.base.tx.ds.model.TxDocTypePayLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"category", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]});
Ext.define("net.nan21.dnet.module.md.base.tx.ds.model.TxDocTypePayLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"category", type:"string"},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.md.base.tx.ds.param.TxDocTypePayLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
