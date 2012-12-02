/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDocLine", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccDocLineDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDocLine$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_acc_dc_AccDocLine$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"dbAccount", dataIndex:"dbAccount", anchor:"-20"})
			.addTextField({ name:"crAccount", dataIndex:"crAccount", anchor:"-20"})
			.addNumberField({name:"dbAmount", dataIndex:"dbAmount", anchor:"-20", decimals:2})
			.addNumberField({name:"crAmount", dataIndex:"crAmount", anchor:"-20", decimals:2})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["dbAccount", "crAccount"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDocLine$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_acc_dc_AccDocLine$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", hidden:true})
			.addTextColumn({ name:"dbAccount", dataIndex:"dbAccount", width:90})
			.addTextColumn({ name:"crAccount", dataIndex:"crAccount", width:90})
			.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount", width:90, decimals:2})
			.addNumberColumn({ name:"crAmount", dataIndex:"crAmount", width:90, decimals:2})
			.addNumberColumn({ name:"accDocId", dataIndex:"accDocId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
