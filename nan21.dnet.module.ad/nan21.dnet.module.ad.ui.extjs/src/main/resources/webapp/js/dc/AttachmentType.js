/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.data.dc.AttachmentType", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeDs",
	filterModel: "net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeDsFilter",
	paramModel: "net.nan21.dnet.module.ad.data.ds.param.AttachmentTypeDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.data.dc.AttachmentType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_data_dc_AttachmentType$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"category", dataIndex:"category", anchor:"-20",
				store:[ "image", "document"]
			})
			.addTextField({ name:"useInContext", dataIndex:"useInContext", anchor:"-20"})
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
			.addChildrenTo("col1", ["name", "active"])
			.addChildrenTo("col2", ["category", "useInContext"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.ad.data.dc.AttachmentType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_data_dc_AttachmentType$EditList",
	_bulkEditFields_: ["active","description","useInContext","category","uploadPath","baseUrl"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"useInContext", dataIndex:"useInContext", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addComboColumn({name:"category", dataIndex:"category", width:80,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "image", "document"]}})
			.addTextColumn({name:"uploadPath", dataIndex:"uploadPath", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"baseUrl", dataIndex:"baseUrl", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
