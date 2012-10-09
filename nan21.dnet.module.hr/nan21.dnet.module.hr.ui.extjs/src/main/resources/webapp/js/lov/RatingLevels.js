Ext.define("net.nan21.dnet.module.hr.skill.lovs.RatingLevels", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_skill_lovs_RatingLevels",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.RatingLevelLovDs",
	_dataProviderName_:"RatingLevelLovDs"
	
});
