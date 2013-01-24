/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.activity.dc.MyCalendarEvent", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.activity.ds.model.MyCalendarEventDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_activity_dc_MyCalendarEvent$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"subject", dataIndex:"subject", anchor:"-20"})
			.addDateField({name:"startDate", dataIndex:"startDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"endDate", dataIndex:"endDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addTextField({ name:"eventType", dataIndex:"eventType", anchor:"-20", maxLength:16})
			.addNumberField({name:"statusId", _sharedLabel_:true, dataIndex:"statusId", anchor:"-20"})
			.addTextField({ name:"statusName", _sharedLabel_:true, dataIndex:"statusName", anchor:"-20"})
			.addNumberField({name:"priorityId", dataIndex:"priorityId", anchor:"-20"})
			.addTextField({ name:"priorityName", dataIndex:"priorityName", anchor:"-20"})
			.addNumberField({name:"bpartnerId", dataIndex:"bpartnerId", anchor:"-20"})
			.addTextField({ name:"bpartnerCode", dataIndex:"bpartnerCode", anchor:"-20", maxLength:32})
			.addTextField({ name:"createdBy", _sharedLabel_:true, dataIndex:"createdBy", anchor:"-20", maxLength:32})
			.addTextField({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addTextField({ name:"location", dataIndex:"location", anchor:"-20"})
			.addTextField({ name:"url", dataIndex:"url", anchor:"-20"})
			.addTextField({ name:"reminder", dataIndex:"reminder", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"allDay", dataIndex:"allDay", anchor:"-20"})
			.addNumberField({name:"id", _sharedLabel_:true, dataIndex:"id", anchor:"-20"})
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
			.addChildrenTo("col1", ["subject", "eventType", "statusName", "priorityName", "bpartnerCode", "createdBy", "notes", "location", "url", "reminder"])
			.addChildrenTo("col2", ["subject", "eventType", "statusName", "priorityName", "bpartnerCode", "createdBy", "notes", "location", "url", "reminder"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_activity_dc_MyCalendarEvent$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"eventType", dataIndex:"eventType", width:100})
			.addTextColumn({ name:"subject", dataIndex:"subject", width:200})
			.addDateColumn({ name:"startDate", dataIndex:"startDate", format: Dnet.DATETIME_FORMAT})
			.addDateColumn({ name:"endDate", dataIndex:"endDate", format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"statusName", dataIndex:"statusName", width:120})
			.addTextColumn({ name:"priorityName", dataIndex:"priorityName", width:120})
			.addTextColumn({ name:"reminder", dataIndex:"reminder", width:100})
			.addDefaults();
	}
});


/* ================= EDITOR: Create ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$Create", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_activity_dc_MyCalendarEvent$Create",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addCombo({ xtype:"combo", name:"eventType", dataIndex:"eventType", anchor:"-20",
				store:[ "call", "meeting", "task"]
			})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["eventType"])
		;
	}
});


/* ================= EDITOR: EditCall ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$EditCall", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_activity_dc_MyCalendarEvent$EditCall",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"subject", dataIndex:"subject", allowBlank:false, anchor:"-20"})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20", height:80})
			.addDateField({name:"dueDate", dataIndex:"dueDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_activity_lovs_CalendarEventStatusCall", name:"statusName", _sharedLabel_:true, dataIndex:"statusName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"md_activity_lovs_CalendarEventPrioritiesCall", name:"priorityName", dataIndex:"priorityName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priorityId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BpContacts", name:"contact", dataIndex:"contact", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "contactId"} 
				],
				filterFieldMapping: [
					{lovField:"bpartnerId",dsField: "bpartnerId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true})
			.addPanel({ name:"row1", width:700, layout:"form"})
			.addPanel({ name:"row2", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col1", width:280, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"row3", width:700, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["row1", "row2", "row3"])
			.addChildrenTo("row1", ["subject"])
			.addChildrenTo("row2", ["col1", "col2"])
			.addChildrenTo("col1", ["startDate", "endDate", "dueDate"])
			.addChildrenTo("col2", ["statusName", "priorityName", "contact"])
			.addChildrenTo("row3", ["notes"])
		;
	}
});


/* ================= EDITOR: EditMeeting ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$EditMeeting", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_activity_dc_MyCalendarEvent$EditMeeting",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"subject", dataIndex:"subject", allowBlank:false, anchor:"-20"})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20", height:80})
			.addTextField({ name:"location", dataIndex:"location", anchor:"-20"})
			.addDateField({name:"dueDate", dataIndex:"dueDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_activity_lovs_CalendarEventStatusMeeting", name:"statusName", _sharedLabel_:true, dataIndex:"statusName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"md_activity_lovs_CalendarEventPrioritiesMeeting", name:"priorityName", dataIndex:"priorityName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priorityId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BpContacts", name:"contact", dataIndex:"contact", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "contactId"} 
				],
				filterFieldMapping: [
					{lovField:"bpartnerId",dsField: "bpartnerId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true})
			.addPanel({ name:"row1", width:700, layout:"form"})
			.addPanel({ name:"row2", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col1", width:280, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:250, layout:"form", defaults:{labelAlign:"top"}})
			.addPanel({ name:"row3", width:700, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["row1", "row2", "row3"])
			.addChildrenTo("row1", ["subject"])
			.addChildrenTo("row2", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["startDate", "endDate", "dueDate"])
			.addChildrenTo("col2", ["statusName", "priorityName", "contact"])
			.addChildrenTo("col3", ["location"])
			.addChildrenTo("row3", ["notes"])
		;
	}
});


/* ================= EDITOR: EditTask ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$EditTask", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_activity_dc_MyCalendarEvent$EditTask",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"subject", dataIndex:"subject", allowBlank:false, anchor:"-20"})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20", height:80})
			.addDateField({name:"dueDate", dataIndex:"dueDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_activity_lovs_CalendarEventStatusTask", name:"statusName", _sharedLabel_:true, dataIndex:"statusName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"md_activity_lovs_CalendarEventPrioritiesTask", name:"priorityName", dataIndex:"priorityName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priorityId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true})
			.addPanel({ name:"row1", width:700, layout:"form"})
			.addPanel({ name:"row2", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col1", width:280, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"row3", width:700, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["row1", "row2", "row3"])
			.addChildrenTo("row1", ["subject"])
			.addChildrenTo("row2", ["col1", "col2"])
			.addChildrenTo("col1", ["startDate", "endDate", "dueDate"])
			.addChildrenTo("col2", ["statusName", "priorityName"])
			.addChildrenTo("row3", ["notes"])
		;
	}
});
