/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.uom.dc.Uom", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.uom.ds.model.UomDs",
	filterModel: "net.nan21.dnet.module.bd.uom.ds.model.UomDsFilter",
	paramModel: "net.nan21.dnet.module.bd.uom.ds.param.UomDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.uom.dc.Uom$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_uom_dc_Uom$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"bd_uom_lovs_UomType", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
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
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["type", "active"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.bd.uom.dc.Uom$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.bd_uom_dc_Uom$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.uom.dc.Uom$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_uom_dc_Uom$EditList",
	_bulkEditFields_: ["type","active","notes"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_uom_lovs_UomType", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "typeId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"typeId", dataIndex:"typeId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.bd.uom.dc.Uom$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.bd_uom_dc_Uom$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", allowBlank:false, anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addLov({xtype:"bd_uom_lovs_UomType", name:"type", _sharedLabel_:true, dataIndex:"type", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:350, layout:"form"})
			.addPanel({ name:"col2", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "code", "type"])
			.addChildrenTo("col2", ["notes", "active"])
		;
	}});
