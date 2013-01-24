/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.TxBalance", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.TxBalanceDsFilter",
	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.TxBalanceDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.TxBalance$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_fin_dc_TxBalance$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"businessPartner", dataIndex:"businessPartner", anchor:"-20", maxLength:32})
			.addTextField({ name:"organization", dataIndex:"organization", anchor:"-20", maxLength:32})
			.addTextField({ name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32})
			.addNumberField({name:"amount_From", dataIndex:"amount_From", emptyText:"From" })
			.addNumberField({name:"amount_To", dataIndex:"amount_To", emptyText:"To" })
			.addFieldContainer({name: "amount", fieldLabel:"Amount"})
				.addChildrenTo("amount",["amount_From", "amount_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["businessPartner", "organization", "currency"])
			.addChildrenTo("col2", ["amount"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.TxBalance$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_fin_dc_TxBalance$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"businessPartner", dataIndex:"businessPartner", width:100})
			.addTextColumn({ name:"organization", dataIndex:"organization", width:100})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:100})
			.addNumberColumn({ name:"businessPartnerId", dataIndex:"businessPartnerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"organizationId", dataIndex:"organizationId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.md.tx.fin.dc.TxBalance$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_fin_dc_TxBalance$CtxList",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"organization", dataIndex:"organization", width:100})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:100})
			.addNumberColumn({ name:"businessPartnerId", dataIndex:"businessPartnerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"organizationId", dataIndex:"organizationId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
