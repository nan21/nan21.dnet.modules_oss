/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollManualValueDs", {
	extend: 'Ext.data.Model',
	fields: [
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
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollManualValueDs",
	fields: [
		{name:"periodStart_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodStart_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodEnd_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodEnd_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
