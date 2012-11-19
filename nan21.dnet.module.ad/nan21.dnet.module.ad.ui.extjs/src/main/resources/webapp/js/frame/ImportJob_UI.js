/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/dc/ImportJobItem", "nan21.dnet.module.ad.ui.extjs/ds/ImportMapLovDs", "nan21.dnet.module.ad.ui.extjs/lov/ImportMap", "nan21.dnet.module.ad.ui.extjs/ds/ImportJobItemDs", "nan21.dnet.module.ad.ui.extjs/ds/ImportJobDs", "nan21.dnet.module.ad.ui.extjs/dc/ImportJob"]);

Ext.define("net.nan21.dnet.module.ad.impex.frame.ImportJob_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.impex.frame.ImportJob_UI",
	_name_: "net.nan21.dnet.module.ad.impex.frame.ImportJob_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("job", new net.nan21.dnet.module.ad.impex.dc.ImportJob({}))
			.addDc("item", new net.nan21.dnet.module.ad.impex.dc.ImportJobItem({multiEdit:true}))
	
			.linkDc("item", "job",{fields:[
				{childField:"jobId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnRunImport", text:"Import All", tooltip:"Import all sets included in this job.", iconCls:"icon-action-import", disabled:true,
					handler: this.onBtnRunImport, scope:this, stateManager:{name:"record_status_is_edit", dc:"job" }})
			.addButton({name:"btnRunImportItem", text:"Import selected", tooltip:"Import the selected set (one at a time).", iconCls:"icon-action-import", disabled:true,
					handler: this.onBtnRunImportItem, scope:this, stateManager:{name:"selected_one", dc:"item" }})
			
			.addDcFilterFormView("job", {name:"jobFilter", height:80, xtype:"ad_impex_dc_ImportJob$Filter"})
			.addDcGridView("job", {name:"jobList", xtype:"ad_impex_dc_ImportJob$List"})
			.addDcFormView("job", {name:"jobEdit", height:140, xtype:"ad_impex_dc_ImportJob$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnRunImport"), this._elems_.get("btnRunImportItem")]}]})
			.addDcEditGridView("item", {name:"itemEditList", xtype:"ad_impex_dc_ImportJobItem$CtxEditList", frame:true})
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
			.addReports().addSeparator().addSeparator().addTitle({text: "Import jobs"})
			.end()
			.beginToolbar("tlbJobEdit", {dc: "job"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Import job"})
			.end()
			.beginToolbar("tlbItemEditList", {dc: "item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Import sets"})
			.end()
			;
	}

	
	,onBtnRunImport: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("job").doService("runImport", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnRunImportItem: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("item").doService("runImport", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
});
