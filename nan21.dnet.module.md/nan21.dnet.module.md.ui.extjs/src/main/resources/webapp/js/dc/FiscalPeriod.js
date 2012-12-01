/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodDs",
	filterModel: "net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_base_period_dc_FiscalPeriod$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "month", "quarter", "half-year", "other"]
			})
			.addLov({xtype:"md_base_period_lovs_FiscalYears", name:"year", dataIndex:"year", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "yearId"} 
				]})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"posting", dataIndex:"posting", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["code", "name"])
			.addChildrenTo("col2", ["year", "type"])
			.addChildrenTo("col3", ["posting", "active"])
		;
	}
});


/* ================= FILTER: FilterCtx ================= */


Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.md_base_period_dc_FiscalPeriod$FilterCtx",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "month", "quarter", "half-year", "other"]
			})
			.addBooleanField({ name:"posting", dataIndex:"posting", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_base_period_dc_FiscalPeriod$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addDateColumn({ name:"startDate", dataIndex:"startDate", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"endDate", dataIndex:"endDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"year", dataIndex:"year", width:100})
			.addTextColumn({ name:"type", dataIndex:"type", width:80})
			.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
			.addBooleanColumn({ name:"posting", dataIndex:"posting"})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addDefaults();
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_base_period_dc_FiscalPeriod$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addDateColumn({name:"startDate", dataIndex:"startDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"endDate", dataIndex:"endDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addComboColumn({name:"type", dataIndex:"type", width:80,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "month", "quarter", "half-year", "other"]}})
			.addLov({name:"year", dataIndex:"year", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_base_period_lovs_FiscalYears", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "yearId"} 
						]}})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"posting", dataIndex:"posting"})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_base_period_dc_FiscalPeriod$CtxEditList",
	_bulkEditFields_: ["type","active","posting"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addDateColumn({name:"startDate", dataIndex:"startDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"endDate", dataIndex:"endDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addComboColumn({name:"type", dataIndex:"type", width:80,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "month", "quarter", "half-year", "other"]}})
			.addBooleanColumn({name:"posting", dataIndex:"posting"})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_base_period_dc_FiscalPeriod$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"posting", dataIndex:"posting", anchor:"-20"})
			.addTextField({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addDateField({name:"startDate", dataIndex:"startDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"endDate", dataIndex:"endDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "month", "quarter", "half-year", "other"]
			})
			.addLov({xtype:"md_base_period_lovs_FiscalYears", name:"year", dataIndex:"year", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "yearId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:160, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code", "notes"])
			.addChildrenTo("col2", ["year", "startDate", "endDate", "type"])
			.addChildrenTo("col3", ["posting", "active"])
		;
	}
});
