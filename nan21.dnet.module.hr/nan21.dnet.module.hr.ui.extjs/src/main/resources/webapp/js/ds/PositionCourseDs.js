/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.training.ds.model.PositionCourseDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"courseCode", type:"string"},
		{name:"courseId", type:"int", useNull:true},
		{name:"courseName", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"mandatory", type:"boolean"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"positionCode", type:"string"},
		{name:"positionId", type:"int", useNull:true},
		{name:"positionName", type:"string"},
		{name:"uuid", type:"string"},
		{name:"validFor", type:"int", useNull:true},
		{name:"version", type:"int", useNull:true}
	]
});
