/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"deployTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fullName", type:"string"},
		{name:"id", type:"string"},
		{name:"name", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"from", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"to", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
