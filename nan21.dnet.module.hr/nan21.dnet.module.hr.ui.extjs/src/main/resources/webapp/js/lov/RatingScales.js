Ext.define("net.nan21.dnet.module.hr.skill.lovs.RatingScales", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_skill_lovs_RatingScales",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.skill.frame.RatingScale_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.RatingScaleLovDs",
	_dataProviderName_:"RatingScaleLovDs"
	
});
