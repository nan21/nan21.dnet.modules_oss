/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocSequence", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocSequenceDs",
	filterModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocSequenceDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocSequence$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_base_tx_dc_TxDocSequence$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addNumberField({name:"firstNo", dataIndex:"firstNo", anchor:"-20"})
			.addNumberField({name:"lastNo", dataIndex:"lastNo", anchor:"-20"})
			.addNumberField({name:"nextNo", dataIndex:"nextNo", anchor:"-20"})
			.addTextField({ name:"prefix", dataIndex:"prefix", anchor:"-20", maxLength:4})
			.addTextField({ name:"suffix", dataIndex:"suffix", anchor:"-20", maxLength:4})
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
			.addChildrenTo("col1", ["name", "active"])
			.addChildrenTo("col2", ["prefix", "suffix"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocSequence$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_base_tx_dc_TxDocSequence$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"prefix", dataIndex:"prefix", width:50,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"suffix", dataIndex:"suffix", width:50,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"firstNo", dataIndex:"firstNo", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"lastNo", dataIndex:"lastNo", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"incrementBy", dataIndex:"incrementBy", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"nextNo", dataIndex:"nextNo", align:"right"})
			.addDefaults();
	}
});
