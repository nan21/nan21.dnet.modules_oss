Ext.define("net.nan21.dnet.module.md.tx.inventory.lovs.InvTransactionTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_tx_inventory_lovs_InvTransactionTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.tx.inventory.frame.InvTxTypes_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionTypeLovDs",
	_dataProviderName_:"InvTransactionTypeLovDs"
	
});
