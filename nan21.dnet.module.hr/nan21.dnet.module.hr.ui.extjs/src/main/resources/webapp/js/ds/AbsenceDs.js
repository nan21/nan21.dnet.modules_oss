/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.time.ds.model.AbsenceDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"employee", type:"string"},
		{name:"employeeCode", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"hours", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"posted", type:"boolean"},
		{name:"reason", type:"string"},
		{name:"reasonId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.hr.time.ds.model.AbsenceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"from", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"to", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});
