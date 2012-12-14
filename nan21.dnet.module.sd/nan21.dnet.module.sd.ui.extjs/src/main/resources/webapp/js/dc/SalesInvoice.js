/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDsParam",
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sd_invoice_dc_SalesInvoice$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
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
			.addLov({xtype:"md_mm_price_lovs_PriceListSales", name:"priceList", dataIndex:"priceList", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priceListId"} 
				]})
			.addBooleanField({ name:"confirmed", dataIndex:"confirmed", anchor:"-20"})
			.addBooleanField({ name:"posted", dataIndex:"posted", anchor:"-20"})
			.addTextField({ name:"salesOrderCode", dataIndex:"salesOrderCode", anchor:"-20", maxLength:32})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesSI", name:"docType", dataIndex:"docType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "docTypeId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethod", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"paymentTerm", dataIndex:"paymentTerm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentTermId"} 
				]})
			.addDateField({name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
			.addDateField({name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
			.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"})
				.addChildrenTo("docDate",["docDate_From", "docDate_To"])
			.addNumberField({name:"totalAmount_From", dataIndex:"totalAmount_From", emptyText:"From" })
			.addNumberField({name:"totalAmount_To", dataIndex:"totalAmount_To", emptyText:"To" })
			.addFieldContainer({name: "totalAmount", fieldLabel:"Total Amount"})
				.addChildrenTo("totalAmount",["totalAmount_From", "totalAmount_To"])
			.addNumberField({name:"totalNetAmount_From", dataIndex:"totalNetAmount_From", emptyText:"From" })
			.addNumberField({name:"totalNetAmount_To", dataIndex:"totalNetAmount_To", emptyText:"To" })
			.addFieldContainer({name: "totalNetAmount", fieldLabel:"Total Net Amount"})
				.addChildrenTo("totalNetAmount",["totalNetAmount_From", "totalNetAmount_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
			.addPanel({ name:"col3", width:200, layout:"form"})
			.addPanel({ name:"col4", width:300, layout:"form"})
			.addPanel({ name:"col5", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4", "col5"])
			.addChildrenTo("col1", ["supplier", "customer", "docType"])
			.addChildrenTo("col2", ["priceList", "paymentTerm", "salesOrderCode"])
			.addChildrenTo("col3", ["code", "docNo", "currency"])
			.addChildrenTo("col4", ["docDate", "totalAmount", "totalNetAmount"])
			.addChildrenTo("col5", ["confirmed", "posted"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_invoice_dc_SalesInvoice$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"supplierCode", dataIndex:"supplier", width:100})
			.addTextColumn({ name:"customerCode", dataIndex:"customerCode", hidden:true, width:100})
			.addTextColumn({ name:"customer", dataIndex:"customer", width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:60})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addBooleanColumn({ name:"posted", dataIndex:"posted"})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= EDITOR: CopyLinesForm ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$CopyLinesForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_invoice_dc_SalesInvoice$CopyLinesForm",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"sd_invoice_lovs_SalesInvoice", name:"copyFrom", paramIndex:"copyFrom", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "copyFromId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["copyFrom"])
		;
	}
});


/* ================= EDITOR: EditMain ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$EditMain", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_invoice_dc_SalesInvoice$EditMain",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addDateField({name:"docDate", dataIndex:"docDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesSI", name:"docType", dataIndex:"docType", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "docTypeId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"supplier", dataIndex:"supplier", noUpdate:true, allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
				]})
			.addLov({xtype:"md_bp_lovs_CustomersName", name:"customer", dataIndex:"customer", noUpdate:true, allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"bpartnerId", dsField: "customerId"} ,{lovField:"paymentMethod", dsField: "paymentMethod"} ,{lovField:"paymentMethodId", dsField: "paymentMethodId"} ,{lovField:"paymentTerm", dsField: "paymentTerm"} ,{lovField:"paymentTermId", dsField: "paymentTermId"} 
				],
				filterFieldMapping: [
					{lovField:"orgId",dsField: "supplierId"} 
				]})
			.addDisplayFieldText({ name:"currency", dataIndex:"currency", anchor:"-20", fieldCls:"displayfield important-field", maxLength:32})
			.addLov({xtype:"md_mm_price_lovs_PriceListSales", name:"priceList", dataIndex:"priceList", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priceListId"} ,{lovField:"currencyId", dsField: "currencyId"} ,{lovField:"currency", dsField: "currency"} 
				]})
			.addDisplayFieldNumber({ name:"totalNetAmount", dataIndex:"totalNetAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldNumber({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldNumber({ name:"totalAmount", dataIndex:"totalAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed", anchor:"-20" })
			.addDisplayFieldBoolean({ name:"posted", dataIndex:"posted", anchor:"-20" })
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
			.addPanel({ name:"col3", width:250, layout:"form"})
			.addPanel({ name:"col4", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["supplier", "customer", "docType", "priceList"])
			.addChildrenTo("col2", ["docDate", "docNo", "code", "currency"])
			.addChildrenTo("col3", ["totalNetAmount", "totalTaxAmount", "totalAmount"])
			.addChildrenTo("col4", ["confirmed", "posted"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_beforeApplyStates_: function(record) {
		if (record.get("confirmed") || record.get("posted") ) {
			this._disableAllFields_();
			return false;
		}
	},
	
	_endDefine_: function() {
		this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
		 	this._applyStates_(dc.record);
		 } , this )
	}

});


/* ================= EDITOR: EditDetails ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$EditDetails", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_invoice_dc_SalesInvoice$EditDetails",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20", height:60})
			.addDisplayFieldText({ name:"salesOrderCode", dataIndex:"salesOrderCode", width:170, maxLength:32})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethodIn", name:"paymentMethod", dataIndex:"paymentMethod", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"paymentTerm", dataIndex:"paymentTerm", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentTermId"} 
				]})
			.addLov({xtype:"bd_geo_lovs_LocationsToBill", name:"billToLocation", dataIndex:"billToLocation", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "billToLocationId"} 
				],
				filterFieldMapping: [
					{lovField:"targetUuid",dsField: "customerUuid"} 
				]})
			.addLov({xtype:"md_bp_lovs_BpContacts", name:"billToContact", dataIndex:"billToContact", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "billToContactId"} 
				],
				filterFieldMapping: [
					{lovField:"bpartnerId",dsField: "customerId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:400, layout:"form"})
			.addPanel({ name:"panelBillTo", title:"Others", width:350, layout:"form", xtype:"fieldset", border:true, collapsible:true})
			.addPanel({ name:"panelPayment", title:"Payment", width:350, layout:"form", xtype:"fieldset", border:true, collapsible:true})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["panelPayment", "panelBillTo"])
			.addChildrenTo("col2", ["salesOrderCode"])
			.addChildrenTo("col3", ["description"])
			.addChildrenTo("panelBillTo", ["billToLocation", "billToContact"])
			.addChildrenTo("panelPayment", ["paymentMethod", "paymentTerm"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_beforeApplyStates_: function(record) {
		if (record.get("confirmed") || record.get("posted") ) {
			this._disableAllFields_();
			return false;
		}
	},
	
	_endDefine_: function() {
		this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
		 	this._applyStates_(dc.record);
		 } , this )
	}

});
