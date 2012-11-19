/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentItemAccItemDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentItemAccItemDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.PaymentItemAccItemDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_fin_dc_PaymentItemAccItem$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"accItem", dataIndex:"accItem", anchor:"-20"})
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
			.addChildrenTo("col1", ["accItem"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_fin_dc_PaymentItemAccItem$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"accItem", dataIndex:"accItem", width:120})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addNumberColumn({ name:"paymentId", dataIndex:"paymentId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"accItemId", dataIndex:"accItemId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditListAccItem ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem$CtxEditListAccItem", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_tx_fin_dc_PaymentItemAccItem$CtxEditListAccItem",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accItem", dataIndex:"accItem", xtype:"gridcolumn", width:120,
					editor:{xtype:"md_acc_lovs_AccItems", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accItemId"} 
						]}})
			.addNumberColumn({name:"amount", dataIndex:"amount", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"paymentId", dataIndex:"paymentId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"accItemId", dataIndex:"accItemId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
