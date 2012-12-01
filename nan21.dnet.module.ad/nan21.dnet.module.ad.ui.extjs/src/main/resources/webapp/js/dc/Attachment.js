/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.data.dc.Attachment", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.data.ds.model.AttachmentDs",
	filterModel: "net.nan21.dnet.module.ad.data.ds.model.AttachmentDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.data.dc.Attachment$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_data_dc_Attachment$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addLov({xtype:"ad_data_lovs_AttachmentTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addTextField({ name:"targetType", dataIndex:"targetType", anchor:"-20"})
			.addTextField({ name:"targetUuid", dataIndex:"targetUuid", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "type"])
			.addChildrenTo("col2", ["targetType", "targetUuid"])
		;
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_data_dc_Attachment$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_data_lovs_AttachmentTypes", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "typeId"} 
						],
						filterFieldMapping: [
							{lovField:"useInContext",dsField: "targetType"} 
						]}})
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"location", dataIndex:"location", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"targetType", dataIndex:"targetType", hidden:true, width:150,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"targetUuid", dataIndex:"targetUuid", hidden:true, width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.data.dc.Attachment$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_data_dc_Attachment$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"location", dataIndex:"location", width:200})
			.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
			.addTextColumn({ name:"targetType", dataIndex:"targetType", hidden:true, width:150})
			.addTextColumn({ name:"targetUuid", dataIndex:"targetUuid", hidden:true, width:100})
			.addDefaults();
	}
});
