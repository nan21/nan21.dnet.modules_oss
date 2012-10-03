/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.skill.dc.QualificationSkill", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDs",
	filterModel: "net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDsFilter",
	paramModel: "net.nan21.dnet.module.hr.skill.ds.param.QualificationSkillDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.QualificationSkill$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_skill_dc_QualificationSkill$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"qualificationId", dataIndex:"qualificationId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"skillId", dataIndex:"skillId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"skill", dataIndex:"skill", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_skill_lovs_Skills", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "skillId"} ,{lovField:"ratingScaleId", dsField: "ratingScaleId"} 
						]}})
			.addLov({name:"requiredLevel", dataIndex:"requiredLevel", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_skill_lovs_RatingLevels", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "requiredLevelId"} 
						],
						filterFieldMapping: [
							{lovField:"ratingScaleId",dsField: "ratingScaleId"} 
						]}})
			.addDefaults();
	}});
