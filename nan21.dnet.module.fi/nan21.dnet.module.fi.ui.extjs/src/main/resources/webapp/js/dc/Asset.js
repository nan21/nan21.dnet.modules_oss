/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetDs",
	filterModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetDsFilter",
	paramModel: "net.nan21.dnet.module.fi.asset.ds.param.AssetDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.fi_asset_dc_Asset$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"fi_asset_lovs_AssetCategories", name:"category", dataIndex:"category", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "categoryId"} 
				]})
			.addLov({xtype:"md_mm_prod_lovs_Products", name:"productCode", dataIndex:"productCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "productId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["org", "category", "productCode"])
			.addChildrenTo("col3", ["active"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.fi_asset_dc_Asset$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"org", dataIndex:"org", width:100})
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"category", dataIndex:"category", width:100})
			.addTextColumn({ name:"productCode", dataIndex:"productCode", width:100})
			.addTextColumn({ name:"productName", dataIndex:"productName", hidden:true, width:200})
			.addTextColumn({ name:"method", dataIndex:"method", hidden:true, width:60})
			.addTextColumn({ name:"calculation", dataIndex:"calculation", hidden:true, width:60})
			.addTextColumn({ name:"periodType", dataIndex:"periodType", width:60})
			.addNumberColumn({ name:"periodValue", dataIndex:"periodValue"})
			.addNumberColumn({ name:"periodPercenatge", dataIndex:"periodPercenatge"})
			.addNumberColumn({ name:"initialValue", dataIndex:"initialValue", decimals:2})
			.addNumberColumn({ name:"residualValue", dataIndex:"residualValue", decimals:2})
			.addNumberColumn({ name:"depreciationAmount", dataIndex:"depreciationAmount", decimals:2})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
			.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"categoryId", dataIndex:"categoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.fi_asset_dc_Asset$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"fi_asset_lovs_AssetCategories", name:"category", dataIndex:"category", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "categoryId"} 
				]})
			.addLov({xtype:"md_mm_prod_lovs_Products", name:"productCode", dataIndex:"productCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} 
				]})
			.addDisplayFieldText({ name:"productName", dataIndex:"productName", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:300, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form", defaults:{labelAlign:"top", labelWidth:70}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code", "org"])
			.addChildrenTo("col2", ["category", "productCode", "productName"])
			.addChildrenTo("col3", ["notes"])
		;
	}});


/* ================= EDITOR: EditDeprec ================= */


Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$EditDeprec", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.fi_asset_dc_Asset$EditDeprec",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addBooleanField({ name:"withDepreciation", dataIndex:"withDepreciation", anchor:"-20",listeners:{
				change:{scope:this, fn:this.onWithDepreciationChange}
			}
			})
			.addCombo({ xtype:"combo", name:"method", dataIndex:"method", anchor:"-20",
				store:[ "linear"]
			})
			.addCombo({ xtype:"combo", name:"calculation", dataIndex:"calculation", anchor:"-20",
				store:[ "percentage", "time"]
			,listeners:{
				change:{scope:this, fn:this.onCalculationChange}
			}
			})
			.addCombo({ xtype:"combo", name:"periodType", dataIndex:"periodType", anchor:"-20",
				store:[ "month", "year"]
			})
			.addNumberField({name:"periodValue", dataIndex:"periodValue", anchor:"-20"})
			.addNumberField({name:"periodPercenatge", dataIndex:"periodPercenatge", anchor:"-20"})
			.addDateField({name:"purchaseDate", dataIndex:"purchaseDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"deprecStartDate", dataIndex:"deprecStartDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDisplayFieldDate({ name:"deprecEndDate", dataIndex:"deprecEndDate", anchor:"-20" })
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addNumberField({name:"initialValue", dataIndex:"initialValue", anchor:"-20"})
			.addNumberField({name:"residualValue", dataIndex:"residualValue", anchor:"-20"})
			.addDisplayFieldNumber({ name:"depreciationAmount", dataIndex:"depreciationAmount", anchor:"-20" })
			.addNumberField({name:"initialDeprecAmount", dataIndex:"initialDeprecAmount", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["withDepreciation", "purchaseDate", "deprecStartDate", "deprecEndDate"])
			.addChildrenTo("col2", ["method", "calculation", "periodType", "periodValue", "periodPercenatge"])
			.addChildrenTo("col3", ["currency", "initialValue", "residualValue", "initialDeprecAmount", "depreciationAmount"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	onWithDepreciationChange: function() {
		var r = this._getController_().getRecord();		 
					if ( ! r.get("withDepreciation") ) {
						this._disableAllFields_();
						this._getElement_("withDepreciation").enable();				 
					} else {
						this._enableAllFields_();
						this._setFieldsEnabledState_(["periodPercenatge","periodValue" ], r);
					}
				;
	},
	
	_beforeApplyStates_: function(r) {
		
					if ( ! r.get("withDepreciation") ) {
						this._disableAllFields_();
						this._getElement_("withDepreciation").enable();
						return false;
					};
	},
	
	onCalculationChange: function() {
		var r = this._getController_().getRecord();		 
				this._setFieldsEnabledState_(["periodPercenatge","periodValue" ], r);;
	}
});
