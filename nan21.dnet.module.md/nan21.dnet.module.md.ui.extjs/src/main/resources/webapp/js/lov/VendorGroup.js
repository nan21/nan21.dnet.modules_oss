Ext.define("net.nan21.dnet.module.md.bp.lovs.VendorGroup", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_bp_lovs_VendorGroup",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		tocElement: "canvasVendGroup",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.VendorGroupLovDs",
	_dataProviderName_:"VendorGroupLovDs"
	
});
