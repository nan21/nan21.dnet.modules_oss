/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActTaskInstanceDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_workflow_dc_ActTaskInstance$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addCheckbox({ name:"hideActive", paramIndex:"hideActive", anchor:"-20",listeners:{
				change:{scope:this, fn:this._doQuery_}
			}
			})
			.addCheckbox({ name:"hideCompleted", paramIndex:"hideCompleted", anchor:"-20",listeners:{
				change:{scope:this, fn:this._doQuery_}
			}
			})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:80, layout:"form", defaults:{labelAlign:"right", labelWidth:70}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["hideActive", "hideCompleted"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_doQuery_: function() {
		this._controller_.doQuery();
	}

});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_workflow_dc_ActTaskInstance$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"processId", dataIndex:"processId", hidden:true, width:150})
			.addTextColumn({ name:"taskKey", dataIndex:"taskKey", width:120})
			.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true, width:150})
			.addTextColumn({ name:"executionId", dataIndex:"executionId", hidden:true, width:200})
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addTextColumn({ name:"assignee", dataIndex:"assignee", width:100})
			.addDateColumn({ name:"startTime", dataIndex:"startTime", format: Dnet.DATETIME_FORMAT})
			.addDateColumn({ name:"endTime", dataIndex:"endTime", format: Dnet.DATETIME_FORMAT})
			.addNumberColumn({ name:"priority", dataIndex:"priority", hidden:true, width:70, format:"0"})
			.addDateColumn({ name:"dueDate", dataIndex:"dueDate", hidden:true, format: Dnet.DATETIME_FORMAT})
			.addDefaults();
	}
});


/* ================= EDITOR: AssignForm ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$AssignForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_workflow_dc_ActTaskInstance$AssignForm",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"assignee", dataIndex:"assignee", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["assignee"])
		;
	}
});
