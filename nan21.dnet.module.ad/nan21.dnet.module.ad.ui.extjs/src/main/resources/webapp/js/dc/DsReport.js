/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.report.dc.DsReport", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.report.ds.model.DsReportDs",
	filterModel: "net.nan21.dnet.module.ad.report.ds.model.DsReportDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: ReportCtxList ================= */


Ext.define("net.nan21.dnet.module.ad.report.dc.DsReport$ReportCtxList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_report_dc_DsReport$ReportCtxList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"reportId", dataIndex:"reportId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"dataSource", dataIndex:"dataSource", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDataSource", selectOnFocus:true, noUpdate:true}})
			.addDefaults();
	}
});
