/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.base.dc.ProjectType", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ProjectTypeDs",
	filterModel: "net.nan21.dnet.module.pj.base.ds.model.ProjectTypeDsFilter",
	paramModel: "net.nan21.dnet.module.pj.base.ds.param.ProjectTypeDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.pj.base.dc.ProjectType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.pj_base_dc_ProjectType$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"pj_base_lovs_ProjectCategories", name:"category", dataIndex:"category", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "categoryId"} 
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
			.addChildrenTo("col1", ["name", "category"])
			.addChildrenTo("col2", ["active"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.pj.base.dc.ProjectType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.pj_base_dc_ProjectType$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:150,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"category", dataIndex:"category", xtype:"gridcolumn", width:120,
					editor:{xtype:"pj_base_lovs_ProjectCategories", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "categoryId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
