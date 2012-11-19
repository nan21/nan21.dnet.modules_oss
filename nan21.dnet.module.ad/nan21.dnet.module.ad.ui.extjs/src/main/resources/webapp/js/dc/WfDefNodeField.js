/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefNodeField", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeFieldDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeFieldDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.WfDefNodeFieldDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefNodeField$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_workflow_dc_WfDefNodeField$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addComboColumn({name:"type", dataIndex:"type", width:60,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, allowBlank:false, triggerAction:'all', forceSelection:true, store:[ "text", "number", "date"]}})
			.addBooleanColumn({name:"required", dataIndex:"required"})
			.addNumberColumn({name:"nodeId", dataIndex:"nodeId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
