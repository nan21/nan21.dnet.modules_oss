/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.dc.Contact", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.bp.ds.model.ContactDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.ContactDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.ContactDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.Contact$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_bp_dc_Contact$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"firstName", dataIndex:"firstName", anchor:"-20"})
			.addTextField({ name:"lastName", dataIndex:"lastName", anchor:"-20"})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersCode", name:"bpartnerCode", dataIndex:"bpartnerCode", anchor:"-20", maxLength:32})
			.addCombo({ xtype:"combo", name:"gender", dataIndex:"gender", anchor:"-20",
				store:[ "male", "female"]
			})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:220, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["firstName", "lastName"])
			.addChildrenTo("col2", ["bpartnerCode", "gender"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.Contact$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_bp_dc_Contact$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"firstName", dataIndex:"firstName", width:120})
			.addTextColumn({ name:"lastName", dataIndex:"lastName", width:120})
			.addNumberColumn({ name:"bpartnerId", dataIndex:"bpartnerId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode", width:100})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addTextColumn({ name:"gender", dataIndex:"gender", width:60})
			.addTextColumn({ name:"position", dataIndex:"position", width:200})
			.addDateColumn({ name:"birthdate", dataIndex:"birthdate", format: Dnet.DATE_FORMAT})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.Contact$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_bp_dc_Contact$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"firstName", dataIndex:"firstName", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"lastName", dataIndex:"lastName", width:120,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addComboColumn({name:"gender", dataIndex:"gender", width:60,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "male", "female"]}})
			.addTextColumn({name:"position", dataIndex:"position", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"birthdate", dataIndex:"birthdate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.Contact$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_bp_dc_Contact$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"firstName", dataIndex:"firstName", anchor:"-20"})
			.addTextField({ name:"lastName", dataIndex:"lastName", allowBlank:false, anchor:"-20"})
			.addCombo({ xtype:"combo", name:"gender", dataIndex:"gender", anchor:"-20",
				store:[ "male", "female"]
			})
			.addTextField({ name:"position", dataIndex:"position", anchor:"-20"})
			.addDateField({name:"birthdate", dataIndex:"birthdate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersCode", name:"bpartnerCode", dataIndex:"bpartnerCode", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["firstName", "lastName", "active"])
			.addChildrenTo("col2", ["gender", "birthdate"])
			.addChildrenTo("col3", ["bpartnerCode", "position"])
		;
	}});
