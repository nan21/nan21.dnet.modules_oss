/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.impex.frame.ExportJob_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.impex.frame.ExportJob_UI",
	_name_: "net.nan21.dnet.module.ad.impex.frame.ExportJob_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("job", new net.nan21.dnet.module.ad.impex.dc.ExportJob({}))
			.addDc("item", new net.nan21.dnet.module.ad.impex.dc.ExportJobItem({multiEdit:true}))
	
			.linkDc("item", "job",{fields:[
				{childField:"jobId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnRunExport", text:"Export All", tooltip:"Export all sets included in this job.", iconCls:"icon-action-export", disabled:true,
					handler: this.onBtnRunExport, scope:this, stateManager:{name:"record_status_is_edit", dc:"job" }})
			.addButton({name:"btnRunExportItem", text:"Export selected", tooltip:"Export the selected set (one at a time).", iconCls:"icon-action-export", disabled:true,
					handler: this.onBtnRunExportItem, scope:this, stateManager:{name:"selected_one", dc:"item" }})
			
			.addDcFilterFormView("job", {name:"jobFilter", height:80, xtype:"ad_impex_dc_ExportJob$Filter"})
			.addDcGridView("job", {name:"jobList", xtype:"ad_impex_dc_ExportJob$List"})
			.addDcFormView("job", {name:"jobEdit", height:150, xtype:"ad_impex_dc_ExportJob$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnRunExport"), this._elems_.get("btnRunExportItem")]}]})
			.addDcEditGridView("item", {name:"itemEditList", xtype:"ad_impex_dc_ExportJobItem$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["jobFilter", "jobList"], ["north", "center"])
			.addChildrenTo("canvas2", ["jobEdit", "itemEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbJobList")
			.addToolbarTo("canvas2", "tlbJobEdit")
			.addToolbarTo("itemEditList", "tlbItemEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbJobList", {dc: "job"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Export jobs"})
			.end()
			.beginToolbar("tlbJobEdit", {dc: "job"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Export job"})
			.end()
			.beginToolbar("tlbItemEditList", {dc: "item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Export sets"})
			.end()
			;
	}

	
	,onBtnRunExport: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("job").doService("runExport", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnRunExportItem: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("item").doService("runExport", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
});
