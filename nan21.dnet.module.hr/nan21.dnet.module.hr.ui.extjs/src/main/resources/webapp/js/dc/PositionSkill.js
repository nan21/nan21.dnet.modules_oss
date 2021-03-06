/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.skill.dc.PositionSkill", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.PositionSkillDs"
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.PositionSkill$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_skill_dc_PositionSkill$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"positionId", dataIndex:"positionId", hidden:true, align:"right", width:70, format:"0"})
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
