/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocType", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocTypeDs",
	filterModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocTypeDsFilter",
	paramModel: "net.nan21.dnet.module.md.base.tx.ds.param.TxDocTypeDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_base_tx_dc_TxDocType$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"category", dataIndex:"category", anchor:"-20",
				store:[ "sales-order", "sales-invoice", "sales-inventory-in", "sales-inventory-out", "purchase-order", "purchase-invoice", "purchase-inventory-in", "purchase-inventory-out", "inventory-transfer", "payment-in", "payment-out"]
			})
			.addLov({xtype:"md_acc_lovs_AccJournals", name:"journal", dataIndex:"journal", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "journalId"} 
				]})
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
			.addChildrenTo("col2", ["category", "journal"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_base_tx_dc_TxDocType$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"journal", dataIndex:"journal", xtype:"gridcolumn", width:120,
					editor:{xtype:"md_acc_lovs_AccJournals", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "journalId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
