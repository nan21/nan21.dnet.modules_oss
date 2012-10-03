/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.bp.ds.model.CustomerGroupAcctDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.CustomerGroupAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.CustomerGroupAcctDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_bp_dc_CustomerGroupAcct$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_acc_lovs_AccSchemas", name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "accSchemaId"} 
				]})
			.addTextField({ name:"custGroup", dataIndex:"custGroup", anchor:"-20", maxLength:32})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"salesAccount", dataIndex:"salesAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "salesAccountId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"prepayAccount", dataIndex:"prepayAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "prepayAccountId"} 
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
			.addChildrenTo("col2", ["custGroup", "accSchema", "salesAccount", "prepayAccount"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_bp_dc_CustomerGroupAcct$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_AccSchemas", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accSchemaId"} 
						]}})
			.addTextColumn({name:"custGroup", dataIndex:"custGroup", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"salesAccount", dataIndex:"salesAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "salesAccountId"} ,{lovField:"name", dsField: "salesAccountName"} 
						]}})
			.addTextColumn({name:"salesAccountName", dataIndex:"salesAccountName", width:200})
			.addLov({name:"prepayAccount", dataIndex:"prepayAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "prepayAccountId"} ,{lovField:"name", dsField: "prepayAccountName"} 
						]}})
			.addTextColumn({name:"prepayAccountName", dataIndex:"prepayAccountName", width:200})
			.addNumberColumn({name:"custGroupId", dataIndex:"custGroupId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"salesAccountId", dataIndex:"salesAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"prepayAccountId", dataIndex:"prepayAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_bp_dc_CustomerGroupAcct$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:100,
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
			.addLov({name:"prepayAccount", dataIndex:"prepayAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "prepayAccountId"} ,{lovField:"name", dsField: "prepayAccountName"} 
						]}})
			.addTextColumn({name:"prepayAccountName", dataIndex:"prepayAccountName", width:200})
			.addNumberColumn({name:"custGroupId", dataIndex:"custGroupId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"salesAccountId", dataIndex:"salesAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"prepayAccountId", dataIndex:"prepayAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
