/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentItemProductDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentItemProductDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_fin_dc_PaymentItemProduct$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"product", dataIndex:"product", anchor:"-20", maxLength:32})
			.addTextField({ name:"uom", dataIndex:"uom", anchor:"-20", maxLength:32})
			.addNumberField({name:"quantity", dataIndex:"quantity", anchor:"-20", decimals:2})
			.addNumberField({name:"unitPrice", dataIndex:"unitPrice", anchor:"-20", decimals:2})
			.addNumberField({name:"amount", dataIndex:"amount", anchor:"-20", decimals:2})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["product", "uom"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_fin_dc_PaymentItemProduct$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"product", dataIndex:"product", width:100})
			.addTextColumn({ name:"uom", dataIndex:"uom", width:100})
			.addNumberColumn({ name:"quantity", dataIndex:"quantity", decimals:2})
			.addNumberColumn({ name:"unitPrice", dataIndex:"unitPrice", decimals:2})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addNumberColumn({ name:"paymentId", dataIndex:"paymentId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= E-GRID: CtxEditListProduct ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct$CtxEditListProduct", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_tx_fin_dc_PaymentItemProduct$CtxEditListProduct",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"product", dataIndex:"product", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_mm_prod_lovs_ProductsWithUom", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "productId"} ,{lovField:"uom", dsField: "uom"} ,{lovField:"uomId", dsField: "uomId"} 
						]}})
			.addLov({name:"uom", dataIndex:"uom", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasureCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "uomId"} 
						]}})
			.addNumberColumn({name:"quantity", dataIndex:"quantity", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"unitPrice", dataIndex:"unitPrice", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"amount", dataIndex:"amount", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"paymentId", dataIndex:"paymentId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"productId", dataIndex:"productId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"uomId", dataIndex:"uomId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addDefaults();
	}
});
