Ext.define("net.nan21.dnet.module.md.base.tx.lovs.TxDocTypesSOInvOut", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_base_tx_lovs_TxDocTypesSOInvOut",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.base.tx.frame.TxDocType_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		tocElement: "canvasDocType",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocTypeSOInvOutLovDs",
	_dataProviderName_:"TxDocTypeSOInvOutLovDs"
	
});
