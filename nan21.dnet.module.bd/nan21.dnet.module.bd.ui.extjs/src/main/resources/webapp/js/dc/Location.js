/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.geo.dc.Location", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.LocationDs",
	filterModel: "net.nan21.dnet.module.bd.geo.ds.model.LocationDsFilter",
	paramModel: "net.nan21.dnet.module.bd.geo.ds.param.LocationDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.Location$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_geo_dc_Location$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_geo_lovs_Countries", name:"countryCode", dataIndex:"countryCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "countryId"} 
				]})
			.addLov({xtype:"bd_geo_lovs_Regions", name:"regionCode", dataIndex:"regionCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "regionId"} 
				],
				filterFieldMapping: [
					{lovField:"countryId",dsField: "countryId"} 
				]})
			.addTextField({ name:"cityName", dataIndex:"cityName", anchor:"-20"})
			.addTextField({ name:"targetUuid", dataIndex:"targetUuid", anchor:"-20"})
			.addTextField({ name:"targetType", dataIndex:"targetType", anchor:"-20"})
			.addBooleanField({ name:"billing", dataIndex:"billing", anchor:"-20"})
			.addBooleanField({ name:"mailing", dataIndex:"mailing", anchor:"-20"})
			.addBooleanField({ name:"shipping", dataIndex:"shipping", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:180, layout:"form"})
			.addPanel({ name:"col3", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["countryCode", "regionCode", "cityName"])
			.addChildrenTo("col2", ["billing", "mailing", "shipping", "active"])
			.addChildrenTo("col3", ["targetType", "targetUuid"])
		;
	}});


/* ================= GRID: ListCtx ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.Location$ListCtx", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.bd_geo_dc_Location$ListCtx",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"countryCode", dataIndex:"countryCode", width:100})
			.addTextColumn({ name:"regionCode", dataIndex:"regionCode", width:100})
			.addTextColumn({ name:"cityName", dataIndex:"cityName", width:120})
			.addTextColumn({ name:"adress", dataIndex:"adress", width:200})
			.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
			.addBooleanColumn({ name:"billing", dataIndex:"billing", width:60})
			.addBooleanColumn({ name:"mailing", dataIndex:"mailing", width:60})
			.addBooleanColumn({ name:"shipping", dataIndex:"shipping", width:60})
			.addBooleanColumn({ name:"active", dataIndex:"active", width:60})
			.addNumberColumn({ name:"countryId", dataIndex:"countryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"regionId", dataIndex:"regionId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"targetType", dataIndex:"targetType", hidden:true, width:150})
			.addTextColumn({ name:"targetUuid", dataIndex:"targetUuid", hidden:true, width:100})
			.addDefaults();
	}});


/* ================= EDITOR: EditCtx ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.Location$EditCtx", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.bd_geo_dc_Location$EditCtx",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_geo_lovs_Countries", name:"countryCode", dataIndex:"countryCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "countryId"} 
				]})
			.addLov({xtype:"bd_geo_lovs_Regions", name:"regionCode", dataIndex:"regionCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "regionId"} 
				],
				filterFieldMapping: [
					{lovField:"countryId",dsField: "countryId"} 
				]})
			.addTextField({ name:"cityName", dataIndex:"cityName", anchor:"-20"})
			.addTextArea({ name:"adress", dataIndex:"adress", allowBlank:false, anchor:"-20"})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addBooleanField({ name:"billing", dataIndex:"billing", anchor:"-20"})
			.addBooleanField({ name:"mailing", dataIndex:"mailing", anchor:"-20"})
			.addBooleanField({ name:"shipping", dataIndex:"shipping", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:350, layout:"form"})
			.addPanel({ name:"col3", width:200, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["countryCode", "regionCode", "cityName"])
			.addChildrenTo("col2", ["adress", "notes"])
			.addChildrenTo("col3", ["billing", "mailing", "shipping", "active"])
		;
	}});
