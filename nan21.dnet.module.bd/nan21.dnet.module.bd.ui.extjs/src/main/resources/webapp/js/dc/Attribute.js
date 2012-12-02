/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.attr.dc.Attribute", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.attr.dc.Attribute$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_attr_dc_Attribute$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"title", dataIndex:"title", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"bd_attr_lovs_AttributeCategory", name:"category", dataIndex:"category", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "categoryId"} 
				]})
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasure", name:"uom", dataIndex:"uom", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "uomId"} 
				]})
			.addCombo({ xtype:"combo", name:"dataType", dataIndex:"dataType", anchor:"-20",
				store:[ "string", "text", "integer", "decimal", "boolean", "date"]
			})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "dataType"])
			.addChildrenTo("col2", ["category", "uom"])
			.addChildrenTo("col3", ["active"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.attr.dc.Attribute$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_attr_dc_Attribute$EditList",
	_bulkEditFields_: ["active","category","dataType","uom"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"title", dataIndex:"title", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"listOfvalues", dataIndex:"listOfvalues", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"category", dataIndex:"category", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_attr_lovs_AttributeCategory", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "categoryId"} 
						]}})
			.addComboColumn({name:"dataType", dataIndex:"dataType", width:100,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "string", "text", "integer", "decimal", "boolean", "date"]}})
			.addLov({name:"uom", dataIndex:"uom", xtype:"gridcolumn", width:80,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasureCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "uomId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active", width:60})
			.addNumberColumn({name:"categoryId", dataIndex:"categoryId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
