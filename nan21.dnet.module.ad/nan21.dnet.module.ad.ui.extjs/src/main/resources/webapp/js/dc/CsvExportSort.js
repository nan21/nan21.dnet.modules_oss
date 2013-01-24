/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExportSort", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.CsvExportSortDs"
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExportSort$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_impex_dc_CsvExportSort$CtxEditList",
	_bulkEditFields_: ["descend"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"csvExport", dataIndex:"csvExport", hidden:true, width:120})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"dsField", dataIndex:"dsField", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDsFields", selectOnFocus:true,
						filterFieldMapping: [
							{lovField:"dataSourceName",dsField: "dataSource"} 
						]}})
			.addBooleanColumn({name:"descend", dataIndex:"descend"})
			.addNumberColumn({name:"csvExportId", dataIndex:"csvExportId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
