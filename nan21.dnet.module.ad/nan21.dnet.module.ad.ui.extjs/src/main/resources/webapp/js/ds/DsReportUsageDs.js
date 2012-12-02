/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.report.ds.model.DsReportUsageDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dcKey", type:"string"},
		{name:"dsReportId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"frameName", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"reportCode", type:"string"},
		{name:"reportId", type:"int", useNull:true},
		{name:"toolbarKey", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
