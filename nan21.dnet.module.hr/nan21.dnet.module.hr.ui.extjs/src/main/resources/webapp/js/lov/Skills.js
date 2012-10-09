Ext.define("net.nan21.dnet.module.hr.skill.lovs.Skills", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_skill_lovs_Skills",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.skill.frame.Skill_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.SkillLovDs",
	_dataProviderName_:"SkillLovDs"
	
});
