/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeSetAttributeDs",
	filterModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeSetAttributeDsFilter",
	paramModel: "net.nan21.dnet.module.bd.attr.ds.param.AttributeSetAttributeDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_attr_dc_AttributeSetAttribute$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_attr_lovs_AttributeSet", name:"set", dataIndex:"set", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "setId"} 
				]})
			.addLov({xtype:"bd_attr_lovs_Attribute", name:"attribute", dataIndex:"attribute", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "attributeId"} 
				]})
			.addBooleanField({ name:"inDescription", dataIndex:"inDescription", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["set", "attribute"])
			.addChildrenTo("col2", ["inDescription"])
		;
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_attr_dc_AttributeSetAttribute$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"set", dataIndex:"set", hidden:true, width:120})
			.addNumberColumn({name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"attribute", dataIndex:"attribute", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_attr_lovs_Attribute", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "attributeId"} 
						]}})
			.addBooleanColumn({name:"inDescription", dataIndex:"inDescription"})
			.addNumberColumn({name:"setId", dataIndex:"setId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_attr_dc_AttributeSetAttribute$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"set", dataIndex:"set", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_attr_lovs_AttributeSet", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "setId"} 
						]}})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"attribute", dataIndex:"attribute", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_attr_lovs_Attribute", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "attributeId"} 
						]}})
			.addBooleanColumn({name:"inDescription", dataIndex:"inDescription"})
			.addNumberColumn({name:"setId", dataIndex:"setId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
