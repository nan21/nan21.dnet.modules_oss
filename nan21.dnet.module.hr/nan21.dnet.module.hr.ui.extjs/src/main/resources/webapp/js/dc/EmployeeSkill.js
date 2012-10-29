/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.skill.dc.EmployeeSkill", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.EmployeeSkillDs",
	filterModel: "net.nan21.dnet.module.hr.skill.ds.model.EmployeeSkillDsFilter",
	paramModel: "net.nan21.dnet.module.hr.skill.ds.param.EmployeeSkillDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_skill_dc_EmployeeSkill$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"createdBy", _sharedLabel_:true, dataIndex:"createdBy", disabled:true , anchor:"-20", maxLength:32})
			.addTextField({ name:"modifiedBy", _sharedLabel_:true, dataIndex:"modifiedBy", disabled:true , anchor:"-20", maxLength:32})
			.addTextField({ name:"skill", dataIndex:"skill", anchor:"-20"})
			.addTextField({ name:"skillLevel", dataIndex:"skillLevel", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["createdBy", "modifiedBy", "skill", "skillLevel"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_skill_dc_EmployeeSkill$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"skillId", dataIndex:"skillId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"skill", dataIndex:"skill", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_skill_lovs_Skills", selectOnFocus:true, allowBlank:false,
						retFieldMapping: [
							{lovField:"id", dsField: "skillId"} ,{lovField:"ratingScaleId", dsField: "ratingScaleId"} 
						]}})
			.addNumberColumn({name:"skillLevelId", dataIndex:"skillLevelId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"skillLevel", dataIndex:"skillLevel", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_skill_lovs_RatingLevels", selectOnFocus:true, allowBlank:false,
						retFieldMapping: [
							{lovField:"id", dsField: "skillLevelId"} 
						],
						filterFieldMapping: [
							{lovField:"ratingScaleId",dsField: "ratingScaleId"} 
						]}})
			.addDefaults();
	}});
