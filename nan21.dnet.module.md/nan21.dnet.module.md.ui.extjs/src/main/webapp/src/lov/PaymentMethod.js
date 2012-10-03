Ext.define("net.nan21.dnet.module.md.base.tx.lovs.PaymentMethod", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_base_tx_lovs_PaymentMethod",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.base.tx.frame.TxBaseData_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		tocElement: "canvasPayMtd",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.PaymentMethodLovDs",
	_dataProviderName_:"PaymentMethodLovDs"
	
});
