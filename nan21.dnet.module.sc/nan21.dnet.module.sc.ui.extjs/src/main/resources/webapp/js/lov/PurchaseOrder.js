Ext.define("net.nan21.dnet.module.sc.order.lovs.PurchaseOrder", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.sc_order_lovs_PurchaseOrder",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {docNo}, {supplier}, {totalAmount}, {currency}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.sc.order.frame.PurchaseOrder_UI",
		bundle:"nan21.dnet.module.sc.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderLovDs",
	_dataProviderName_:"PurchaseOrderLovDs"
	
});
