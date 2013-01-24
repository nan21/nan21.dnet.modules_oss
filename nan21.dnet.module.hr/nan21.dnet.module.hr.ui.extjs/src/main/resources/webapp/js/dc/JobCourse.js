/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.training.dc.JobCourse", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.training.ds.model.JobCourseDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.training.dc.JobCourse$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_training_dc_JobCourse$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"courseCode", dataIndex:"courseCode", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["courseCode"])
		;
	}
});


/* ================= E-GRID: JobCtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.training.dc.JobCourse$JobCtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_training_dc_JobCourse$JobCtxEditList",
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
			.addNumberColumn({name:"validFor", dataIndex:"validFor", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"jobId", dataIndex:"jobId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"courseId", dataIndex:"courseId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= E-GRID: CourseCtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.training.dc.JobCourse$CourseCtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_training_dc_JobCourse$CourseCtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"jobCode", dataIndex:"jobCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"hr_job_lovs_Jobs", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "jobId"} ,{lovField:"name", dsField: "jobName"} 
						]}})
			.addTextColumn({name:"jobName", dataIndex:"jobName", width:200})
			.addNumberColumn({name:"validFor", dataIndex:"validFor", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"jobId", dataIndex:"jobId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"courseId", dataIndex:"courseId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
