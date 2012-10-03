Ext.define("net.nan21.dnet.module.ad.system.lovs.SysJob", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_system_lovs_SysJob",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.system.frame.SysJob_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysJobLovDs",
	_dataProviderName_:"SysJobLovDs"
	
});
