/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/dc/ExportMapItem", "nan21.dnet.module.ad.ui.extjs/ds/ExportJobItemDs", "nan21.dnet.module.ad.ui.extjs/lov/CsvExports", "nan21.dnet.module.ad.ui.extjs/ds/CsvExportLovDs", "nan21.dnet.module.ad.ui.extjs/dc/ExportJobItem", "nan21.dnet.module.ad.ui.extjs/dc/ExportMap", "nan21.dnet.module.ad.ui.extjs/ds/ExportMapDs", "nan21.dnet.module.ad.ui.extjs/ds/ExportMapItemDs"]);

Ext.define("net.nan21.dnet.module.ad.impex.frame.ExportMap_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.impex.frame.ExportMap_UI",
	_name_: "net.nan21.dnet.module.ad.impex.frame.ExportMap_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("map", new net.nan21.dnet.module.ad.impex.dc.ExportMap({}))
			.addDc("item", new net.nan21.dnet.module.ad.impex.dc.ExportMapItem({multiEdit:true}))
			.addDc("jobItem", new net.nan21.dnet.module.ad.impex.dc.ExportJobItem({}))
	
			.linkDc("item", "map",{fields:[
				{childField:"exportMapId", parentField:"id"}]}
			)
			.linkDc("jobItem", "map",{fields:[
				{childField:"mapId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnRunExportMap", text:"Export All", tooltip:"Export all items included in this set.", iconCls:"icon-action-export", disabled:true,
					handler: this.onBtnRunExportMap, scope:this, stateManager:{name:"record_is_clean", dc:"map" }})
			.addButton({name:"btnRunExportItem", text:"Export selected", tooltip:"Export the selected item (one at a time).", iconCls:"icon-action-export", disabled:true,
					handler: this.onBtnRunExportItem, scope:this, stateManager:{name:"selected_one", dc:"item" }})
			
			.addDcFilterFormView("map", {name:"mapFilter", height:80, xtype:"ad_impex_dc_ExportMap$Filter"})
			.addDcGridView("map", {name:"mapList", xtype:"ad_impex_dc_ExportMap$List"})
			.addDcFormView("map", {name:"mapEdit", height:120, xtype:"ad_impex_dc_ExportMap$Edit"})
			.addDcFilterFormView("item", {name:"itemFilter", title:"Filter", width:300, xtype:"ad_impex_dc_ExportMapItem$FilterCtx", collapsible:true
			})
			.addDcEditGridView("item", {name:"itemEditList", xtype:"ad_impex_dc_ExportMapItem$EditListCtxExpMap", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnRunExportMap"), this._elems_.get("btnRunExportItem")]}]})
			.addDcGridView("jobItem", {name:"jobItemList", title:"Used in jobs", xtype:"ad_impex_dc_ExportJobItem$ListCtxMap"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"detailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"itemsPanel", title:"Files", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["mapFilter", "mapList"], ["north", "center"])
			.addChildrenTo("canvas2", ["mapEdit", "detailsTab"], ["north", "center"])
			.addChildrenTo("detailsTab", ["itemsPanel", "jobItemList"])
			.addChildrenTo("itemsPanel", ["itemFilter", "itemEditList"], ["west", "center"])
			.addToolbarTo("canvas1", "tlbMapList")
			.addToolbarTo("canvas2", "tlbMapEdit")
			.addToolbarTo("itemEditList", "tlbItemEditList")
			.addToolbarTo("jobItemList", "tlbJobItemEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMapList", {dc: "map"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Export sets"})
			.end()
			.beginToolbar("tlbMapEdit", {dc: "map"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Export set"})
			.end()
			.beginToolbar("tlbItemEditList", {dc: "item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Files"})
			.end()
			.beginToolbar("tlbJobItemEditList", {dc: "jobItem"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Jobs"})
			.end()
			;
	}

	
	,onBtnRunExportMap: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("map").doService("runExport", s);
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
