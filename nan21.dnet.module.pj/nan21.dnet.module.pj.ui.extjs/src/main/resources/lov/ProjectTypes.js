Ext.define("net.nan21.dnet.module.pj.base.lovs.ProjectTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_base_lovs_ProjectTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.pj.base.frame.ProjectBaseData_UI",
		bundle:"nan21.dnet.module.pj.ui.extjs",
		tocElement: "canvasType",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ProjectTypeLovDs",
	_dataProviderName_:"ProjectTypeLovDs"
	
});
