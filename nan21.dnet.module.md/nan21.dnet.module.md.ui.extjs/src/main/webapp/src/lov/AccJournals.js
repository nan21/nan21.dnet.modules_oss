Ext.define("net.nan21.dnet.module.md.acc.lovs.AccJournals", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_acc_lovs_AccJournals",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.acc.frame.AccJournal_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccJournalLovDs",
	_dataProviderName_:"AccJournalLovDs"
	
});
