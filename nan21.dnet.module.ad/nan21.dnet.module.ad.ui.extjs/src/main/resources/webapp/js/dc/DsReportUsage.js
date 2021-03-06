/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.report.dc.DsReportUsage", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.report.ds.model.DsReportUsageDs"
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.report.dc.DsReportUsage$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_report_dc_DsReportUsage$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"frameName", dataIndex:"frameName", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"dcKey", dataIndex:"dcKey", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"toolbarKey", dataIndex:"toolbarKey", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});
