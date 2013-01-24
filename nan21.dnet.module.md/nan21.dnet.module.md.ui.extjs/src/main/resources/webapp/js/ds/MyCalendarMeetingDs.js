/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.activity.ds.model.MyCalendarMeetingDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"allDay", type:"boolean"},
		{name:"bpartnerCode", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"eminder", type:"string"},
		{name:"endDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"entityFQN", type:"string"},
		{name:"eventType", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"location", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"priorityId", type:"int", useNull:true},
		{name:"priorityName", type:"string"},
		{name:"startDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"statusId", type:"int", useNull:true},
		{name:"statusName", type:"string"},
		{name:"subject", type:"string"},
		{name:"url", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
