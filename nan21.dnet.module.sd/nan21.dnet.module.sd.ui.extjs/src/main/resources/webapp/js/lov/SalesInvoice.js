Ext.define("net.nan21.dnet.module.sd.invoice.lovs.SalesInvoice", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.sd_invoice_lovs_SalesInvoice",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {docNo}, {supplier}, {totalAmount}, {currency}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI",
		bundle:"nan21.dnet.module.sd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceLovDs",
	_dataProviderName_:"SalesInvoiceLovDs"
	
});
