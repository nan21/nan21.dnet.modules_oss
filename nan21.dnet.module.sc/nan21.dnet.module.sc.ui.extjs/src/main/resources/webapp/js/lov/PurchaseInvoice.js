Ext.define("net.nan21.dnet.module.sc.invoice.lovs.PurchaseInvoice", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.sc_invoice_lovs_PurchaseInvoice",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {docNo}, {supplier}, {totalAmount}, {currency}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.sc.invoice.frame.PurchaseInvoice_UI",
		bundle:"nan21.dnet.module.sc.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceLovDs",
	_dataProviderName_:"PurchaseInvoiceLovDs"
	
});
