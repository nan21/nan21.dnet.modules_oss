/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"currency", type:"string"},
		{name:"docNo", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"supplier", type:"string"},
		{name:"totalAmount", type:"float", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"code", type:"string"},
		{name:"currency", type:"string"},
		{name:"docNo", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"supplier", type:"string"},
		{name:"totalAmount", type:"float", useNull:true},
		{name:"totalAmount_From",type:"float", useNull:true},
		{name:"totalAmount_To",type:"float", useNull:true}
	]
});
Ext.define("net.nan21.dnet.module.sd.order.ds.param.SalesOrderLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
