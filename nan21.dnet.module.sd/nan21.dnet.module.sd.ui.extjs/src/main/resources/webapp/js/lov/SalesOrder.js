Ext.define("net.nan21.dnet.module.sd.order.lovs.SalesOrder", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.sd_order_lovs_SalesOrder",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {docNo}, {supplier}, {totalAmount}, {currency}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.sd.order.frame.SalesOrder_UI",
		bundle:"nan21.dnet.module.sd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderLovDs",
	_dataProviderName_:"SalesOrderLovDs"
	
});
