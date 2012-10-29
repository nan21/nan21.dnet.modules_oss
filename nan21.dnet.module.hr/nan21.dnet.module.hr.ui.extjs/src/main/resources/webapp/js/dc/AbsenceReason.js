/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.time.dc.AbsenceReason", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonDs",
	filterModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonDsFilter",
	paramModel: "net.nan21.dnet.module.hr.time.ds.param.AbsenceReasonDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.time.dc.AbsenceReason$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_time_dc_AbsenceReason$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"hr_time_lovs_AbsenceTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "type"])
			.addChildrenTo("col2", ["active"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.hr.time.dc.AbsenceReason$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_time_dc_AbsenceReason$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:120,
					editor:{xtype:"hr_time_lovs_AbsenceTypes", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "typeId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
