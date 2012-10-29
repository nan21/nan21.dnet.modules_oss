/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.uom.dc.UomType", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.uom.ds.model.UomTypeDs",
	filterModel: "net.nan21.dnet.module.bd.uom.ds.model.UomTypeDsFilter",
	paramModel: "net.nan21.dnet.module.bd.uom.ds.param.UomTypeDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.uom.dc.UomType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_uom_dc_UomType$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"category", dataIndex:"category", anchor:"-20",
				store:[ "length", "mass", "volume", "other"]
			})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "category"])
			.addChildrenTo("col2", ["active"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.uom.dc.UomType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_uom_dc_UomType$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addComboColumn({name:"category", dataIndex:"category", width:100,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "length", "mass", "volume", "other"]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
