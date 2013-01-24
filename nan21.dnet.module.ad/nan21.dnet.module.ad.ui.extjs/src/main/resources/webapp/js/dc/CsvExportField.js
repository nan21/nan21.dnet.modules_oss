/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExportField", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.CsvExportFieldDs"
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExportField$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_impex_dc_CsvExportField$CtxEditList",
	_bulkEditFields_: ["active"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"csvExport", dataIndex:"csvExport", hidden:true, width:120})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:60,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"dsField", dataIndex:"dsField", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_system_lovs_SysDsFields", selectOnFocus:true,
						filterFieldMapping: [
							{lovField:"dataSourceName",dsField: "dataSource"} 
						]}})
			.addTextColumn({name:"alias", dataIndex:"alias", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"csvExportId", dataIndex:"csvExportId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
