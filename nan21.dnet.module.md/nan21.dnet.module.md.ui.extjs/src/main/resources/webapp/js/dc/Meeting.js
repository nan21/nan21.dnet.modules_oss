/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.activity.dc.Meeting", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.activity.ds.model.MyCalendarMeetingDs",
	filterModel: "net.nan21.dnet.module.md.activity.ds.model.MyCalendarMeetingDsFilter",
	paramModel: "net.nan21.dnet.module.md.activity.ds.param.MyCalendarMeetingDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.Meeting$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_activity_dc_Meeting$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"subject", dataIndex:"subject", anchor:"-20"})
			.addDateField({name:"startDate", dataIndex:"startDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"endDate", dataIndex:"endDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_activity_lovs_CalendarEventStatusMeeting", name:"statusName", _sharedLabel_:true, dataIndex:"statusName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"md_activity_lovs_CalendarEventPrioritiesMeeting", name:"priorityName", dataIndex:"priorityName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priorityId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersCode", name:"bpartnerCode", dataIndex:"bpartnerCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "bpartnerId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:210, layout:"form"})
			.addPanel({ name:"col4", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["subject"])
			.addChildrenTo("col2", ["statusName", "priorityName"])
			.addChildrenTo("col3", ["startDate", "endDate"])
			.addChildrenTo("col4", ["bpartnerCode"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.Meeting$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_activity_dc_Meeting$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"subject", dataIndex:"subject", width:200})
			.addDateColumn({ name:"startDate", dataIndex:"startDate", format: Dnet.DATETIME_FORMAT})
			.addDateColumn({ name:"endDate", dataIndex:"endDate", format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode", width:100})
			.addTextColumn({ name:"location", dataIndex:"location", width:200})
			.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
			.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"statusName", dataIndex:"statusName", width:100})
			.addNumberColumn({ name:"priorityId", dataIndex:"priorityId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"priorityName", dataIndex:"priorityName", width:100})
			.addDefaults();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.Meeting$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_activity_dc_Meeting$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"subject", dataIndex:"subject", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"startDate", dataIndex:"startDate", format: Dnet.DATETIME_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATETIME_FORMAT }
			})
			.addDateColumn({name:"endDate", dataIndex:"endDate", format: Dnet.DATETIME_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATETIME_FORMAT }
			})
			.addTextColumn({name:"location", dataIndex:"location", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"statusId", dataIndex:"statusId", hidden:true, align:"right", width:70, format:"0"})
			.addTextColumn({name:"statusName", dataIndex:"statusName", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.Meeting$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_activity_dc_Meeting$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"subject", dataIndex:"subject", allowBlank:false, anchor:"-20"})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addNumberField({name:"statusId", _sharedLabel_:true, dataIndex:"statusId", disabled:true , anchor:"-20"})
			.addLov({xtype:"md_activity_lovs_CalendarEventStatusMeeting", name:"statusName", _sharedLabel_:true, dataIndex:"statusName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addNumberField({name:"priorityId", dataIndex:"priorityId", disabled:true , anchor:"-20"})
			.addLov({xtype:"md_activity_lovs_CalendarEventPrioritiesMeeting", name:"priorityName", dataIndex:"priorityName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priorityId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersCode", name:"bpartnerCode", dataIndex:"bpartnerCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "bpartnerId"} 
				]})
			.addTextField({ name:"location", dataIndex:"location", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true})
			.addPanel({ name:"row1", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col1", width:400, layout:"form"})
			.addPanel({ name:"col2", width:400, layout:"form"})
			.addPanel({ name:"row2", width:800, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["row1", "row2"])
			.addChildrenTo("row1", ["col1", "col2"])
			.addChildrenTo("col1", ["subject", "startDate", "endDate", "location"])
			.addChildrenTo("col2", ["bpartnerCode", "statusName", "priorityName"])
			.addChildrenTo("row2", ["notes"])
		;
	}});
