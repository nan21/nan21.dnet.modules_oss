/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccOperation", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccOperationDsFilter",
	recordModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccOperationDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccOperation$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_acc_dc_AccOperation$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"dbAccount", dataIndex:"dbAccount", anchor:"-20"})
			.addTextField({ name:"crAccount", dataIndex:"crAccount", anchor:"-20"})
			.addDateField({name:"eventDate_From", dataIndex:"eventDate_From", emptyText:"From" })
			.addDateField({name:"eventDate_To", dataIndex:"eventDate_To", emptyText:"To" })
			.addFieldContainer({name: "eventDate", fieldLabel:"Event Date"})
				.addChildrenTo("eventDate",["eventDate_From", "eventDate_To"])
			.addNumberField({name:"dbAmount_From", dataIndex:"dbAmount_From", emptyText:"From" })
			.addNumberField({name:"dbAmount_To", dataIndex:"dbAmount_To", emptyText:"To" })
			.addFieldContainer({name: "dbAmount", fieldLabel:"Db Amount"})
				.addChildrenTo("dbAmount",["dbAmount_From", "dbAmount_To"])
			.addNumberField({name:"crAmount_From", dataIndex:"crAmount_From", emptyText:"From" })
			.addNumberField({name:"crAmount_To", dataIndex:"crAmount_To", emptyText:"To" })
			.addFieldContainer({name: "crAmount", fieldLabel:"Cr Amount"})
				.addChildrenTo("crAmount",["crAmount_From", "crAmount_To"])
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
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"bpartner", dataIndex:"bpartner", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "bpartnerId"} 
				]})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:290, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["org", "accSchema", "period", "bpartner"])
			.addChildrenTo("col2", ["docNo", "dbAccount", "crAccount"])
			.addChildrenTo("col3", ["eventDate", "dbAmount", "crAmount"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccOperation$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_acc_dc_AccOperation$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"org", dataIndex:"org", width:80})
			.addTextColumn({ name:"accSchema", dataIndex:"accSchema", width:80})
			.addTextColumn({ name:"period", dataIndex:"period", width:100})
			.addTextColumn({ name:"bpartner", dataIndex:"bpartner", width:200})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"eventDate", dataIndex:"eventDate", width:80, format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"dbAccount", dataIndex:"dbAccount", width:80})
			.addTextColumn({ name:"crAccount", dataIndex:"crAccount", width:80})
			.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount", width:80, decimals:2})
			.addNumberColumn({ name:"crAmount", dataIndex:"crAmount", width:80, decimals:2})
			.addDefaults();
	}
});
