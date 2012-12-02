/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.grade.ds.model.GradeRateValueDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"fixValue", type:"float", useNull:true},
		{name:"gradeId", type:"int", useNull:true},
		{name:"gradeName", type:"string"},
		{name:"gradeRateId", type:"int", useNull:true},
		{name:"gradeRateName", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"maxValue", type:"float", useNull:true},
		{name:"minValue", type:"float", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"uuid", type:"string"},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"version", type:"int", useNull:true}
	]
});
