/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.training.dc.PositionCourse", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.training.ds.model.PositionCourseDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.training.dc.PositionCourse$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_training_dc_PositionCourse$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"courseName", dataIndex:"courseName", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["courseName"])
		;
	}
});


/* ================= E-GRID: PositionCtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.training.dc.PositionCourse$PositionCtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_training_dc_PositionCourse$PositionCtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"courseCode", dataIndex:"courseCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"hr_training_lovs_Courses", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "courseId"} ,{lovField:"name", dsField: "courseName"} 
						]}})
			.addTextColumn({name:"courseName", dataIndex:"courseName", width:200})
			.addDateColumn({name:"validFor", dataIndex:"validFor", format: Dnet.DATETIME_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATETIME_FORMAT }
			})
			.addNumberColumn({name:"positionId", dataIndex:"positionId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"courseId", dataIndex:"courseId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= E-GRID: CourseCtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.training.dc.PositionCourse$CourseCtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_training_dc_PositionCourse$CourseCtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"positionCode", dataIndex:"positionCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"hr_job_lovs_Positions", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "positionId"} ,{lovField:"name", dsField: "positionName"} 
						]}})
			.addTextColumn({name:"positionName", dataIndex:"positionName", width:200})
			.addDateColumn({name:"validFor", dataIndex:"validFor", format: Dnet.DATETIME_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATETIME_FORMAT }
			})
			.addNumberColumn({name:"positionId", dataIndex:"positionId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"courseId", dataIndex:"courseId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
