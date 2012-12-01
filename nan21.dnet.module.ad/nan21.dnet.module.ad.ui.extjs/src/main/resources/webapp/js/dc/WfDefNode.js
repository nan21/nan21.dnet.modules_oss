/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefNode", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefNode$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_workflow_dc_WfDefNode$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addComboColumn({name:"type", dataIndex:"taskType", width:60,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, allowBlank:false, triggerAction:'all', forceSelection:true, store:[ "userTask"]}})
			.addTextColumn({name:"assignToUser", dataIndex:"assignToUser", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"assignToGroup", dataIndex:"assignToGroup", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"startWithPrevious", dataIndex:"startWithPrevious"})
			.addNumberColumn({name:"processId", dataIndex:"processId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
