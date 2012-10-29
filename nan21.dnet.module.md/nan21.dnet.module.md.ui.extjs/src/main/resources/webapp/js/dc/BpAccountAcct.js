/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccountAcct", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.bp.ds.model.BpAccountAcctDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.BpAccountAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.BpAccountAcctDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccountAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_bp_dc_BpAccountAcct$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_acc_lovs_AccSchemas", name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "accSchemaId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"custSalesAccount", dataIndex:"custSalesAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "custSalesAccountId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"custPrepayAccount", dataIndex:"custPrepayAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "custPrepayAccountId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"vendorPurchaseAccount", dataIndex:"vendorPurchaseAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "vendorPurchaseAccountId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"vendorPrepayAccount", dataIndex:"vendorPrepayAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "vendorPrepayAccountId"} 
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
			.addChildrenTo("col1", ["accSchema"])
			.addChildrenTo("col2", ["custSalesAccount", "custPrepayAccount", "vendorPurchaseAccount", "vendorPrepayAccount"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccountAcct$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_bp_dc_BpAccountAcct$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_AccSchemas", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accSchemaId"} 
						]}})
			.addLov({name:"custSalesAccount", dataIndex:"custSalesAccount", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "custSalesAccountId"} 
						]}})
			.addLov({name:"custPrepayAccount", dataIndex:"custPrepayAccount", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "custPrepayAccountId"} 
						]}})
			.addLov({name:"vendorPurchaseAccount", dataIndex:"vendorPurchaseAccount", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "vendorPurchaseAccountId"} 
						]}})
			.addLov({name:"vendorPrepayAccount", dataIndex:"vendorPrepayAccount", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "vendorPrepayAccountId"} 
						]}})
			.addNumberColumn({name:"custPrepayAccountId", dataIndex:"custPrepayAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"bpAccountId", dataIndex:"bpAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"custSalesAccountId", dataIndex:"custSalesAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"vendorPurchaseAccountId", dataIndex:"vendorPurchaseAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"vendorPrepayAccountId", dataIndex:"vendorPrepayAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
