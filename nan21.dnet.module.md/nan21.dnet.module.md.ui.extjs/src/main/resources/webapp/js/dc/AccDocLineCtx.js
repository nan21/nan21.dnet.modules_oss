/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDocLineCtx", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccDocLineCtxDs",
	filterModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccDocLineCtxDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.acc.ds.param.AccDocLineCtxDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDocLineCtx$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.md_tx_acc_dc_AccDocLineCtx$Filter",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_acc_lovs_AccSchemas", name:"accSchema", dataIndex:"accSchema", allowBlank:false, anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.md.acc.lovs.AccSchemas", selectOnFocus:true, allowBlank:false,
					retFieldMapping: [
						{lovField:"id", dsField: "accSchemaId"} 
					]}})
			.addTextField({ name:"dbAccount", dataIndex:"dbAccount", anchor:"-20"})
			.addTextField({ name:"crAccount", dataIndex:"crAccount", anchor:"-20"})
		;
	},

});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDocLineCtx$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_acc_dc_AccDocLineCtx$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", hidden:true})
			.addTextColumn({ name:"accSchema", dataIndex:"accSchema", width:100})
			.addTextColumn({ name:"dbAccount", dataIndex:"dbAccount", width:130})
			.addTextColumn({ name:"crAccount", dataIndex:"crAccount", width:130})
			.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount", width:130, decimals:2})
			.addNumberColumn({ name:"crAmount", dataIndex:"crAmount", width:130, decimals:2})
			.addNumberColumn({ name:"accDocId", dataIndex:"accDocId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
