/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmount", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.SalesTxAmountDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sd_invoice_dc_SalesTxAmount$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDateField({name:"dueDate", dataIndex:"dueDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addNumberField({name:"amount", dataIndex:"amount", anchor:"-20"})
			.addNumberField({name:"payedAmount", dataIndex:"payedAmount", anchor:"-20"})
			.addNumberField({name:"dueAmount", dataIndex:"dueAmount", anchor:"-20"})
			.addTextField({ name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["paymentMethod"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmount$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.sd_invoice_dc_SalesTxAmount$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addDateColumn({name:"dueDate", dataIndex:"dueDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addLov({name:"paymentMethod", dataIndex:"paymentMethod", xtype:"gridcolumn", width:120,
					editor:{xtype:"md_base_tx_lovs_PaymentMethodIn", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "paymentMethodId"} 
						]}})
			.addNumberColumn({name:"amount", dataIndex:"amount", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"payedAmount", dataIndex:"payedAmount", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"dueAmount", dataIndex:"dueAmount", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"invoiceId", dataIndex:"invoiceId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"orderId", dataIndex:"orderId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
