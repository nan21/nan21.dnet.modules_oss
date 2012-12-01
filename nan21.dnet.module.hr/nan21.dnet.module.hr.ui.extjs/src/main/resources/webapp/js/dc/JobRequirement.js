/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.job.dc.JobRequirement", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.job.ds.model.JobRequirementDs",
	filterModel: "net.nan21.dnet.module.hr.job.ds.model.JobRequirementDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.job.dc.JobRequirement$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_job_dc_JobRequirement$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"jobId", dataIndex:"jobId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"requirementId", dataIndex:"requirementId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"requirement", dataIndex:"requirement", xtype:"gridcolumn", width:300,
					editor:{xtype:"hr_job_lovs_WorkRequirements", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "requirementId"} 
						]}})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});
