/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDsFilter",
	paramModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDsParam",
	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sd_order_dc_SalesOrder$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_DeliveryMethods", name:"deliveryMethod", dataIndex:"deliveryMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "deliveryMethodId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"customer", dataIndex:"customer", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "customerId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"supplier", dataIndex:"supplier", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
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
			.addBooleanField({ name:"invoiced", dataIndex:"invoiced", anchor:"-20"})
			.addBooleanField({ name:"delivered", dataIndex:"delivered", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesSO", name:"docType", dataIndex:"docType", anchor:"-20",
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
			.addChildrenTo("col1", ["supplier", "customer", "warehouse", "docType", "deliveryMethod"])
			.addChildrenTo("col2", ["code", "priceList", "currency"])
			.addChildrenTo("col3", ["docDate", "totalAmount", "totalNetAmount"])
			.addChildrenTo("col4", ["confirmed", "invoiced", "delivered"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_order_dc_SalesOrder$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"supplierCode", dataIndex:"supplier", width:100})
			.addTextColumn({ name:"inventory", dataIndex:"inventory", hidden:true, width:100})
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:70})
			.addTextColumn({ name:"customerCode", dataIndex:"customerCode", hidden:true, width:100})
			.addTextColumn({ name:"customer", dataIndex:"customer", width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed", width:70})
			.addBooleanColumn({ name:"invoiced", dataIndex:"invoiced", hidden:true, width:70})
			.addBooleanColumn({ name:"delivered", dataIndex:"delivered", hidden:true, width:70})
			.addTextColumn({ name:"priceList", dataIndex:"priceList", width:120})
			.addTextColumn({ name:"deliveryMethod", dataIndex:"deliveryMethod", hidden:true, width:120})
			.addTextColumn({ name:"billTo", dataIndex:"billTo", hidden:true, width:200})
			.addTextColumn({ name:"billToCode", dataIndex:"billToCode", hidden:true, width:100})
			.addTextColumn({ name:"shipTo", dataIndex:"shipTo", hidden:true, width:200})
			.addTextColumn({ name:"shipToCode", dataIndex:"shipToCode", hidden:true, width:100})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"billToId", dataIndex:"billToId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"shipToId", dataIndex:"shipToId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"deliveryMethodId", dataIndex:"deliveryMethodId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"priceListId", dataIndex:"priceListId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= EDITOR: CopyLinesForm ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$CopyLinesForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_order_dc_SalesOrder$CopyLinesForm",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"sd_order_lovs_SalesOrder", name:"copyFrom", paramIndex:"copyFrom", anchor:"-20",
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


/* ================= EDITOR: FrmGenDelivery ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$FrmGenDelivery", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_order_dc_SalesOrder$FrmGenDelivery",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesSOInvOut", name:"delivDocType", paramIndex:"delivDocType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "delivDocTypeId"} 
				]})
			.addLov({xtype:"md_tx_inventory_lovs_InvTransactionTypes", name:"delivTxType", paramIndex:"delivTxType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "delivTxTypeId"} 
				],
				filterFieldMapping: [
					{lovField:"docTypeId",dsParam: "delivDocTypeId"} 
				]})
			.addDateField({name:"delivEventDate", paramIndex:"delivEventData", anchor:"-20", format:Ext.DATE_FORMAT})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form", defaults:{labelAlign:"right", labelWidth:140}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["delivDocType", "delivTxType", "delivEventDate"])
		;
	}
});


/* ================= EDITOR: FrmGenInvoice ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$FrmGenInvoice", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_order_dc_SalesOrder$FrmGenInvoice",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesSI", name:"invDocType", paramIndex:"invDocType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "invDocTypeId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form", defaults:{labelAlign:"right", labelWidth:140}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["invDocType"])
		;
	}
});


/* ================= EDITOR: EditMain ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$EditMain", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_order_dc_SalesOrder$EditMain",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addDateField({name:"docDate", dataIndex:"docDate", noUpdate:true, allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesSO", name:"docType", dataIndex:"docType", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "docTypeId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"supplier", dataIndex:"supplier", noUpdate:true, allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
				]})
			.addLov({xtype:"md_bp_lovs_CustomersName", name:"customer", dataIndex:"customer", noUpdate:true, allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"bpartnerId", dsField: "customerId"} ,{lovField:"bpartnerId", dsField: "billToId"} ,{lovField:"name", dsField: "billTo"} ,{lovField:"bpartnerId", dsField: "shipToId"} ,{lovField:"name", dsField: "shipTo"} 
				],
				filterFieldMapping: [
					{lovField:"orgId",dsField: "supplierId"} 
				]})
			.addLov({xtype:"bd_org_lovs_WarehouseOrganizations", name:"warehouse", dataIndex:"inventory", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "inventoryId"} 
				]})
			.addLov({xtype:"md_mm_price_lovs_PriceListSales", name:"priceList", dataIndex:"priceList", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priceListId"} ,{lovField:"currencyId", dsField: "currencyId"} ,{lovField:"currency", dsField: "currency"} 
				]})
			.addDisplayFieldText({ name:"currency", dataIndex:"currency", anchor:"-20", fieldCls:"displayfield important-field", maxLength:32})
			.addDisplayFieldNumber({ name:"totalNetAmount", dataIndex:"totalNetAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldNumber({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldNumber({ name:"totalAmount", dataIndex:"totalAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed", anchor:"-20" })
			.addDisplayFieldBoolean({ name:"invoiced", dataIndex:"invoiced", anchor:"-20" })
			.addDisplayFieldBoolean({ name:"delivered", dataIndex:"delivered", anchor:"-20" })
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
			.addChildrenTo("col1", ["supplier", "customer", "docType", "warehouse", "priceList"])
			.addChildrenTo("col2", ["docDate", "docNo", "code", "currency"])
			.addChildrenTo("col3", ["totalNetAmount", "totalTaxAmount", "totalAmount"])
			.addChildrenTo("col4", ["confirmed", "invoiced", "delivered"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_beforeApplyStates_: function(record) {
		
		if (record.get("confirmed") || record.get("invoiced") || record.get("delivered") ) {
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


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$EditDetails", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_order_dc_SalesOrder$EditDetails",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addDateField({name:"plannedDeliveryDate", dataIndex:"plannedDeliveryDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addTextArea({ name:"deliveryNotes", dataIndex:"deliveryNotes", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_PaymentMethodIn", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
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
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"billTo", dataIndex:"billTo", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "billToId"} 
				]})
			.addLov({xtype:"bd_geo_lovs_LocationsToBill", name:"billToLocation", dataIndex:"billToLocation", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "billToLocationId"} 
				],
				filterFieldMapping: [
					{lovField:"targetUuid",dsField: "billToUuid"} 
				]})
			.addLov({xtype:"md_bp_lovs_BpContacts", name:"billToContact", dataIndex:"billToContact", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "billToContactId"} 
				],
				filterFieldMapping: [
					{lovField:"bpartnerId",dsField: "billToId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"shipTo", dataIndex:"shipTo", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "shipToId"} 
				]})
			.addLov({xtype:"bd_geo_lovs_LocationsToShip", name:"shipToLocation", dataIndex:"shipToLocation", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "shipToLocationId"} 
				],
				filterFieldMapping: [
					{lovField:"targetUuid",dsField: "shipToUuid"} 
				]})
			.addLov({xtype:"md_bp_lovs_BpContacts", name:"shipToContact", dataIndex:"shipToContact", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "shipToContactId"} 
				],
				filterFieldMapping: [
					{lovField:"bpartnerId",dsField: "shipToId"} 
				]})
			.addLov({xtype:"bd_org_lovs_CarrierOrganizations", name:"carrier", dataIndex:"carrier", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "carrierId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1"})
			.addPanel({ name:"col2"})
			.addPanel({ name:"col3", width:400, layout:"form"})
			.addPanel({ name:"panelBilling", title:"Invoice", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:true})
			.addPanel({ name:"panelShipping", title:"Delivery", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:true})
			.addPanel({ name:"panelPayment", title:"Payment", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:true})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["panelShipping"])
			.addChildrenTo("col2", ["panelPayment", "panelBilling"])
			.addChildrenTo("col3", ["description"])
			.addChildrenTo("panelBilling", ["billTo", "billToLocation", "billToContact"])
			.addChildrenTo("panelShipping", ["shipTo", "shipToLocation", "shipToContact", "plannedDeliveryDate", "deliveryMethod", "carrier", "deliveryNotes"])
			.addChildrenTo("panelPayment", ["paymentMethod", "paymentTerm"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_afterApplyStates_: function(record) {
		if ( record.get("invoiced") ) {
			this._disableFields_(["billTo","billToLocation","paymentMethod", "paymentTerm" ]);
		}
		if ( record.get("delivered") ) {
			this._disableFields_(["shipTo","shipToLocation", "carrier", "deliveryMethod", "deliveryNotes" , "plannedDeliveryDate" ]);
		}
	},
	
	_endDefine_: function() {
		this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
			this._applyStates_(dc.record);
		} , this )
	}

});
