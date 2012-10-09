Ext.define("net.nan21.dnet.module.ad.system.lovs.SysDateFormats", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_system_lovs_SysDateFormats",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.system.frame.SysDateFormat_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDateFormatLovDs",
	_dataProviderName_:"SysDateFormatLovDs"
	
});
