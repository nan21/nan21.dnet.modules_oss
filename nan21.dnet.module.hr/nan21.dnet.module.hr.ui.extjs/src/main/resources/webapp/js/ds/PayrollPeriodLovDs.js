/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"closed", type:"boolean"},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"payrollId", type:"int", useNull:true},
		{name:"processed", type:"boolean"},
		{name:"startDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
