/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.base.tax.dc.TaxAcct", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.base.tax.ds.model.TaxAcctDs",
	filterModel: "net.nan21.dnet.module.md.base.tax.ds.model.TaxAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.base.tax.ds.param.TaxAcctDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.base.tax.dc.TaxAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_base_tax_dc_TaxAcct$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_base_tax_lovs_Taxes", name:"tax", dataIndex:"tax", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "taxId"} 
				]})
			.addLov({xtype:"md_acc_lovs_AccSchemas", name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "accSchemaId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"salesAccount", dataIndex:"salesAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "salesAccountId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"purchaseAccount", dataIndex:"purchaseAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "purchaseAccountId"} 
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
			.addChildrenTo("col1", ["tax", "accSchema"])
			.addChildrenTo("col2", ["salesAccount", "purchaseAccount"])
		;
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.base.tax.dc.TaxAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_base_tax_dc_TaxAcct$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_acc_lovs_AccSchemas", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accSchemaId"} 
						]}})
			.addLov({name:"salesAccount", dataIndex:"salesAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "salesAccountId"} ,{lovField:"name", dsField: "salesAccountName"} 
						]}})
			.addTextColumn({name:"salesAccountName", dataIndex:"salesAccountName", width:200})
			.addLov({name:"purchaseAccount", dataIndex:"purchaseAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "purchaseAccountId"} ,{lovField:"name", dsField: "purchaseAccountName"} 
						]}})
			.addTextColumn({name:"purchaseAccountName", dataIndex:"purchaseAccountName", width:200})
			.addLov({name:"nonDeductAccount", dataIndex:"nonDeductAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "nonDeductAccountId"} ,{lovField:"name", dsField: "nonDeductAccountName"} 
						]}})
			.addTextColumn({name:"nonDeductAccountName", dataIndex:"nonDeductAccountName", width:200})
			.addNumberColumn({name:"taxId", dataIndex:"taxId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"salesAccountId", dataIndex:"salesAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"purchaseAccountId", dataIndex:"purchaseAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
