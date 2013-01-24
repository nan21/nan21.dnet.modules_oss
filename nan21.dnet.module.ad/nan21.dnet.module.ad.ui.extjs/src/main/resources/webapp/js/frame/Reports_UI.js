/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.report.frame.Reports_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.report.frame.Reports_UI",
	_name_: "net.nan21.dnet.module.ad.report.frame.Reports_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("rep", new net.nan21.dnet.module.ad.report.dc.Report({}))
			.addDc("params", new net.nan21.dnet.module.ad.report.dc.ReportParam({multiEdit:true}))
			.addDc("paramsRt", new net.nan21.dnet.module.ad.report.dc.ReportParamRt({multiEdit:true}))
			.addDc("dsrep", new net.nan21.dnet.module.ad.report.dc.DsReport({multiEdit:true}))
			.addDc("dsparam", new net.nan21.dnet.module.ad.report.dc.DsReportParam({multiEdit:true}))
			.addDc("usage", new net.nan21.dnet.module.ad.report.dc.DsReportUsage({multiEdit:true}))
	
			.linkDc("params", "rep",{fields:[
				{childField:"reportId", parentField:"id"}]}
			)
			.linkDc("paramsRt", "rep",{fields:[
				{childField:"reportId", parentField:"id"}]}
			)
			.linkDc("dsrep", "rep",{fields:[
				{childField:"reportId", parentField:"id"}]}
			)
			.linkDc("dsparam", "dsrep",{fields:[
				{childField:"dsReportId", parentField:"id"}, {childField:"reportId", parentField:"reportId"}, {childField:"dataSource", parentField:"dataSource"}]}
			)
			.linkDc("usage", "dsrep",{fields:[
				{childField:"dsReportId", parentField:"id"}, {childField:"reportId", parentField:"reportId"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnTestReport", text:"Test report", tooltip:"Test report", iconCls:"icon-action-run", disabled:false,
					handler: this.onBtnTestReport, scope:this})
			.addButton({name:"btnRunReport", text:"Run", tooltip:"Run", iconCls:"icon-action-commit", disabled:false,
					handler: this.onBtnRunReport, scope:this})
			.addButton({name:"btnCancelReport", text:"Cancel", tooltip:"Cancel", iconCls:"icon-action-reset", disabled:false,
					handler: this.onBtnCancelReport, scope:this})
			
			.addDcFilterFormView("rep", {name:"repFilter", height:80, xtype:"ad_report_dc_Report$Filter"})
			.addDcGridView("rep", {name:"repList", xtype:"ad_report_dc_Report$List"})
			.addDcFormView("rep", {name:"repEdit", height:200, xtype:"ad_report_dc_Report$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnTestReport")]}]})
			.addDcEditGridView("params", {name:"paramEditList", title:"Parameters", xtype:"ad_report_dc_ReportParam$CtxEditList", frame:true})
			.addDcEditGridView("paramsRt", {name:"paramTest", xtype:"ad_report_dc_ReportParamRt$TestRt", frame:true})
			.addDcEditGridView("dsrep", {name:"dsrepList", width:450, xtype:"ad_report_dc_DsReport$ReportCtxList", frame:true})
			.addDcEditGridView("dsparam", {name:"dsparamList", title:"Parameter mapping", xtype:"ad_report_dc_DsReportParam$CtxEditList", frame:true})
			.addDcEditGridView("usage", {name:"usageList", title:"Usage", xtype:"ad_report_dc_DsReportUsage$CtxEditList", frame:true})
			.addWindow({name:"wdwTestReport", title:"Test report", width:450, height:350, closeAction:'hide', resizable:true, layout:"fit", modal:true,
				items:[this._elems_.get("paramTest")], closable:false
				, 
						dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
							items:[ this._elems_.get("btnRunReport"), this._elems_.get("btnCancelReport")]}]})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"repDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"dsRep", title:"DS links", layout:"border", defaults:{split:true}})
			.addPanel({name:"dsrepDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["repFilter", "repList"], ["north", "center"])
			.addChildrenTo("canvas2", ["repEdit", "repDetailsTab"], ["north", "center"])
			.addChildrenTo("repDetailsTab", ["paramEditList", "dsRep"])
			.addChildrenTo("dsRep", ["dsrepList", "dsrepDetailsTab"], ["west", "center"])
			.addChildrenTo("dsrepDetailsTab", ["dsparamList", "usageList"])
			.addToolbarTo("canvas1", "tlbRepList")
			.addToolbarTo("canvas2", "tlbRepEdit")
			.addToolbarTo("paramEditList", "tlbParamList")
			.addToolbarTo("dsrepList", "tlbDsRepList")
			.addToolbarTo("dsparamList", "tlbDsParamList")
			.addToolbarTo("usageList", "tlbUsageList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbRepList", {dc: "rep"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Reports"})
			.end()
			.beginToolbar("tlbRepEdit", {dc: "rep"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Report"})
			.end()
			.beginToolbar("tlbParamList", {dc: "params"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Parameters"})
			.end()
			.beginToolbar("tlbDsRepList", {dc: "dsrep"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Data-source"})
			.end()
			.beginToolbar("tlbDsParamList", {dc: "dsparam"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Parameter mapping"})
			.end()
			.beginToolbar("tlbUsageList", {dc: "usage"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Usage"})
			.end()
			;
	}

	
	,onBtnTestReport: function() {
		this._getWindow_("wdwTestReport").show();
		this._getDc_("paramsRt").doQuery();
	}
	
	,onBtnRunReport: function() {
		this._runReport_();
	}
	
	,onBtnCancelReport: function() {
		this._getDc_("paramsRt").doCancel();
		this._getWindow_("wdwTestReport").close();
	}
	
	,_runReport_: function() {
		var paramsDc = this._getDc_("paramsRt")
					serverUrl = this._getDc_("rep").record.data.serverUrl;
				
				var qs = "";
				
				paramsDc.store.data.each(function(item, idx,len) {
					if(qs != "") {
						qs += "&";
					}
					qs += item.get("code") + "=" + item.get("value");
				});
				window.open(serverUrl + "?" + qs,"Test-report","")
				.focus();
	}
});
