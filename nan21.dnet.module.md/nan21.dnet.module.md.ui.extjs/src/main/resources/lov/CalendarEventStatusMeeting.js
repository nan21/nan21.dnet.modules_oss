Ext.define("net.nan21.dnet.module.md.activity.lovs.CalendarEventStatusMeeting", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_activity_lovs_CalendarEventStatusMeeting",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.activity.frame.CalendarEventTypeDef_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		tocElement: "canvasStatus",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.activity.ds.model.CalendarEventStatusMeetingLovDs",
	_dataProviderName_:"CalendarEventStatusMeetingLovDs"
	
});
