Ext.define("net.nan21.dnet.module.md.bp.lovs.CustomerGroup", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_bp_lovs_CustomerGroup",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		tocElement: "canvasCustGroup",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.CustomerGroupLovDs",
	_dataProviderName_:"CustomerGroupLovDs"
	
});
