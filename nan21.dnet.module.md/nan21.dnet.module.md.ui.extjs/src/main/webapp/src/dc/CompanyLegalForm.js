/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.dc.CompanyLegalForm", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.bp.ds.model.CompanyLegalFormDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.CompanyLegalFormDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.CompanyLegalFormDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.CompanyLegalForm$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_bp_dc_CompanyLegalForm$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"bd_geo_lovs_Countries", name:"country", dataIndex:"country", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "countryId"} 
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
			.addChildrenTo("col1", ["name", "country"])
			.addChildrenTo("col2", ["active"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.CompanyLegalForm$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_bp_dc_CompanyLegalForm$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"country", dataIndex:"country", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_geo_lovs_Countries", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "countryId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"countryId", dataIndex:"countryId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
