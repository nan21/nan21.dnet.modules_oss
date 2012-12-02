/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollBalanceValueDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accItem", type:"string"},
		{name:"accItemId", type:"int", useNull:true},
		{name:"balanceFunction", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataType", type:"string"},
		{name:"element", type:"string"},
		{name:"elementId", type:"int", useNull:true},
		{name:"elementName", type:"string"},
		{name:"employer", type:"string"},
		{name:"employerId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"period", type:"string"},
		{name:"periodEnd", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodId", type:"int", useNull:true},
		{name:"periodStart", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sourceElement", type:"string"},
		{name:"sourceElementId", type:"int", useNull:true},
		{name:"sourceElementName", type:"string"},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"value", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollBalanceValueDs",
	fields: [
		{name:"periodStart_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodStart_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodEnd_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodEnd_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
