/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.skill.dc.SkillType", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.SkillTypeDs",
	filterModel: "net.nan21.dnet.module.hr.skill.ds.model.SkillTypeDsFilter",
	paramModel: "net.nan21.dnet.module.hr.skill.ds.param.SkillTypeDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.SkillType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_skill_dc_SkillType$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addLov({xtype:"hr_skill_lovs_SkillCategories", name:"category", dataIndex:"category", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "categoryId"} 
				]})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "category"])
			.addChildrenTo("col2", ["active"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.SkillType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_skill_dc_SkillType$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:150,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"category", dataIndex:"category", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_skill_lovs_SkillCategories", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "categoryId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
