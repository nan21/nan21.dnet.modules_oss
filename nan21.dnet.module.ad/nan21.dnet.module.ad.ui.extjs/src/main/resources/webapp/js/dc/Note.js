/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.data.dc.Note", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.data.ds.model.NoteDs",
	filterModel: "net.nan21.dnet.module.ad.data.ds.model.NoteDsFilter",
	paramModel: "net.nan21.dnet.module.ad.data.ds.param.NoteDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.data.dc.Note$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_data_dc_Note$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"modifiedBy", _sharedLabel_:true, dataIndex:"modifiedBy", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["modifiedBy"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.data.dc.Note$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_data_dc_Note$List",
	_noImport_: true,
	_noExport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"note", dataIndex:"note", width:200})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.ad.data.dc.Note$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_data_dc_Note$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextArea({ name:"note", dataIndex:"note", allowBlank:false, anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form", defaults:{labelAlign:"top"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["note"])
		;
	}});
