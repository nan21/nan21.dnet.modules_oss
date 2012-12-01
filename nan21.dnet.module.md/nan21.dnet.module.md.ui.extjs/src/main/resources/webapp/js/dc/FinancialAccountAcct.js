/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountAcct", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountAcctDs",
	filterModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountAcctDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_org_dc_FinancialAccountAcct$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"financialAccount", dataIndex:"financialAccount", anchor:"-20"})
			.addLov({xtype:"md_acc_lovs_AccSchemas", name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "accSchemaId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"depositAccount", dataIndex:"depositAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "depositAccountId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"withdrawalAccount", dataIndex:"withdrawalAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "withdrawalAccountId"} 
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
			.addChildrenTo("col1", ["financialAccount", "accSchema"])
			.addChildrenTo("col2", ["depositAccount", "withdrawalAccount"])
		;
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_org_dc_FinancialAccountAcct$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_AccSchemas", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accSchemaId"} 
						]}})
			.addLov({name:"depositAccount", dataIndex:"depositAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "depositAccountId"} ,{lovField:"name", dsField: "depositAccountName"} 
						]}})
			.addTextColumn({name:"depositAccountName", dataIndex:"depositAccountName", width:200})
			.addLov({name:"withdrawalAccount", dataIndex:"withdrawalAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "withdrawalAccountId"} ,{lovField:"name", dsField: "withdrawalAccountName"} 
						]}})
			.addTextColumn({name:"withdrawalAccountName", dataIndex:"withdrawalAccountName", width:200})
			.addNumberColumn({name:"financialAccountId", dataIndex:"financialAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"depositAccountId", dataIndex:"depositAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"withdrawalAccountId", dataIndex:"withdrawalAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
