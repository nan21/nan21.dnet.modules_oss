/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ExportMapItemDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.ExportMapItemDsFilter",
	paramModel: "net.nan21.dnet.module.ad.impex.ds.param.ExportMapItemDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_impex_dc_ExportMapItem$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"exportMap", dataIndex:"exportMap", anchor:"-20"})
			.addTextField({ name:"csvExport", dataIndex:"csvExport", anchor:"-20"})
			.addTextField({ name:"fileName", dataIndex:"fileName", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["exportMap", "csvExport"])
			.addChildrenTo("col2", ["active"])
		;
	}});


/* ================= FILTER: FilterCtx ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.ad_impex_dc_ExportMapItem$FilterCtx",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"csvExport", dataIndex:"csvExport", anchor:"-20"})
			.addTextField({ name:"fileName", dataIndex:"fileName", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
		;
	},

});


/* ================= E-GRID: EditListCtxExpMap ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem$EditListCtxExpMap", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_impex_dc_ExportMapItem$EditListCtxExpMap",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"exportMap", dataIndex:"exportMap", hidden:true, width:120})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"csvExport", dataIndex:"csvExport", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_impex_lovs_CsvExports", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "csvExportId"} 
						]}})
			.addTextColumn({name:"path", dataIndex:"path", width:150,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"fileName", dataIndex:"fileName", width:150,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"csvExportId", dataIndex:"csvExportId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: EditListCtxCsvExp ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem$EditListCtxCsvExp", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_impex_dc_ExportMapItem$EditListCtxCsvExp",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"csvExport", dataIndex:"csvExport", hidden:true, width:120})
			.addLov({name:"exportMap", dataIndex:"exportMap", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_impex_lovs_ExportMaps", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "exportMapId"} 
						]}})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addTextColumn({name:"path", dataIndex:"path", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"fileName", dataIndex:"fileName", width:150,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"csvExportId", dataIndex:"csvExportId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
