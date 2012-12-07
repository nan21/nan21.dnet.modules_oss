/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"account", type:"string"},
		{name:"accountId", type:"int", useNull:true},
		{name:"active", type:"boolean"},
		{name:"amount", type:"float", useNull:true},
		{name:"assignedTo", type:"string"},
		{name:"assignedToId", type:"int", useNull:true},
		{name:"businessObject", type:"string"},
		{name:"campaign", type:"string"},
		{name:"className", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"closeDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currency", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"leadSource", type:"string"},
		{name:"leadSourceId", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"priority", type:"string"},
		{name:"priorityId", type:"int", useNull:true},
		{name:"probability", type:"float", useNull:true},
		{name:"resultNote", type:"string"},
		{name:"resultReason", type:"string"},
		{name:"resultReasonId", type:"int", useNull:true},
		{name:"salesStage", type:"string"},
		{name:"salesStageId", type:"int", useNull:true},
		{name:"status", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	
	validations: [
		{field: "name", type: 'presence'}
	]
});
