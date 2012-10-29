/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementCategory", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementCategoryDs",
	filterModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementCategoryDsFilter",
	paramModel: "net.nan21.dnet.module.bd.elem.ds.param.ElementCategoryDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementCategory$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_elem_dc_ElementCategory$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"bd_elem_lovs_Engines", name:"engine", dataIndex:"engine", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "engineId"} 
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
			.addChildrenTo("col1", ["name", "engine"])
			.addChildrenTo("col2", ["active"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementCategory$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_elem_dc_ElementCategory$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"engine", dataIndex:"engine", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_elem_lovs_Engines", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "engineId"} 
						]}})
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
