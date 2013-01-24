/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI",
	_name_: "net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("dcProcess", new net.nan21.dnet.module.ad.workflow.dc.WfDefProcess({}))
			.addDc("dcNode", new net.nan21.dnet.module.ad.workflow.dc.WfDefNode({multiEdit:true}))
			.addDc("dcField", new net.nan21.dnet.module.ad.workflow.dc.WfDefNodeField({multiEdit:true}))
	
			.linkDc("dcNode", "dcProcess",{fields:[
				{childField:"processId", parentField:"id"}]}
			)
			.linkDc("dcField", "dcNode",{fields:[
				{childField:"nodeId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnDeploy", text:"Deploy", tooltip:"Deploy process", iconCls:"icon-action-run", disabled:true,
					handler: this.onBtnDeploy, scope:this, stateManager:{name:"record_status_is_edit", dc:"dcProcess" }})
			.addButton({name:"btnGetProcessDiagram", text:"Show diagram", tooltip:"Show diagram for this process definition", disabled:true,
					handler: this.onBtnGetProcessDiagram, scope:this, stateManager:{name:"record_status_is_edit", dc:"dcProcess" }})
			
			.addDcFilterFormView("dcProcess", {name:"filterProcess", height:120, xtype:"ad_workflow_dc_WfDefProcess$Filter"})
			.addDcGridView("dcProcess", {name:"listProcess", xtype:"ad_workflow_dc_WfDefProcess$List"})
			.addDcFormView("dcProcess", {name:"formProcess", height:150, xtype:"ad_workflow_dc_WfDefProcess$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnDeploy"), this._elems_.get("btnGetProcessDiagram")]}]})
			.addDcEditGridView("dcNode", {name:"elistNode", xtype:"ad_workflow_dc_WfDefNode$CtxEditList", frame:true})
			.addDcEditGridView("dcField", {name:"elistField", width:500, xtype:"ad_workflow_dc_WfDefNodeField$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"panelDetails", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["filterProcess", "listProcess"], ["north", "center"])
			.addChildrenTo("canvas2", ["formProcess", "panelDetails"], ["north", "center"])
			.addChildrenTo("panelDetails", ["elistNode", "elistField"], ["center", "east"])
			.addToolbarTo("canvas1", "tlbProcessList")
			.addToolbarTo("canvas2", "tlbProcessEdit")
			.addToolbarTo("elistNode", "tlbNodeCtxEditList")
			.addToolbarTo("elistField", "tlbTransitionEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProcessList", {dc: "dcProcess"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Workflow definitions"})
			.end()
			.beginToolbar("tlbProcessEdit", {dc: "dcProcess"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Workflow definition"})
			.end()
			.beginToolbar("tlbNodeCtxEditList", {dc: "dcNode"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Elements"})
			.end()
			.beginToolbar("tlbTransitionEditList", {dc: "dcField"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports()
			.end()
			;
	}

	
	,onBtnDeploy: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("dcProcess").doService("deployProcess", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnGetProcessDiagram: function() {
		window.open(this._getDc_("dcProcess").doServiceUrl("getDiagram"),"ProcessDiagram","width=500,height=400");
	}
});
