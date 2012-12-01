/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.geo.dc.Country", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.CountryDs",
	filterModel: "net.nan21.dnet.module.bd.geo.ds.model.CountryDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_geo_dc_Country$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"iso2", dataIndex:"iso2", anchor:"-20", maxLength:2, caseRestriction:"uppercase"})
			.addTextField({ name:"iso3", dataIndex:"iso3", anchor:"-20", maxLength:3, caseRestriction:"uppercase"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:220, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["iso2", "iso3"])
			.addChildrenTo("col3", ["active"])
		;
	}
});


/* ================= FILTER: FilterPG ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$FilterPG", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.bd_geo_dc_Country$FilterPG",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"iso2", dataIndex:"iso2", anchor:"-20", maxLength:2, caseRestriction:"uppercase"})
			.addTextField({ name:"iso3", dataIndex:"iso3", anchor:"-20", maxLength:3, caseRestriction:"uppercase"})
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.bd_geo_dc_Country$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"iso2", dataIndex:"iso2", width:50})
			.addTextColumn({ name:"iso3", dataIndex:"iso3", width:50})
			.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
			.addBooleanColumn({ name:"hasRegions", dataIndex:"hasRegions"})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addDefaults();
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_geo_dc_Country$EditList",
	_bulkEditFields_: ["active","notes"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"iso2", dataIndex:"iso2", width:50,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"iso3", dataIndex:"iso3", width:50,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"hasRegions", dataIndex:"hasRegions"})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.bd_geo_dc_Country$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", allowBlank:false, anchor:"-20", maxLength:32})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"hasRegions", dataIndex:"hasRegions", anchor:"-20"})
			.addTextField({ name:"iso2", dataIndex:"iso2", anchor:"-20", maxLength:2, caseRestriction:"uppercase"})
			.addTextField({ name:"iso3", dataIndex:"iso3", anchor:"-20", maxLength:3, caseRestriction:"uppercase"})
			.addDateField({name:"createdAt", _sharedLabel_:true, dataIndex:"createdAt", disabled:true , anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"modifiedAt", _sharedLabel_:true, dataIndex:"modifiedAt", disabled:true , anchor:"-20", format:Ext.DATE_FORMAT})
			.addTextField({ name:"createdBy", _sharedLabel_:true, dataIndex:"createdBy", disabled:true , anchor:"-20", maxLength:32})
			.addTextField({ name:"modifiedBy", _sharedLabel_:true, dataIndex:"modifiedBy", disabled:true , anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:350, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "code", "notes"])
			.addChildrenTo("col2", ["iso2", "iso3", "active", "hasRegions"])
		;
	}
});


/* ================= EDITOR: EditPG ================= */


Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$EditPG", {
	extend: "dnet.core.dc.AbstractDcvEditPropGrid",
	alias: "widget.bd_geo_dc_Country$EditPG",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addNumberField({name:"id", _sharedLabel_:true, dataIndex:"id", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", allowBlank:false, anchor:"-20", maxLength:32})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"hasRegions", dataIndex:"hasRegions", anchor:"-20"})
			.addTextField({ name:"iso2", dataIndex:"iso2", anchor:"-20", maxLength:2, caseRestriction:"uppercase"})
			.addTextField({ name:"iso3", dataIndex:"iso3", anchor:"-20", maxLength:3, caseRestriction:"uppercase"})
			.addDateField({name:"createdAt", _sharedLabel_:true, dataIndex:"createdAt", disabled:true , anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"modifiedAt", _sharedLabel_:true, dataIndex:"modifiedAt", disabled:true , anchor:"-20", format:Ext.DATE_FORMAT})
			.addTextField({ name:"createdBy", _sharedLabel_:true, dataIndex:"createdBy", disabled:true , anchor:"-20", maxLength:32})
			.addTextField({ name:"modifiedBy", _sharedLabel_:true, dataIndex:"modifiedBy", disabled:true , anchor:"-20", maxLength:32})
		;
	}
});
