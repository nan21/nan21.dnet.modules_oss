/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.geo.dc.City", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.CityDs",
	filterModel: "net.nan21.dnet.module.bd.geo.ds.model.CityDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.City$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_geo_dc_City$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addNumberField({name:"countryId", dataIndex:"countryId", anchor:"-20"})
			.addLov({xtype:"bd_geo_lovs_Countries", name:"countryCode", dataIndex:"countryCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "countryId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name"])
			.addChildrenTo("col2", ["countryCode"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.City$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.bd_geo_dc_City$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:120})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addTextColumn({ name:"countryCode", dataIndex:"countryCode", width:100})
			.addTextColumn({ name:"regionCode", dataIndex:"regionCode", width:100})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addNumberColumn({ name:"countryId", dataIndex:"countryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"regionId", dataIndex:"regionId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.City$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_geo_dc_City$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"countryId", dataIndex:"countryId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"regionId", dataIndex:"regionId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
