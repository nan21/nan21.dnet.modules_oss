Ext.define("net.nan21.dnet.module.ad.system.lovs.SysJobCtx", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_system_lovs_SysJobCtx",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.system.frame.SysJobCtx_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysJobCtxLovDs",
	_dataProviderName_:"SysJobCtxLovDs"
	
});
