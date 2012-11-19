/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.system.dc.SysTimer", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysTimerDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysTimerDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysTimerDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysTimer$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_system_dc_SysTimer$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"ad_system_lovs_SysJobCtx", name:"jobCtx", dataIndex:"jobCtx", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "jobCtxId"} 
				]})
			.addDateField({name:"startTime_From", dataIndex:"startTime_From", emptyText:"From" })
			.addDateField({name:"startTime_To", dataIndex:"startTime_To", emptyText:"To" })
			.addFieldContainer({name: "startTime", fieldLabel:"Start Time"})
				.addChildrenTo("startTime",["startTime_From", "startTime_To"])
			.addDateField({name:"endTime_From", dataIndex:"endTime_From", emptyText:"From" })
			.addDateField({name:"endTime_To", dataIndex:"endTime_To", emptyText:"To" })
			.addFieldContainer({name: "endTime", fieldLabel:"End Time"})
				.addChildrenTo("endTime",["endTime_From", "endTime_To"])
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "simple", "cron"]
			})
			.addCombo({ xtype:"combo", name:"repeatIntervalType", dataIndex:"repeatIntervalType", anchor:"-20",
				store:[ "seconds", "minutes", "hours"]
			})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:290, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "active"])
			.addChildrenTo("col2", ["type", "repeatIntervalType"])
			.addChildrenTo("col3", ["startTime", "endTime", "jobCtx"])
		;
	}});


/* ================= GRID: CtxListJob ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysTimer$CtxListJob", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_system_dc_SysTimer$CtxListJob",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:150})
			.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addTextColumn({ name:"type", dataIndex:"type", width:60})
			.addDateColumn({ name:"startTime", dataIndex:"startTime", format: Dnet.DATETIME_FORMAT})
			.addDateColumn({ name:"endTime", dataIndex:"endTime", hidden:true, format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"cronExpression", dataIndex:"cronExpression", hidden:true, width:200})
			.addNumberColumn({ name:"repeatCount", dataIndex:"repeatCount", hidden:true})
			.addNumberColumn({ name:"repeatInterval", dataIndex:"repeatInterval", hidden:true})
			.addTextColumn({ name:"repeatIntervalType", dataIndex:"repeatIntervalType", hidden:true, width:60})
			.addDefaults();
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysTimer$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_system_dc_SysTimer$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"jobCtx", dataIndex:"jobCtx", width:120})
			.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
			.addTextColumn({ name:"name", dataIndex:"name", width:150})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addTextColumn({ name:"type", dataIndex:"type", width:60})
			.addDateColumn({ name:"startTime", dataIndex:"startTime", format: Dnet.DATETIME_FORMAT})
			.addDateColumn({ name:"endTime", dataIndex:"endTime", format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"cronExpression", dataIndex:"cronExpression", hidden:true, width:200})
			.addNumberColumn({ name:"repeatCount", dataIndex:"repeatCount", hidden:true})
			.addNumberColumn({ name:"repeatInterval", dataIndex:"repeatInterval", hidden:true})
			.addTextColumn({ name:"repeatIntervalType", dataIndex:"repeatIntervalType", hidden:true, width:60})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysTimer$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_system_dc_SysTimer$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "simple", "cron"]
			,listeners:{
				change:{scope:this, fn:this.onTypeChange}
			}
			})
			.addTextField({ name:"cronExpression", dataIndex:"cronExpression", anchor:"-20"})
			.addNumberField({name:"repeatCount", dataIndex:"repeatCount", anchor:"-20"})
			.addNumberField({name:"repeatInterval", dataIndex:"repeatInterval", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"repeatIntervalType", dataIndex:"repeatIntervalType", anchor:"-20",
				store:[ "seconds", "minutes", "hours"]
			})
			.addLov({xtype:"ad_system_lovs_SysJobCtx", name:"jobCtx", dataIndex:"jobCtx", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "jobCtxId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["jobCtx", "name", "description", "type", "startTime", "endTime", "active", "cronExpression", "repeatCount", "repeatInterval", "repeatIntervalType"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	onTypeChange: function() {
		var r = this._getController_().getRecord();		 
				this._setFieldsVisibleState_(["cronExpression","repeatCount","repeatInterval","repeatIntervalType"], r);
	}
});
