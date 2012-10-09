Ext.define("net.nan21.dnet.module.hr.skill.lovs.SkillCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_skill_lovs_SkillCategories",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.skill.frame.SkillType_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		tocElement: "canvasCateg",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.SkillCategoryLovDs",
	_dataProviderName_:"SkillCategoryLovDs"
	
});
