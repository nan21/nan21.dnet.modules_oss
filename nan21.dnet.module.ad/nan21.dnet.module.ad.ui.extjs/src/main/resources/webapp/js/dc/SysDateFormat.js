/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.system.dc.SysDateFormat", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDateFormatDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysDateFormat$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_system_dc_SysDateFormat$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["name", "active"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysDateFormat$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_system_dc_SysDateFormat$EditList",
	_bulkEditFields_: ["active","extjsDateFormat","extjsTimeFormat","extjsDateTimeFormat","extjsAltFormats","javaDateFormat","javaTimeFormat","javaDateTimeFormat"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addTextColumn({name:"extjsDateFormat", dataIndex:"extjsDateFormat", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"extjsTimeFormat", dataIndex:"extjsTimeFormat", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"extjsDateTimeFormat", dataIndex:"extjsDateTimeFormat", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"extjsAltFormats", dataIndex:"extjsAltFormats", width:150,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"javaDateFormat", dataIndex:"javaDateFormat", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"javaTimeFormat", dataIndex:"javaTimeFormat", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"javaDateTimeFormat", dataIndex:"javaDateTimeFormat", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});
