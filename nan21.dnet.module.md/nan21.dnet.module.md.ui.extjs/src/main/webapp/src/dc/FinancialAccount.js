/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccount", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountDs",
	filterModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountDsFilter",
	paramModel: "net.nan21.dnet.module.md.org.ds.param.FinancialAccountDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_org_dc_FinancialAccount$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "bank", "cash"]
			})
			.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment", anchor:"-20", maxLength:32})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"md_acc_lovs_AccJournals", name:"journal", dataIndex:"journal", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "journalId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "type"])
			.addChildrenTo("col2", ["org", "journal"])
			.addChildrenTo("col3", ["currency", "analiticSegment", "active"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccount$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_org_dc_FinancialAccount$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:120})
			.addTextColumn({ name:"type", dataIndex:"type", width:60})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addTextColumn({ name:"org", dataIndex:"org", width:100})
			.addTextColumn({ name:"analiticSegment", dataIndex:"analiticSegment", width:100})
			.addTextColumn({ name:"journal", dataIndex:"journal", width:120})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:100})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccount$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_org_dc_FinancialAccount$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "bank", "cash"]
			})
			.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment", anchor:"-20", maxLength:32})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"md_acc_lovs_AccJournals", name:"journal", dataIndex:"journal", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "journalId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "description"])
			.addChildrenTo("col2", ["org", "type", "currency", "journal"])
			.addChildrenTo("col3", ["analiticSegment", "active"])
		;
	}});
