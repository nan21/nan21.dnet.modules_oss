/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportJobItem", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportJobItemDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportJobItemDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportJobItem$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_impex_dc_ImportJobItem$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"mapName", dataIndex:"mapName", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_impex_lovs_ImportMap", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "mapId"} 
						]}})
			.addTextColumn({name:"jobName", dataIndex:"jobName", hidden:true, width:120})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"jobId", dataIndex:"jobId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"mapId", dataIndex:"mapId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addDefaults();
	}
});


/* ================= GRID: ListCtxMap ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportJobItem$ListCtxMap", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_impex_dc_ImportJobItem$ListCtxMap",

	_defineColumns_: function() {
		this._getBuilder_()
			.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo"})
			.addTextColumn({ name:"jobName", dataIndex:"jobName", width:200})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addNumberColumn({ name:"jobId", dataIndex:"jobId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"mapId", dataIndex:"mapId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
