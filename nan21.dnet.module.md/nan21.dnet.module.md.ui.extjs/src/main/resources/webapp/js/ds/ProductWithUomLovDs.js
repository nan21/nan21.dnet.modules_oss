/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductWithUomLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"purchase", type:"boolean"},
		{name:"sale", type:"boolean"},
		{name:"uom", type:"string"},
		{name:"uomId", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductWithUomLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"purchase", type:"boolean", useNull:true},
		{name:"sale", type:"boolean", useNull:true},
		{name:"uom", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomId_From",type:"int", useNull:true},
		{name:"uomId_To",type:"int", useNull:true}
	]
});
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.param.ProductWithUomLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
