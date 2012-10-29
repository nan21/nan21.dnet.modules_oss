/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItem", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDsFilter",
	paramModel: "net.nan21.dnet.module.ad.impex.ds.param.ImportMapItemDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItem$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_impex_dc_ImportMapItem$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"ad_impex_lovs_ImportMap", name:"importMapName", dataIndex:"importMapName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "importMapId"} 
				]})
			.addLov({xtype:"ad_system_lovs_SysDataSource", name:"dataSource", dataIndex:"dataSource", anchor:"-20"})
			.addTextField({ name:"path", dataIndex:"path", anchor:"-20"})
			.addTextField({ name:"fileName", dataIndex:"fileName", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["importMapName", "dataSource"])
			.addChildrenTo("col2", ["path", "fileName"])
			.addChildrenTo("col3", ["active"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItem$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_impex_dc_ImportMapItem$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"importMapId", dataIndex:"importMapId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"importMapName", dataIndex:"importMapName", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_impex_lovs_ImportMap", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "importMapId"} 
						]}})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"dataSource", dataIndex:"dataSource", xtype:"gridcolumn", width:150,
					editor:{xtype:"ad_system_lovs_SysDataSource", selectOnFocus:true}})
			.addTextColumn({name:"path", dataIndex:"path", width:150,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"fileName", dataIndex:"fileName", width:300,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"ukFieldName", dataIndex:"ukFieldName", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});


/* ================= FILTER: ImportFileForm ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItem$ImportFileForm", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_impex_dc_ImportMapItem$ImportFileForm",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"ad_system_lovs_SysDataSource", name:"importDataSource", paramIndex:"importDataSource", anchor:"-20"})
			.addTextField({ name:"importFileLocation", paramIndex:"importFileLocation", anchor:"-20"})
			.addTextField({ name:"importUkFieldName", paramIndex:"importUkFieldName", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, width:450, layout:"form", defaults:{labelAlign:"right", labelWidth:140}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["importFileLocation", "importDataSource", "importUkFieldName"])
		;
	}});
