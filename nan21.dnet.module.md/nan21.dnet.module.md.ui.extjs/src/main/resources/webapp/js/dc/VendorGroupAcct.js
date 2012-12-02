/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.dc.VendorGroupAcct", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.bp.ds.model.VendorGroupAcctDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.VendorGroupAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_bp_dc_VendorGroupAcct$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_acc_lovs_AccSchemas", name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "accSchemaId"} 
				]})
			.addTextField({ name:"vendorGroup", dataIndex:"vendorGroup", anchor:"-20", maxLength:32})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"purchaseAccount", dataIndex:"purchaseAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "purchaseAccountId"} 
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
			.addChildrenTo("col1", ["vendorGroup", "accSchema"])
			.addChildrenTo("col2", ["purchaseAccount", "prepayAccount"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.VendorGroupAcct$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_bp_dc_VendorGroupAcct$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_AccSchemas", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accSchemaId"} 
						]}})
			.addTextColumn({name:"vendorGroup", dataIndex:"vendorGroup", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"purchaseAccount", dataIndex:"purchaseAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "purchaseAccountId"} ,{lovField:"name", dsField: "purchaseAccountName"} 
						]}})
			.addTextColumn({name:"purchaseAccountName", dataIndex:"purchaseAccountName", width:200})
			.addLov({name:"prepayAccount", dataIndex:"prepayAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "prepayAccountId"} ,{lovField:"name", dsField: "prepayAccountName"} 
						]}})
			.addTextColumn({name:"prepayAccountName", dataIndex:"prepayAccountName", width:200})
			.addNumberColumn({name:"vendorGroupId", dataIndex:"vendorGroupId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"purchaseAccountId", dataIndex:"purchaseAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"prepayAccountId", dataIndex:"prepayAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.VendorGroupAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_bp_dc_VendorGroupAcct$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_AccSchemas", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accSchemaId"} 
						]}})
			.addLov({name:"purchaseAccount", dataIndex:"purchaseAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "purchaseAccountId"} ,{lovField:"name", dsField: "purchaseAccountName"} 
						]}})
			.addTextColumn({name:"purchaseAccountName", dataIndex:"purchaseAccountName", width:200})
			.addLov({name:"prepayAccount", dataIndex:"prepayAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "prepayAccountId"} ,{lovField:"name", dsField: "prepayAccountName"} 
						]}})
			.addTextColumn({name:"prepayAccountName", dataIndex:"prepayAccountName", width:200})
			.addNumberColumn({name:"vendorGroupId", dataIndex:"vendorGroupId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"purchaseAccountId", dataIndex:"purchaseAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"prepayAccountId", dataIndex:"prepayAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
