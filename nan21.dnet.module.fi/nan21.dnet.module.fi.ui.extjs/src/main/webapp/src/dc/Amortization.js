/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.fi.asset.dc.Amortization", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.fi.asset.ds.model.AmortizationDs",
	filterModel: "net.nan21.dnet.module.fi.asset.ds.model.AmortizationDsFilter",
	paramModel: "net.nan21.dnet.module.fi.asset.ds.param.AmortizationDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.fi.asset.dc.Amortization$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.fi_asset_dc_Amortization$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addCombo({ xtype:"combo", name:"periodType", dataIndex:"periodType", anchor:"-20",
				store:[ "month", "year"]
			})
			.addLov({xtype:"fi_asset_lovs_AssetCategories", name:"assetCategory", dataIndex:"assetCategory", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "assetCategoryId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addDateField({name:"postingDate_From", dataIndex:"postingDate_From", emptyText:"From" })
			.addDateField({name:"postingDate_To", dataIndex:"postingDate_To", emptyText:"To" })
			.addFieldContainer({name: "postingDate", fieldLabel:"Posting Date"})
				.addChildrenTo("postingDate",["postingDate_From", "postingDate_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["org", "currency", "periodType"])
			.addChildrenTo("col2", ["assetCategory", "postingDate"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.fi.asset.dc.Amortization$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.fi_asset_dc_Amortization$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"org", dataIndex:"org", width:100})
			.addTextColumn({ name:"asset", dataIndex:"asset", width:100})
			.addTextColumn({ name:"assetName", dataIndex:"assetName", width:200})
			.addTextColumn({ name:"periodType", dataIndex:"periodType", width:60})
			.addDateColumn({ name:"postingDate", dataIndex:"postingDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:100})
			.addNumberColumn({ name:"percentage", dataIndex:"percentage", decimals:2})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addNumberColumn({ name:"assetId", dataIndex:"assetId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: EditListCtxAsset ================= */


Ext.define("net.nan21.dnet.module.fi.asset.dc.Amortization$EditListCtxAsset", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.fi_asset_dc_Amortization$EditListCtxAsset",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addDateColumn({name:"postingDate", dataIndex:"postingDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addNumberColumn({name:"percentage", dataIndex:"percentage", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"amount", dataIndex:"amount", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addTextColumn({name:"currency", dataIndex:"currency", width:100})
			.addNumberColumn({name:"assetId", dataIndex:"assetId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"currencyId", dataIndex:"currencyId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"orgId", dataIndex:"orgId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addDefaults();
	}});
