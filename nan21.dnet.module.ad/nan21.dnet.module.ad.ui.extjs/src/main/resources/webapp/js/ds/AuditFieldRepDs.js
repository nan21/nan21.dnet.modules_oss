/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.system.ds.model.AuditFieldRepDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fieldName", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"newValue", type:"string"},
		{name:"oldValue", type:"string"},
		{name:"operation", type:"string"},
		{name:"sourceFQN", type:"string"},
		{name:"sourceId", type:"string"}
	]});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.AuditFieldRepDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fieldName", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"newValue", type:"string"},
		{name:"oldValue", type:"string"},
		{name:"operation", type:"string"},
		{name:"sourceFQN", type:"string"},
		{name:"sourceId", type:"string"}
	]
});
