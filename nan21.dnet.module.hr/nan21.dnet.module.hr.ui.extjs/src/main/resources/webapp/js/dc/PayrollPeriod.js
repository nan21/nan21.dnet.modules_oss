/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollPeriod", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.PayrollPeriodDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollPeriod$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_payroll_dc_PayrollPeriod$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"payrollId", dataIndex:"payrollId", hidden:true, align:"right", width:70, format:"0"})
			.addTextColumn({name:"payrollName", dataIndex:"payrollName", hidden:true, width:120})
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"startDate", dataIndex:"startDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"endDate", dataIndex:"endDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addBooleanColumn({name:"processed", dataIndex:"processed"})
			.addBooleanColumn({name:"closed", dataIndex:"closed"})
			.addDefaults();
	}});
