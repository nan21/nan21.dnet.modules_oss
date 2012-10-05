/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActVariable", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActVariableDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActVariableDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActVariableDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActVariable$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_workflow_dc_ActVariable$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"type", dataIndex:"type", width:80})
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addNumberColumn({ name:"doubleValue", dataIndex:"doubleValue", decimals:2})
			.addNumberColumn({ name:"longValue", dataIndex:"longValue", width:70, format:"0"})
			.addTextColumn({ name:"textValue", dataIndex:"textValue", width:200})
			.addTextColumn({ name:"textValue2", dataIndex:"textValue2", width:200})
			.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true, width:200})
			.addTextColumn({ name:"executionId", dataIndex:"executionId", hidden:true, width:200})
			.addDefaults();
	}});
