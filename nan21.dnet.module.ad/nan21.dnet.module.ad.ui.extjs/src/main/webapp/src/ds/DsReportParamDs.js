/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.report.ds.model.DsReportParamDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataSource", type:"string"},
		{name:"dsField", type:"string"},
		{name:"dsReportId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"paramCode", type:"string"},
		{name:"paramId", type:"int", useNull:true},
		{name:"paramName", type:"string"},
		{name:"reportCode", type:"string"},
		{name:"reportId", type:"int", useNull:true},
		{name:"staticValue", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.ad.report.ds.model.DsReportParamDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataSource", type:"string"},
		{name:"dsField", type:"string"},
		{name:"dsReportId", type:"int", useNull:true},
		{name:"dsReportId_From",type:"int", useNull:true},
		{name:"dsReportId_To",type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"paramCode", type:"string"},
		{name:"paramId", type:"int", useNull:true},
		{name:"paramId_From",type:"int", useNull:true},
		{name:"paramId_To",type:"int", useNull:true},
		{name:"paramName", type:"string"},
		{name:"reportCode", type:"string"},
		{name:"reportId", type:"int", useNull:true},
		{name:"reportId_From",type:"int", useNull:true},
		{name:"reportId_To",type:"int", useNull:true},
		{name:"staticValue", type:"string"},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.ad.report.ds.param.DsReportParamDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
