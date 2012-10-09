Ext.define("net.nan21.dnet.module.bd.contact.lovs.CommunicationChannelTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_contact_lovs_CommunicationChannelTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeLovDs",
	_dataProviderName_:"CommunicationChannelTypeLovDs"
	
});
