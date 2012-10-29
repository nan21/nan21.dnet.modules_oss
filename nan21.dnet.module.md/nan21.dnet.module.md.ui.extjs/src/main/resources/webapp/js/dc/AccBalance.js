/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccBalance", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccBalanceDs",
	filterModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccBalanceDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.acc.ds.param.AccBalanceDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccBalance$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_acc_dc_AccBalance$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"account", dataIndex:"account", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"md_acc_lovs_AccSchemas", name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "accSchemaId"} 
				]})
			.addLov({xtype:"md_base_period_lovs_FiscalPeriods", name:"period", dataIndex:"period", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "periodId"} 
				]})
			.addNumberField({name:"initialAmount_From", dataIndex:"initialAmount_From", emptyText:"From" })
			.addNumberField({name:"initialAmount_To", dataIndex:"initialAmount_To", emptyText:"To" })
			.addFieldContainer({name: "initialAmount", fieldLabel:"Initial Amount"})
				.addChildrenTo("initialAmount",["initialAmount_From", "initialAmount_To"])
			.addNumberField({name:"amount_From", dataIndex:"amount_From", emptyText:"From" })
			.addNumberField({name:"amount_To", dataIndex:"amount_To", emptyText:"To" })
			.addFieldContainer({name: "amount", fieldLabel:"Amount"})
				.addChildrenTo("amount",["amount_From", "amount_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["org", "accSchema", "period"])
			.addChildrenTo("col2", ["account"])
			.addChildrenTo("col3", ["initialAmount", "amount"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccBalance$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_acc_dc_AccBalance$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"org", dataIndex:"org", width:80})
			.addTextColumn({ name:"accSchema", dataIndex:"accSchema", width:80})
			.addTextColumn({ name:"period", dataIndex:"period", width:100})
			.addTextColumn({ name:"account", dataIndex:"account", width:200})
			.addNumberColumn({ name:"initialAmount", dataIndex:"initialAmount", decimals:2})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addDefaults();
	}});
