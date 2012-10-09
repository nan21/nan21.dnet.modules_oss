/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"qualificationId", type:"int", useNull:true},
		{name:"ratingScaleId", type:"int", useNull:true},
		{name:"requiredLevel", type:"string"},
		{name:"requiredLevelId", type:"int", useNull:true},
		{name:"skill", type:"string"},
		{name:"skillId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"qualificationId", type:"int", useNull:true},
		{name:"qualificationId_From",type:"int", useNull:true},
		{name:"qualificationId_To",type:"int", useNull:true},
		{name:"ratingScaleId", type:"int", useNull:true},
		{name:"ratingScaleId_From",type:"int", useNull:true},
		{name:"ratingScaleId_To",type:"int", useNull:true},
		{name:"requiredLevel", type:"string"},
		{name:"requiredLevelId", type:"int", useNull:true},
		{name:"requiredLevelId_From",type:"int", useNull:true},
		{name:"requiredLevelId_To",type:"int", useNull:true},
		{name:"skill", type:"string"},
		{name:"skillId", type:"int", useNull:true},
		{name:"skillId_From",type:"int", useNull:true},
		{name:"skillId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.QualificationSkillDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
