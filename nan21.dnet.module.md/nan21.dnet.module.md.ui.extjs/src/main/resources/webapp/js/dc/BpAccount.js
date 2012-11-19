/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccount", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.bp.ds.model.BpAccountDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.BpAccountDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.BpAccountDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_bp_dc_BpAccount$Filter",
	
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
			.addLov({xtype:"md_bp_lovs_VendorGroup", name:"vendorGroup", dataIndex:"vendorGroup", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "vendorGroupId"} 
				]})
			.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment", anchor:"-20", maxLength:32})
			.addTextField({ name:"custAnaliticSegment", dataIndex:"custAnaliticSegment", anchor:"-20", maxLength:32})
			.addTextField({ name:"vendAnaliticSegment", dataIndex:"vendAnaliticSegment", anchor:"-20", maxLength:32})
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
			.addChildrenTo("col2", ["customerGroup", "vendorGroup"])
			.addChildrenTo("col3", ["analiticSegment", "custAnaliticSegment", "vendAnaliticSegment"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccount$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_bp_dc_BpAccount$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"org", dataIndex:"org", width:100})
			.addTextColumn({ name:"businessPartnerCode", dataIndex:"businessPartnerCode", hidden:true, width:100})
			.addTextColumn({ name:"businessPartnerName", dataIndex:"businessPartnerName", width:200})
			.addTextColumn({ name:"analiticSegment", dataIndex:"analiticSegment", width:100})
			.addBooleanColumn({ name:"customer", dataIndex:"customer"})
			.addBooleanColumn({ name:"vendor", dataIndex:"vendor"})
			.addTextColumn({ name:"customerGroup", dataIndex:"customerGroup", width:100})
			.addTextColumn({ name:"customerPaymentMethod", dataIndex:"customerPaymentMethod", width:120})
			.addNumberColumn({ name:"customerCreditLimit", dataIndex:"customerCreditLimit", hidden:true, decimals:2})
			.addTextColumn({ name:"customerPaymentTerm", dataIndex:"customerPaymentTerm", width:120})
			.addTextColumn({ name:"custAnaliticSegment", dataIndex:"custAnaliticSegment", hidden:true, width:100})
			.addTextColumn({ name:"vendorGroup", dataIndex:"vendorGroup", width:100})
			.addTextColumn({ name:"vendorPaymentMethod", dataIndex:"vendorPaymentMethod", width:120})
			.addNumberColumn({ name:"vendorCreditLimit", dataIndex:"vendorCreditLimit", decimals:2})
			.addTextColumn({ name:"vendorPaymentTerm", dataIndex:"vendorPaymentTerm", width:120})
			.addTextColumn({ name:"vendAnaliticSegment", dataIndex:"vendAnaliticSegment", hidden:true, width:100})
			.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"businessPartnerId", dataIndex:"businessPartnerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerGroupId", dataIndex:"customerGroupId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"vendorGroupId", dataIndex:"vendorGroupId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerPaymentMethodId", dataIndex:"customerPaymentMethodId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"vendorPaymentMethodId", dataIndex:"vendorPaymentMethodId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccount$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_bp_dc_BpAccount$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addBooleanField({ name:"customer", dataIndex:"customer", anchor:"-20"})
			.addBooleanField({ name:"vendor", dataIndex:"vendor", anchor:"-20"})
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
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"customerPaymentMethod", dataIndex:"customerPaymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "customerPaymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"customerPaymentTerm", dataIndex:"customerPaymentTerm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "customerPaymentTermId"} 
				]})
			.addLov({xtype:"md_bp_lovs_VendorGroup", name:"vendorGroup", dataIndex:"vendorGroup", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "vendorGroupId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"vendorPaymentMethod", dataIndex:"vendorPaymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "vendorPaymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"vendorPaymentTerm", dataIndex:"vendorPaymentTerm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "vendorPaymentTermId"} 
				]})
			.addNumberField({name:"vendorCreditLimit", dataIndex:"vendorCreditLimit", anchor:"-20", decimals:2})
			.addNumberField({name:"customerCreditLimit", dataIndex:"customerCreditLimit", anchor:"-20", decimals:2})
			.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment", anchor:"-20", maxLength:32})
			.addTextField({ name:"custAnaliticSegment", dataIndex:"custAnaliticSegment", anchor:"-20", maxLength:32})
			.addTextField({ name:"vendAnaliticSegment", dataIndex:"vendAnaliticSegment", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", title:"Customer", width:350, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"right", labelWidth:180}})
			.addPanel({ name:"col3", title:"Vendor", width:350, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"right", labelWidth:180}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["org", "businessPartnerCode", "analiticSegment", "customer", "vendor"])
			.addChildrenTo("col2", ["customerGroup", "customerPaymentMethod", "customerCreditLimit", "customerPaymentTerm", "custAnaliticSegment"])
			.addChildrenTo("col3", ["vendorGroup", "vendorPaymentMethod", "vendorCreditLimit", "vendorPaymentTerm", "vendAnaliticSegment"])
		;
	}});


/* ================= EDITOR: EditCtx ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccount$EditCtx", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_bp_dc_BpAccount$EditCtx",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addBooleanField({ name:"customer", dataIndex:"customer", anchor:"-20"})
			.addBooleanField({ name:"vendor", dataIndex:"vendor", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"md_bp_lovs_CustomerGroup", name:"customerGroup", dataIndex:"customerGroup", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "customerGroupId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"customerPaymentMethod", dataIndex:"customerPaymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "customerPaymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"customerPaymentTerm", dataIndex:"customerPaymentTerm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "customerPaymentTermId"} 
				]})
			.addLov({xtype:"md_bp_lovs_VendorGroup", name:"vendorGroup", dataIndex:"vendorGroup", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "vendorGroupId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"vendorPaymentMethod", dataIndex:"vendorPaymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "vendorPaymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"vendorPaymentTerm", dataIndex:"vendorPaymentTerm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "vendorPaymentTermId"} 
				]})
			.addNumberField({name:"customerCreditLimit", dataIndex:"customerCreditLimit", anchor:"-20", decimals:2})
			.addNumberField({name:"vendorCreditLimit", dataIndex:"vendorCreditLimit", anchor:"-20", decimals:2})
			.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment", anchor:"-20", maxLength:32})
			.addTextField({ name:"custAnaliticSegment", dataIndex:"custAnaliticSegment", anchor:"-20", maxLength:32})
			.addTextField({ name:"vendAnaliticSegment", dataIndex:"vendAnaliticSegment", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", title:"Customer", width:350, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"right", labelWidth:180}})
			.addPanel({ name:"col3", title:"Vendor", width:350, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"right", labelWidth:180}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["org", "analiticSegment", "customer", "vendor"])
			.addChildrenTo("col2", ["customerGroup", "customerPaymentMethod", "customerCreditLimit", "customerPaymentTerm", "custAnaliticSegment"])
			.addChildrenTo("col3", ["vendorGroup", "vendorPaymentMethod", "vendorCreditLimit", "vendorPaymentTerm", "vendAnaliticSegment"])
		;
	}});
