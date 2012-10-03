Ext.define("net.nan21.dnet.module.md.bp.lovs.CompanyLegalForms", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_bp_lovs_CompanyLegalForms",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		tocElement: "canvasLegalForm",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.CompanyLegalFormLovDs",
	_dataProviderName_:"CompanyLegalFormLovDs"
	
});
