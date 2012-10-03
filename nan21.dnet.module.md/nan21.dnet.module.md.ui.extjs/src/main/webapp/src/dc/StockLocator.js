/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.org.dc.StockLocator", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.org.ds.model.StockLocatorDs",
	filterModel: "net.nan21.dnet.module.md.org.ds.model.StockLocatorDsFilter",
	paramModel: "net.nan21.dnet.module.md.org.ds.param.StockLocatorDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.StockLocator$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_org_dc_StockLocator$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextField({ name:"subInventory", dataIndex:"subInventory", anchor:"-20"})
			.addLov({xtype:"md_org_lovs_StockLocatorTypes", name:"locatorType", dataIndex:"locatorType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "locatorTypeId"} 
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
			.addChildrenTo("col1", ["name", "subInventory", "locatorType"])
			.addChildrenTo("col2", ["active"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.StockLocator$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_org_dc_StockLocator$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"locatorType", dataIndex:"locatorType", xtype:"gridcolumn", width:120,
					editor:{xtype:"md_org_lovs_StockLocatorTypes", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "locatorTypeId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"subInventoryId", dataIndex:"subInventoryId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"locatorTypeId", dataIndex:"locatorTypeId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
