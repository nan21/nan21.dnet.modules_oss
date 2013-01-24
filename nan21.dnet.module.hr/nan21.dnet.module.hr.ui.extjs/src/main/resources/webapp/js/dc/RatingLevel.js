/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.skill.dc.RatingLevel", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.RatingLevelDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.RatingLevel$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_skill_dc_RatingLevel$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"hr_skill_lovs_RatingScales", name:"ratingScale", dataIndex:"ratingScale", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "ratingScaleId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "ratingScale"])
			.addChildrenTo("col2", ["active"])
		;
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.RatingLevel$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_skill_dc_RatingLevel$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"value", dataIndex:"value", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"ratingScaleId", dataIndex:"ratingScaleId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.RatingLevel$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_skill_dc_RatingLevel$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"value", dataIndex:"value", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"ratingScale", dataIndex:"ratingScale", xtype:"gridcolumn", width:150,
					editor:{xtype:"hr_skill_lovs_RatingScales", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "ratingScaleId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"ratingScaleId", dataIndex:"ratingScaleId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
