/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.activity.dc.Task", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.activity.ds.model.MyCalendarTaskDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.Task$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_activity_dc_Task$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"subject", dataIndex:"subject", anchor:"-20"})
			.addDateField({name:"startDate", dataIndex:"startDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"endDate", dataIndex:"endDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_activity_lovs_CalendarEventStatusTask", name:"statusName", _sharedLabel_:true, dataIndex:"statusName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"md_activity_lovs_CalendarEventPrioritiesTask", name:"priorityName", dataIndex:"priorityName", anchor:"-20",
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
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.Task$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_activity_dc_Task$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"subject", dataIndex:"subject", width:200})
			.addDateColumn({ name:"startDate", dataIndex:"startDate", format: Dnet.DATETIME_FORMAT})
			.addDateColumn({ name:"endDate", dataIndex:"endDate", format: Dnet.DATETIME_FORMAT})
			.addBooleanColumn({ name:"allDay", dataIndex:"allDay"})
			.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode", width:100})
			.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
			.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"statusName", dataIndex:"statusName", width:100})
			.addNumberColumn({ name:"priorityId", dataIndex:"priorityId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"priorityName", dataIndex:"priorityName", width:100})
			.addDateColumn({ name:"dueDate", dataIndex:"dueDate", format: Dnet.DATETIME_FORMAT})
			.addDefaults();
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.Task$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_activity_dc_Task$EditList",
	
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
			.addDateColumn({name:"dueDate", dataIndex:"dueDate", format: Dnet.DATETIME_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATETIME_FORMAT }
			})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"statusId", dataIndex:"statusId", hidden:true, align:"right", width:70, format:"0"})
			.addTextColumn({name:"statusName", dataIndex:"statusName", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"priorityId", dataIndex:"priorityId", hidden:true, align:"right", width:70, format:"0"})
			.addTextColumn({name:"priorityName", dataIndex:"priorityName", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.activity.dc.Task$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_activity_dc_Task$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"subject", dataIndex:"subject", allowBlank:false, anchor:"-20"})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20", height:100})
			.addBooleanField({ name:"allDay", dataIndex:"allDay", anchor:"-20"})
			.addLov({xtype:"md_activity_lovs_CalendarEventStatusTask", name:"statusName", _sharedLabel_:true, dataIndex:"statusName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"md_activity_lovs_CalendarEventPrioritiesTask", name:"priorityName", dataIndex:"priorityName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priorityId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersCode", name:"bpartnerCode", dataIndex:"bpartnerCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "bpartnerId"} 
				]})
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
			.addChildrenTo("col1", ["subject", "allDay", "startDate", "endDate"])
			.addChildrenTo("col2", ["bpartnerCode", "statusName", "priorityName", "dueDate"])
			.addChildrenTo("row2", ["notes"])
		;
	}
});
