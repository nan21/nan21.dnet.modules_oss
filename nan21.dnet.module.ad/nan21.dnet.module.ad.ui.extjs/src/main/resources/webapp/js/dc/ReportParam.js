/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.report.dc.ReportParam", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.report.ds.model.ReportParamDs"
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.report.dc.ReportParam$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_report_dc_ReportParam$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"reportCode", dataIndex:"reportCode", hidden:true, width:60,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addComboColumn({name:"dataType", dataIndex:"dataType", width:100,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "string", "text", "integer", "decimal", "boolean", "date"]}})
			.addTextColumn({name:"listOfValues", dataIndex:"listOfValues", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"defaultValue", dataIndex:"defaultValue", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"mandatory", dataIndex:"mandatory", width:60})
			.addBooleanColumn({name:"noEdit", dataIndex:"noEdit", width:60})
			.addBooleanColumn({name:"active", dataIndex:"active", width:60})
			.addTextColumn({name:"notes", dataIndex:"notes", hidden:true, width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});
