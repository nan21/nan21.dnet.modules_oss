/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.standards.dc.ClassificationCode", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.standards.ds.model.ClassificationItemDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.standards.dc.ClassificationCode$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_standards_dc_ClassificationCode$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextField({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addLov({xtype:"bd_standards_lovs_ClassificationSystems", name:"classSystem", dataIndex:"classSystem", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "classSystemId"} 
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
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["classSystem", "active"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.standards.dc.ClassificationCode$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_standards_dc_ClassificationCode$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"classSystem", dataIndex:"classSystem", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_standards_lovs_ClassificationSystems", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "classSystemId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"classSystemId", dataIndex:"classSystemId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
