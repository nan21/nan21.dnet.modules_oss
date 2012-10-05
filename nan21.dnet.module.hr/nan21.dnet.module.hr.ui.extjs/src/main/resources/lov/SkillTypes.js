Ext.define("net.nan21.dnet.module.hr.skill.lovs.SkillTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_skill_lovs_SkillTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.skill.frame.SkillType_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		tocElement: "canvasType",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.SkillTypeLovDs",
	_dataProviderName_:"SkillTypeLovDs"
	
});
