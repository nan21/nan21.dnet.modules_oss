/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.acc.dc.AccJournal", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccJournalDs",
	filterModel: "net.nan21.dnet.module.md.acc.ds.model.AccJournalDsFilter",
	paramModel: "net.nan21.dnet.module.md.acc.ds.param.AccJournalDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.AccJournal$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_acc_dc_AccJournal$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["name", "active"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.AccJournal$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_acc_dc_AccJournal$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:120})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addDefaults();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.AccJournal$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_acc_dc_AccJournal$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.AccJournal$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_acc_dc_AccJournal$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextField({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["name", "description", "active"])
		;
	}});
