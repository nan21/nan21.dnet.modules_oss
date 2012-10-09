Ext.define("net.nan21.dnet.module.bd.org.lovs.Calendars", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_org_lovs_Calendars",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.org.frame.Calendars_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.CalendarLovDs",
	_dataProviderName_:"CalendarLovDs"
	
});
