/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDoc", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccDocDs",
	filterModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccDocDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDoc$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_acc_dc_AccDoc$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"md_acc_lovs_AccSchemas", name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "accSchemaId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypes", name:"docType", dataIndex:"docType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "docTypeId"} 
				]})
			.addLov({xtype:"md_base_period_lovs_FiscalPeriods", name:"period", dataIndex:"period", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "periodId"} 
				]})
			.addLov({xtype:"md_acc_lovs_AccJournals", name:"journal", dataIndex:"journal", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "journalId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"bpartner", dataIndex:"bpartner", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "bpartnerId"} 
				]})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addBooleanField({ name:"posted", dataIndex:"posted", anchor:"-20"})
			.addDateField({name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
			.addDateField({name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
			.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"})
				.addChildrenTo("docDate",["docDate_From", "docDate_To"])
			.addNumberField({name:"dbAmount_From", dataIndex:"dbAmount_From", emptyText:"From" })
			.addNumberField({name:"dbAmount_To", dataIndex:"dbAmount_To", emptyText:"To" })
			.addFieldContainer({name: "dbAmount", fieldLabel:"Db Amount"})
				.addChildrenTo("dbAmount",["dbAmount_From", "dbAmount_To"])
			.addNumberField({name:"crAmount_From", dataIndex:"crAmount_From", emptyText:"From" })
			.addNumberField({name:"crAmount_To", dataIndex:"crAmount_To", emptyText:"To" })
			.addFieldContainer({name: "crAmount", fieldLabel:"Cr Amount"})
				.addChildrenTo("crAmount",["crAmount_From", "crAmount_To"])
			.addNumberField({name:"docAmount_From", dataIndex:"docAmount_From", emptyText:"From" })
			.addNumberField({name:"docAmount_To", dataIndex:"docAmount_To", emptyText:"To" })
			.addFieldContainer({name: "docAmount", fieldLabel:"Doc Amount"})
				.addChildrenTo("docAmount",["docAmount_From", "docAmount_To"])
			.addNumberField({name:"difference_From", dataIndex:"difference_From", emptyText:"From" })
			.addNumberField({name:"difference_To", dataIndex:"difference_To", emptyText:"To" })
			.addFieldContainer({name: "difference", fieldLabel:"Difference"})
				.addChildrenTo("difference",["difference_From", "difference_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:290, layout:"form"})
			.addPanel({ name:"col4", width:290, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["org", "accSchema", "docNo", "posted"])
			.addChildrenTo("col2", ["period", "journal", "bpartner", "docType"])
			.addChildrenTo("col3", ["docDate", "docAmount"])
			.addChildrenTo("col4", ["dbAmount", "crAmount", "difference"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDoc$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_acc_dc_AccDoc$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"org", dataIndex:"org", hidden:true, width:100})
			.addTextColumn({ name:"accSchema", dataIndex:"accSchema", hidden:true, width:100})
			.addTextColumn({ name:"period", dataIndex:"period", hidden:true, width:100})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", width:80, format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addNumberColumn({ name:"docAmount", dataIndex:"docAmount", width:80, decimals:2})
			.addTextColumn({ name:"docCurrency", dataIndex:"docCurrency", width:80})
			.addTextColumn({ name:"bpartner", dataIndex:"bpartner", width:200})
			.addTextColumn({ name:"journal", dataIndex:"journal", width:120})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addBooleanColumn({ name:"posted", dataIndex:"posted", width:60})
			.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount", hidden:true, width:80, decimals:2})
			.addNumberColumn({ name:"crAmount", dataIndex:"crAmount", hidden:true, width:80, decimals:2})
			.addNumberColumn({ name:"difference", dataIndex:"difference", hidden:true, width:80, decimals:2})
			.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"bpartnerId", dataIndex:"bpartnerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"periodId", dataIndex:"periodId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
