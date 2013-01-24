/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActVariableDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"doubleValue", type:"float", useNull:true},
		{name:"executionId", type:"string"},
		{name:"longValue", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"textValue", type:"string"},
		{name:"textValue2", type:"string"},
		{name:"type", type:"string"}
	]
});
