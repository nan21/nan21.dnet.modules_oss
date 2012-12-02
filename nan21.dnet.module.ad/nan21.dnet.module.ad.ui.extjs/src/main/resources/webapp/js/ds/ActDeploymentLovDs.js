/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"fullName", type:"string"},
		{name:"id", type:"string"},
		{name:"name", type:"string"}
	]
});
