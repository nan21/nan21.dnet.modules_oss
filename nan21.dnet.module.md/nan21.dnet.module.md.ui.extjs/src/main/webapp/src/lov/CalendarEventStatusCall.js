Ext.define("net.nan21.dnet.module.md.activity.lovs.CalendarEventStatusCall", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_activity_lovs_CalendarEventStatusCall",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.activity.frame.CalendarEventTypeDef_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		tocElement: "canvasStatus",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.activity.ds.model.CalendarEventStatusCallLovDs",
	_dataProviderName_:"CalendarEventStatusCallLovDs"
	
});
