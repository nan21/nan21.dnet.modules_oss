/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.report.ds.model.DsReportParamDs", {
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
	]
});
