/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accItem", type:"string"},
		{name:"accItemId", type:"int", useNull:true},
		{name:"active", type:"boolean"},
		{name:"balance", type:"boolean"},
		{name:"balanceFunction", type:"string"},
		{name:"calculation", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataType", type:"string"},
		{name:"description", type:"string"},
		{name:"engine", type:"string"},
		{name:"engineId", type:"int", useNull:true},
		{name:"engineType", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sourceElement", type:"string"},
		{name:"sourceElementId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	validations: [
		{field: "code", type: 'presence'},
		{field: "name", type: 'presence'}
	]
});
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accItem", type:"string"},
		{name:"accItemId", type:"int", useNull:true},
		{name:"accItemId_From",type:"int", useNull:true},
		{name:"accItemId_To",type:"int", useNull:true},
		{name:"active", type:"boolean", useNull:true},
		{name:"balance", type:"boolean", useNull:true},
		{name:"balanceFunction", type:"string"},
		{name:"calculation", type:"string"},
		{name:"code", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataType", type:"string"},
		{name:"description", type:"string"},
		{name:"engine", type:"string"},
		{name:"engineId", type:"int", useNull:true},
		{name:"engineId_From",type:"int", useNull:true},
		{name:"engineId_To",type:"int", useNull:true},
		{name:"engineType", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"notes", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"sourceElement", type:"string"},
		{name:"sourceElementId", type:"int", useNull:true},
		{name:"sourceElementId_From",type:"int", useNull:true},
		{name:"sourceElementId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollElementDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
