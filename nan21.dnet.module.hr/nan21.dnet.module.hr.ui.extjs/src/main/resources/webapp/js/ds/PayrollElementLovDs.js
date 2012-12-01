/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"engine", type:"string"},
		{name:"engineId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementLovDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"code", type:"string"},
		{name:"engine", type:"string"},
		{name:"engineId", type:"int", useNull:true},
		{name:"engineId_From",type:"int", useNull:true},
		{name:"engineId_To",type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]
});
