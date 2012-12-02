/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_org_dc_OrganizationHierarchy$Filter",
	
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


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.bd_org_dc_OrganizationHierarchy$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:120})
			.addDateColumn({ name:"startDate", dataIndex:"startDate", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"endDate", dataIndex:"endDate", format: Dnet.DATE_FORMAT})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
			.addDefaults();
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_org_dc_OrganizationHierarchy$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"startDate", dataIndex:"startDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"endDate", dataIndex:"endDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.bd_org_dc_OrganizationHierarchy$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addDateField({name:"startDate", dataIndex:"startDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"endDate", dataIndex:"endDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "description"])
			.addChildrenTo("col2", ["startDate", "endDate", "active"])
		;
	}
});
