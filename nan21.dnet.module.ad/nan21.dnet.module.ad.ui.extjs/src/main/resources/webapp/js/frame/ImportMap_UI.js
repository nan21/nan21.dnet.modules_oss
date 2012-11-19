/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/dc/ImportJobItem", "nan21.dnet.module.ad.ui.extjs/ds/ImportMapDs", "nan21.dnet.module.ad.ui.extjs/dc/ImportMapItemCtx", "nan21.dnet.module.ad.ui.extjs/lov/SysDataSource", "nan21.dnet.module.ad.ui.extjs/ds/ImportMapItemDs", "nan21.dnet.module.ad.ui.extjs/dc/ImportMap", "nan21.dnet.module.ad.ui.extjs/ds/ImportJobItemDs", "nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs"]);

Ext.define("net.nan21.dnet.module.ad.impex.frame.ImportMap_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.impex.frame.ImportMap_UI",
	_name_: "net.nan21.dnet.module.ad.impex.frame.ImportMap_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("map", new net.nan21.dnet.module.ad.impex.dc.ImportMap({}))
			.addDc("item", new net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx({multiEdit:true}))
			.addDc("jobItem", new net.nan21.dnet.module.ad.impex.dc.ImportJobItem({}))
	
			.linkDc("item", "map",{fields:[
				{childField:"importMapId", parentField:"id"}]}
			)
			.linkDc("jobItem", "map",{fields:[
				{childField:"mapId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnRunImportMap", text:"Import All", tooltip:"Import all files included in this set.", iconCls:"icon-action-import", disabled:true,
					handler: this.onBtnRunImportMap, scope:this, stateManager:{name:"record_is_clean", dc:"map" }})
			.addButton({name:"btnRunImportItem", text:"Import selected", tooltip:"Import the selected file (one at a time).", iconCls:"icon-action-import", disabled:true,
					handler: this.onBtnRunImportItem, scope:this, stateManager:{name:"selected_one", dc:"item" }})
			
			.addDcFilterFormView("map", {name:"mapFilter", height:80, xtype:"ad_impex_dc_ImportMap$Filter"})
			.addDcGridView("map", {name:"mapList", xtype:"ad_impex_dc_ImportMap$List"})
			.addDcFormView("map", {name:"mapEdit", height:120, xtype:"ad_impex_dc_ImportMap$Edit"})
			.addDcFilterFormView("item", {name:"itemFilter", title:"Filter", width:300, xtype:"ad_impex_dc_ImportMapItemCtx$Filter", collapsible:true
			})
			.addDcEditGridView("item", {name:"itemEditList", xtype:"ad_impex_dc_ImportMapItemCtx$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnRunImportMap"), this._elems_.get("btnRunImportItem")]}]})
			.addDcGridView("jobItem", {name:"jobItemList", title:"Used in jobs", xtype:"ad_impex_dc_ImportJobItem$ListCtxMap"})
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
			.addToolbarTo("itemsPanel", "tlbItemEditList")
			.addToolbarTo("jobItemList", "tlbJobItemEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMapList", {dc: "map"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Import sets"})
			.end()
			.beginToolbar("tlbMapEdit", {dc: "map"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Import set"})
			.end()
			.beginToolbar("tlbItemEditList", {dc: "item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Files"})
			.end()
			.beginToolbar("tlbJobItemEditList", {dc: "jobItem"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Jobs"})
			.end()
			;
	}

	
	,onBtnRunImportMap: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("map").doService("runImport", s);
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
