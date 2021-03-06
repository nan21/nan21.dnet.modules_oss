/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.payroll.frame.Payroll_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.payroll.frame.Payroll_UI",
	_name_: "net.nan21.dnet.module.hr.payroll.frame.Payroll_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("payroll", new net.nan21.dnet.module.hr.payroll.dc.Payroll({}))
			.addDc("period", new net.nan21.dnet.module.hr.payroll.dc.PayrollPeriod({multiEdit:true}))
	
			.linkDc("period", "payroll",{fields:[
				{childField:"payrollId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnOpenPeriod", text:"Open", tooltip:"Open payroll period", disabled:true,
					handler: this.onBtnOpenPeriod, scope:this, stateManager:{name:"selected_one_clean", dc:"period" , and: function(dc) {return (dc.record && !dc.record.get("active") && !dc.record.get("closed")  );}}})
			.addButton({name:"btnClosePeriod", text:"Close", tooltip:"Close payroll period", disabled:true,
					handler: this.onBtnClosePeriod, scope:this, stateManager:{name:"selected_one_clean", dc:"period" , and: function(dc) {return (dc.record  && dc.record.get("processed")  && ! dc.record.get("closed")  );}}})
			.addButton({name:"btnProcessPeriod", text:"Process", tooltip:"Process payroll period", iconCls:"icon-gears", disabled:true,
					handler: this.onBtnProcessPeriod, scope:this, stateManager:{name:"selected_one_clean", dc:"period" , and: function(dc) {return (dc.record && dc.record.get("active") && !dc.record.get("processed")  );}}})
			.addButton({name:"btnClearPeriod", text:"Clear", tooltip:"Delete processed values", iconCls:"icon-action-rollback", disabled:true,
					handler: this.onBtnClearPeriod, scope:this, stateManager:{name:"selected_one_clean", dc:"period" , and: function(dc) {return (dc.record && dc.record.get("active") && dc.record.get("processed")  );}}})
			
			.addDcFilterFormView("payroll", {name:"payrollFilter", height:80, xtype:"hr_payroll_dc_Payroll$Filter"})
			.addDcGridView("payroll", {name:"payrollList", xtype:"hr_payroll_dc_Payroll$List"})
			.addDcFormView("payroll", {name:"payrollEdit", height:160, xtype:"hr_payroll_dc_Payroll$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnOpenPeriod"), this._elems_.get("btnProcessPeriod"), this._elems_.get("btnClearPeriod"), this._elems_.get("btnClosePeriod")]}]})
			.addDcEditGridView("period", {name:"periodCtxEditList", xtype:"hr_payroll_dc_PayrollPeriod$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["payrollFilter", "payrollList"], ["north", "center"])
			.addChildrenTo("canvas2", ["payrollEdit", "periodCtxEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbPayrollList")
			.addToolbarTo("canvas2", "tlbPayrollEdit")
			.addToolbarTo("periodCtxEditList", "tlbPeriodCtxEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPayrollList", {dc: "payroll"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Payrolls"})
			.end()
			.beginToolbar("tlbPayrollEdit", {dc: "payroll"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Payrolls"})
			.end()
			.beginToolbar("tlbPeriodCtxEditList", {dc: "period"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Periods"})
			.end()
			;
	}

	
	,onBtnOpenPeriod: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("period").doService("open", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnClosePeriod: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("period").doService("close", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnProcessPeriod: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("period").doService("process", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnClearPeriod: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("period").doService("clear", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
});
