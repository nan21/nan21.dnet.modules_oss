/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.fi.asset.dc.AssetAcct", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetAcctDs",
	filterModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetAcctDsFilter",
	paramModel: "net.nan21.dnet.module.fi.asset.ds.param.AssetAcctDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= E-GRID: EditListCtx ================= */


Ext.define("net.nan21.dnet.module.fi.asset.dc.AssetAcct$EditListCtx", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.fi_asset_dc_AssetAcct$EditListCtx",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_AccSchemas", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accSchemaId"} 
						]}})
			.addLov({name:"deprecAccount", dataIndex:"deprecAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "deprecAccountId"} 
						]}})
			.addLov({name:"acmlDeprecAccount", dataIndex:"acmlDeprecAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "acmlDeprecAccountId"} 
						]}})
			.addNumberColumn({name:"assetId", dataIndex:"assetId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"deprecAccountId", dataIndex:"deprecAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"acmlDeprecAccountId", dataIndex:"acmlDeprecAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
