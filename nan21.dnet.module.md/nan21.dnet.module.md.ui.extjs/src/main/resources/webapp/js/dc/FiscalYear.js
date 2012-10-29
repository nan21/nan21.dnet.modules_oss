/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalYear", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.base.period.ds.model.FiscalYearDs",
	filterModel: "net.nan21.dnet.module.md.base.period.ds.model.FiscalYearDsFilter",
	paramModel: "net.nan21.dnet.module.md.base.period.ds.param.FiscalYearDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalYear$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_base_period_dc_FiscalYear$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_Calendars", name:"calendar", dataIndex:"calendar", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "calendarId"} 
				]})
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
			.addChildrenTo("col1", ["code", "name"])
			.addChildrenTo("col2", ["calendar", "active"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalYear$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_base_period_dc_FiscalYear$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addDateColumn({ name:"startDate", dataIndex:"startDate", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"endDate", dataIndex:"endDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"calendar", dataIndex:"calendar", width:120})
			.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addDefaults();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalYear$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_base_period_dc_FiscalYear$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"startDate", dataIndex:"startDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"endDate", dataIndex:"endDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"calendar", dataIndex:"calendar", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_org_lovs_Calendars", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "calendarId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalYear$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_base_period_dc_FiscalYear$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextField({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_Calendars", name:"calendar", dataIndex:"calendar", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "calendarId"} 
				]})
			.addDateField({name:"startDate", dataIndex:"startDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"endDate", dataIndex:"endDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "code", "notes"])
			.addChildrenTo("col2", ["calendar", "startDate", "endDate", "active"])
		;
	}});
