/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.skill.dc.Skill", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.SkillDs",
	filterModel: "net.nan21.dnet.module.hr.skill.ds.model.SkillDsFilter",
	paramModel: "net.nan21.dnet.module.hr.skill.ds.param.SkillDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.Skill$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_skill_dc_Skill$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addLov({xtype:"hr_skill_lovs_SkillTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"hr_skill_lovs_RatingScales", name:"ratingScale", dataIndex:"ratingScale", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "ratingScaleId"} 
				]})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "active"])
			.addChildrenTo("col2", ["type", "ratingScale"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.Skill$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_skill_dc_Skill$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_skill_lovs_SkillTypes", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "typeId"} 
						]}})
			.addLov({name:"ratingScale", dataIndex:"ratingScale", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_skill_lovs_RatingScales", selectOnFocus:true, allowBlank:false,
						retFieldMapping: [
							{lovField:"id", dsField: "ratingScaleId"} 
						]}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"typeId", dataIndex:"typeId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
