/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmountOverview", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountOverviewDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountOverviewDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.SalesTxAmountOverviewDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmountOverview$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sd_invoice_dc_SalesTxAmountOverview$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"supplier", dataIndex:"supplier", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"customer", dataIndex:"customer", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "customerId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			.addDateField({name:"dueDate_From", dataIndex:"dueDate_From", emptyText:"From" })
			.addDateField({name:"dueDate_To", dataIndex:"dueDate_To", emptyText:"To" })
			.addFieldContainer({name: "dueDate", fieldLabel:"Due Date"})
				.addChildrenTo("dueDate",["dueDate_From", "dueDate_To"])
			.addNumberField({name:"outstandingAmount_From", dataIndex:"outstandingAmount_From", emptyText:"From" })
			.addNumberField({name:"outstandingAmount_To", dataIndex:"outstandingAmount_To", emptyText:"To" })
			.addFieldContainer({name: "outstandingAmount", fieldLabel:"Outstanding Amount"})
				.addChildrenTo("outstandingAmount",["outstandingAmount_From", "outstandingAmount_To"])
			.addNumberField({name:"payedAmount_From", dataIndex:"payedAmount_From", emptyText:"From" })
			.addNumberField({name:"payedAmount_To", dataIndex:"payedAmount_To", emptyText:"To" })
			.addFieldContainer({name: "payedAmount", fieldLabel:"Payed Amount"})
				.addChildrenTo("payedAmount",["payedAmount_From", "payedAmount_To"])
			.addNumberField({name:"dueAmount_From", dataIndex:"dueAmount_From", emptyText:"From" })
			.addNumberField({name:"dueAmount_To", dataIndex:"dueAmount_To", emptyText:"To" })
			.addFieldContainer({name: "dueAmount", fieldLabel:"Due Amount"})
				.addChildrenTo("dueAmount",["dueAmount_From", "dueAmount_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:300, layout:"form", defaults:{labelAlign:"right", labelWidth:100}})
			.addPanel({ name:"col3", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["supplier", "customer", "currency"])
			.addChildrenTo("col2", ["dueAmount", "payedAmount", "outstandingAmount"])
			.addChildrenTo("col3", ["paymentMethod", "dueDate"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmountOverview$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_invoice_dc_SalesTxAmountOverview$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"supplier", dataIndex:"supplier", width:80})
			.addTextColumn({ name:"customer", dataIndex:"customer", width:200})
			.addDateColumn({ name:"dueDate", dataIndex:"dueDate", format: Dnet.DATE_FORMAT})
			.addNumberColumn({ name:"dueInDays", dataIndex:"dueInDays", width:60})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:60})
			.addNumberColumn({ name:"dueAmount", dataIndex:"dueAmount", decimals:2})
			.addNumberColumn({ name:"payedAmount", dataIndex:"payedAmount", decimals:2})
			.addNumberColumn({ name:"outstandingAmount", dataIndex:"outstandingAmount", decimals:2})
			.addTextColumn({ name:"invoiceCode", dataIndex:"invoiceCode", width:80})
			.addDateColumn({ name:"invoiceDocDate", dataIndex:"invoiceDocDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"invoiceDocNo", dataIndex:"invoiceDocNo", width:80})
			.addTextColumn({ name:"paymentMethod", dataIndex:"paymentMethod", width:120})
			.addNumberColumn({ name:"invoiceId", dataIndex:"invoiceId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"orderId", dataIndex:"orderId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
