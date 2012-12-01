/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementValueDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"calculation", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataType", type:"string"},
		{name:"element", type:"string"},
		{name:"elementId", type:"int", useNull:true},
		{name:"elementName", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeName", type:"string"},
		{name:"employer", type:"string"},
		{name:"employerId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"jobCode", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"period", type:"string"},
		{name:"periodEnd", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodId", type:"int", useNull:true},
		{name:"periodStart", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"positionCode", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"value", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementValueDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"calculation", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataType", type:"string"},
		{name:"element", type:"string"},
		{name:"elementId", type:"int", useNull:true},
		{name:"elementId_From",type:"int", useNull:true},
		{name:"elementId_To",type:"int", useNull:true},
		{name:"elementName", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeId_From",type:"int", useNull:true},
		{name:"employeeId_To",type:"int", useNull:true},
		{name:"employeeName", type:"string"},
		{name:"employer", type:"string"},
		{name:"employerId", type:"int", useNull:true},
		{name:"employerId_From",type:"int", useNull:true},
		{name:"employerId_To",type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"jobCode", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"period", type:"string"},
		{name:"periodEnd", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodEnd_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodEnd_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodId", type:"int", useNull:true},
		{name:"periodId_From",type:"int", useNull:true},
		{name:"periodId_To",type:"int", useNull:true},
		{name:"periodStart", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodStart_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodStart_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"positionCode", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"value", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollElementValueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"elementSet", type:"string"},
		{name:"elementSetId", type:"int", useNull:true}
	]
});
