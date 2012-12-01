/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"year", type:"string"},
		{name:"yearId", type:"int", useNull:true}
	]});

Ext.define("net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodLovDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"year", type:"string"},
		{name:"yearId", type:"int", useNull:true},
		{name:"yearId_From",type:"int", useNull:true},
		{name:"yearId_To",type:"int", useNull:true}
	]
});
