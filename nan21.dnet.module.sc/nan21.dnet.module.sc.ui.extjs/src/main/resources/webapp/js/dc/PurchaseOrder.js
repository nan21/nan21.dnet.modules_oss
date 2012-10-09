/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrder", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDs",
	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDsFilter",
	paramModel: "net.nan21.dnet.module.sc.order.ds.param.PurchaseOrderDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrder$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sc_order_dc_PurchaseOrder$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"supplier", dataIndex:"supplier", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"customer", dataIndex:"customer", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "customerId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_DeliveryMethods", name:"deliveryMethod", dataIndex:"deliveryMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "deliveryMethodId"} 
				]})
			.addLov({xtype:"md_mm_price_lovs_PriceListPurchase", name:"priceList", dataIndex:"priceList", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priceListId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addBooleanField({ name:"confirmed", dataIndex:"confirmed", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesPO", name:"docType", dataIndex:"docType", anchor:"-20",
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
			.addLov({xtype:"bd_org_lovs_WarehouseOrganizations", name:"warehouse", dataIndex:"inventory", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "inventoryId"} 
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
			.addPanel({ name:"col3", width:300, layout:"form"})
			.addPanel({ name:"col4", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["customer", "supplier", "warehouse", "docType", "deliveryMethod"])
			.addChildrenTo("col2", ["code", "priceList", "currency"])
			.addChildrenTo("col3", ["docDate", "totalAmount", "totalNetAmount"])
			.addChildrenTo("col4", ["confirmed"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrder$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_order_dc_PurchaseOrder$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"customer", dataIndex:"customer", width:100})
			.addTextColumn({ name:"inventory", dataIndex:"inventory", hidden:true, width:100})
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:70})
			.addTextColumn({ name:"supplierCode", dataIndex:"supplier", hidden:true, width:200})
			.addTextColumn({ name:"supplier", dataIndex:"supplier", width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"deliveryMethodId", dataIndex:"deliveryMethodId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"deliveryMethod", dataIndex:"deliveryMethod", hidden:true, width:120})
			.addDefaults();
	}});


/* ================= EDITOR: EditMain ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrder$EditMain", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sc_order_dc_PurchaseOrder$EditMain",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addDateField({name:"docDate", dataIndex:"docDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesPO", name:"docType", dataIndex:"docType", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "docTypeId"} 
				]})
			.addDisplayFieldText({ name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32})
			.addLov({xtype:"md_mm_price_lovs_PriceListPurchase", name:"priceList", dataIndex:"priceList", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priceListId"} ,{lovField:"currencyId", dsField: "currencyId"} ,{lovField:"currency", dsField: "currency"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"customer", dataIndex:"customer", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "customerId"} 
				]})
			.addLov({xtype:"md_bp_lovs_VendorsName", name:"supplier", dataIndex:"supplier", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"bpartnerId", dsField: "supplierId"} ,{lovField:"code", dsField: "supplierCode"} 
				],
				filterFieldMapping: [
					{lovField:"orgId",dsField: "customerId"} 
				]})
			.addLov({xtype:"bd_org_lovs_WarehouseOrganizations", name:"warehouse", dataIndex:"inventory", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "inventoryId"} 
				]})
			.addDisplayFieldNumber({ name:"totalNetAmount", dataIndex:"totalNetAmount", anchor:"-20" })
			.addDisplayFieldNumber({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", anchor:"-20" })
			.addDisplayFieldNumber({ name:"totalAmount", dataIndex:"totalAmount", anchor:"-20" })
			.addDisplayFieldNumber({ name:"confirmed", dataIndex:"confirmed", anchor:"-20" })
			.addDateField({name:"plannedDeliveryDate", dataIndex:"plannedDeliveryDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addTextArea({ name:"deliveryNotes", dataIndex:"deliveryNotes", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:250, layout:"form"})
			.addPanel({ name:"col4", width:180, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["customer", "supplier", "docType", "warehouse", "priceList"])
			.addChildrenTo("col2", ["docDate", "docNo", "code", "currency"])
			.addChildrenTo("col3", ["totalNetAmount", "totalTaxAmount", "totalAmount"])
			.addChildrenTo("col4", ["confirmed"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_beforeApplyStates_: function(record) {
		
					if (record.get("confirmed")   ) {
						this._disableAllFields_();
						return false;
					};
	},
	
	_endDefine_: function() {
		
					this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
					 	this._applyStates_(dc.record);
					 } , this );
	}
});


/* ================= EDITOR: EditDetails ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrder$EditDetails", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sc_order_dc_PurchaseOrder$EditDetails",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addDateField({name:"plannedDeliveryDate", dataIndex:"plannedDeliveryDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addTextArea({ name:"deliveryNotes", dataIndex:"deliveryNotes", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethodOut", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_PaymentTerm", name:"paymentTerm", dataIndex:"paymentTerm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentTermId"} 
				]})
			.addLov({xtype:"md_base_tx_lovs_DeliveryMethods", name:"deliveryMethod", dataIndex:"deliveryMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "deliveryMethodId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1"})
			.addPanel({ name:"col2"})
			.addPanel({ name:"col3", width:400, layout:"form"})
			.addPanel({ name:"panelShipping",title:"Delivery", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:true})
			.addPanel({ name:"panelPayment",title:"Payment", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:true})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["panelShipping"])
			.addChildrenTo("col2", ["panelPayment"])
			.addChildrenTo("col3", ["description"])
			.addChildrenTo("panelShipping", ["deliveryMethod", "plannedDeliveryDate", "deliveryNotes"])
			.addChildrenTo("panelPayment", ["paymentMethod", "paymentTerm"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_afterApplyStates_: function(record) {
		
				if ( record.get("invoiced") ) {
					this._disableFields_(["billTo","billToLocation" ]);
				}
				if ( record.get("delivered") ) {
					this._disableFields_(["shipTo","shipToLocation" ]);
				}
				;
	},
	
	_endDefine_: function() {
		
				this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
				 	this._applyStates_(dc.record);
				 } , this );
	}
});
