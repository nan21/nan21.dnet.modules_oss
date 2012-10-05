/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.report.dc.DsReportParam", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.report.ds.model.DsReportParamDs",
	filterModel: "net.nan21.dnet.module.ad.report.ds.model.DsReportParamDsFilter",
	paramModel: "net.nan21.dnet.module.ad.report.ds.param.DsReportParamDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.report.dc.DsReportParam$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_report_dc_DsReportParam$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"paramCode", dataIndex:"paramCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"ad_report_lovs_ReportParams", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "paramId"} ,{lovField:"name", dsField: "paramName"} 
						],
						filterFieldMapping: [
							{lovField:"reportId",dsField: "reportId"} 
						]}})
			.addTextColumn({name:"paramName", dataIndex:"paramName", width:200})
			.addLov({name:"dsField", dataIndex:"dsField", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDsFields", selectOnFocus:true,
						filterFieldMapping: [
							{lovField:"dataSourceName",dsField: "dataSource"} 
						]}})
			.addTextColumn({name:"staticValue", dataIndex:"staticValue", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}});
