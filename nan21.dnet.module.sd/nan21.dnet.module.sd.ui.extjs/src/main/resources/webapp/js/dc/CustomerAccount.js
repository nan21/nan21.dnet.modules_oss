/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccount", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.account.ds.model.CustomerAccountDs",
	filterModel: "net.nan21.dnet.module.sd.account.ds.model.CustomerAccountDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sd_account_dc_CustomerAccount$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_bp_lovs_BusinessPartnersCode", name:"businessPartnerCode", dataIndex:"businessPartnerCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "businessPartnerId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"md_bp_lovs_CustomerGroup", name:"customerGroup", dataIndex:"customerGroup", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "customerGroupId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"paymentTerm", dataIndex:"paymentTerm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentTermId"} 
				]})
			.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment", anchor:"-20", maxLength:32})
			.addTextField({ name:"custAnaliticSegment", dataIndex:"custAnaliticSegment", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:220, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
			.addPanel({ name:"col3", width:220, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["org", "businessPartnerCode"])
			.addChildrenTo("col2", ["customerGroup", "paymentMethod", "paymentTerm"])
			.addChildrenTo("col3", ["analiticSegment", "custAnaliticSegment"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccount$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_account_dc_CustomerAccount$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"org", dataIndex:"org", width:100})
			.addTextColumn({ name:"businessPartnerCode", dataIndex:"businessPartnerCode", width:100})
			.addTextColumn({ name:"businessPartnerName", dataIndex:"businessPartnerName", width:200})
			.addTextColumn({ name:"analiticSegment", dataIndex:"analiticSegment", width:100})
			.addTextColumn({ name:"customerGroup", dataIndex:"customerGroup", width:100})
			.addTextColumn({ name:"paymentMethod", dataIndex:"paymentMethod", width:120})
			.addNumberColumn({ name:"creditLimit", dataIndex:"creditLimit", hidden:true, decimals:2})
			.addTextColumn({ name:"paymentTerm", dataIndex:"paymentTerm", width:120})
			.addTextColumn({ name:"custAnaliticSegment", dataIndex:"custAnaliticSegment", hidden:true, width:100})
			.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"businessPartnerId", dataIndex:"businessPartnerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerGroupId", dataIndex:"customerGroupId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccount$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_account_dc_CustomerAccount$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"businessPartnerName", dataIndex:"businessPartnerName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "businessPartnerId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"md_bp_lovs_CustomerGroup", name:"customerGroup", dataIndex:"customerGroup", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "customerGroupId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"paymentTerm", dataIndex:"paymentTerm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentTermId"} 
				]})
			.addNumberField({name:"creditLimit", dataIndex:"creditLimit", anchor:"-20", decimals:2})
			.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment", anchor:"-20", maxLength:32})
			.addTextField({ name:"custAnaliticSegment", dataIndex:"custAnaliticSegment", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:280, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
			.addPanel({ name:"col3", width:220, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["org", "businessPartnerName"])
			.addChildrenTo("col2", ["customerGroup", "paymentMethod", "paymentTerm"])
			.addChildrenTo("col3", ["creditLimit", "analiticSegment", "custAnaliticSegment"])
		;
	}
});
