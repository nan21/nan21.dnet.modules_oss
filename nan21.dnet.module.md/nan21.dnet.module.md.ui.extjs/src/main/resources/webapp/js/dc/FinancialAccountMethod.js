/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountMethod", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountMethodDs",
	filterModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountMethodDsFilter",
	paramModel: "net.nan21.dnet.module.md.org.ds.param.FinancialAccountMethodDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountMethod$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_org_dc_FinancialAccountMethod$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"financialAccount", dataIndex:"financialAccount", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"payMethod", dataIndex:"payMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "payMethodId"} 
				]})
			.addBooleanField({ name:"allowPayIn", dataIndex:"allowPayIn", anchor:"-20"})
			.addBooleanField({ name:"allowPayOut", dataIndex:"allowPayOut", anchor:"-20"})
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
			.addChildrenTo("col1", ["financialAccount", "payMethod"])
			.addChildrenTo("col2", ["allowPayIn", "allowPayOut"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountMethod$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_org_dc_FinancialAccountMethod$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"financialAccount", dataIndex:"financialAccount", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"payMethod", dataIndex:"payMethod", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_base_tx_lovs_PaymentMethod", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "payMethodId"} 
						]}})
			.addBooleanColumn({name:"allowPayIn", dataIndex:"allowPayIn"})
			.addBooleanColumn({name:"allowPayOut", dataIndex:"allowPayOut"})
			.addNumberColumn({name:"financialAccountId", dataIndex:"financialAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"payMethodId", dataIndex:"payMethodId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountMethod$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_org_dc_FinancialAccountMethod$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"payMethod", dataIndex:"payMethod", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_base_tx_lovs_PaymentMethod", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "payMethodId"} 
						],
						filterFieldMapping: [
							{lovField:"type",dsField: "financialAccountType"} 
						]}})
			.addBooleanColumn({name:"allowPayIn", dataIndex:"allowPayIn"})
			.addBooleanColumn({name:"allowPayOut", dataIndex:"allowPayOut"})
			.addNumberColumn({name:"financialAccountId", dataIndex:"financialAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"payMethodId", dataIndex:"payMethodId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
