/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportJobItem", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ExportJobItemDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.ExportJobItemDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportJobItem$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_impex_dc_ExportJobItem$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"mapName", dataIndex:"mapName", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_impex_lovs_ExportMaps", selectOnFocus:true,
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


Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportJobItem$ListCtxMap", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_impex_dc_ExportJobItem$ListCtxMap",

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
