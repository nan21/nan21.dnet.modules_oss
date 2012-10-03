Ext.define("net.nan21.dnet.module.md.base.tx.lovs.TxDocTypesInvInOut", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_base_tx_lovs_TxDocTypesInvInOut",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.base.tx.frame.TxDocType_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		tocElement: "canvasDocType",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocTypeInvInOutLovDs",
	_dataProviderName_:"TxDocTypeInvInOutLovDs"
	
});
