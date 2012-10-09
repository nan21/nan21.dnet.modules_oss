Ext.define("net.nan21.dnet.module.ad.data.lovs.AttachmentTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_data_lovs_AttachmentTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.data.frame.AttachmentType_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeLovDs",
	_dataProviderName_:"AttachmentTypeLovDs"
	
});
