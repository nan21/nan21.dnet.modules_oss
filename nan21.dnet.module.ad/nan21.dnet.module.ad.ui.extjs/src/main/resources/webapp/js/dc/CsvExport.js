/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExport", {
	extend: "dnet.core.dc.AbstractDc",

	paramModel: "net.nan21.dnet.module.ad.impex.ds.model.CsvExportDsParam",
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.CsvExportDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExport$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_impex_dc_CsvExport$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addLov({xtype:"ad_system_lovs_SysDataSource", name:"dataSource", dataIndex:"dataSource", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "dataSource"])
			.addChildrenTo("col2", ["active"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExport$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_impex_dc_CsvExport$EditList",
	_bulkEditFields_: ["active"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:180,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:180,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"dataSource", dataIndex:"dataSource", xtype:"gridcolumn", width:180,
					editor:{xtype:"ad_system_lovs_SysDataSource", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}
});


/* ================= EDITOR: Clone ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExport$Clone", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_impex_dc_CsvExport$Clone",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"cloneName", paramIndex:"cloneName", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["cloneName"])
		;
	}
});
