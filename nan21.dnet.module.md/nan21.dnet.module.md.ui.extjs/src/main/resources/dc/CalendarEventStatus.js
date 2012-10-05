/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.activity.dc.CalendarEventStatus", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.activity.ds.model.CalendarEventStatusDs",
	filterModel: "net.nan21.dnet.module.md.activity.ds.model.CalendarEventStatusDsFilter",
	paramModel: "net.nan21.dnet.module.md.activity.ds.param.CalendarEventStatusDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.CalendarEventStatus$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_activity_dc_CalendarEventStatus$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"eventType", dataIndex:"eventType", anchor:"-20",
				store:[ "call", "meeting", "task"]
			})
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
			.addChildrenTo("col1", ["name", "eventType", "active"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.CalendarEventStatus$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_activity_dc_CalendarEventStatus$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
