/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.skill.dc.JobSkill", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.JobSkillDs",
	filterModel: "net.nan21.dnet.module.hr.skill.ds.model.JobSkillDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.JobSkill$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_skill_dc_JobSkill$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"jobId", dataIndex:"jobId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"competenceId", dataIndex:"competenceId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"competence", dataIndex:"competence", xtype:"gridcolumn", width:300,
					editor:{xtype:"hr_skill_lovs_Skills", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "competenceId"} ,{lovField:"ratingScaleId", dsField: "ratingScaleId"} 
						]}})
			.addNumberColumn({name:"requiredLevelId", dataIndex:"requiredLevelId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"requiredLevel", dataIndex:"requiredLevel", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_skill_lovs_RatingLevels", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "requiredLevelId"} 
						],
						filterFieldMapping: [
							{lovField:"ratingScaleId",dsField: "ratingScaleId"} 
						]}})
			.addDefaults();
	}
});
