/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.base.tx.dc.DeliveryMethod", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.DeliveryMethodDs",
	filterModel: "net.nan21.dnet.module.md.base.tx.ds.model.DeliveryMethodDsFilter",
	paramModel: "net.nan21.dnet.module.md.base.tx.ds.param.DeliveryMethodDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.base.tx.dc.DeliveryMethod$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_base_tx_dc_DeliveryMethod$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"delivery", dataIndex:"delivery", anchor:"-20"})
			.addBooleanField({ name:"externalCourier", dataIndex:"externalCourier", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "active"])
			.addChildrenTo("col2", ["delivery", "externalCourier"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.base.tx.dc.DeliveryMethod$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_base_tx_dc_DeliveryMethod$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"delivery", dataIndex:"delivery"})
			.addBooleanColumn({name:"externalCourier", dataIndex:"externalCourier"})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
