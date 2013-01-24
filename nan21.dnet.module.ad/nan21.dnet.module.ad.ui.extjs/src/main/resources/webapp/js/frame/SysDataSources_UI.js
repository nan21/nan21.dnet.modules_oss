/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.system.frame.SysDataSources_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.system.frame.SysDataSources_UI",
	_name_: "net.nan21.dnet.module.ad.system.frame.SysDataSources_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("ds", new net.nan21.dnet.module.ad.system.dc.SysDataSource({}))
			.addDc("fields", new net.nan21.dnet.module.ad.system.dc.SysDsField({}))
			.addDc("services", new net.nan21.dnet.module.ad.system.dc.SysDsService({}))
	
			.linkDc("fields", "ds",{fetchMode:"auto",fields:[
				{childField:"dataSourceId", parentField:"id"}]}
			)
			.linkDc("services", "ds",{fetchMode:"auto",fields:[
				{childField:"dataSourceId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnSynchronize", text:"Synchronize", tooltip:"Scan classpath and synchronize catalog with deployed instances.", iconCls:"icon-action-synchronize", disabled:false,
					handler: this.onBtnSynchronize, scope:this})
			.addButton({name:"btnInfo", text:"Show info", tooltip:"Show more information.", iconCls:"icon-action-view", disabled:true,
					handler: this.showDsInfo, scope:this, stateManager:{name:"selected_one", dc:"ds" , and: function(dc) {return ( ! dc.getRecord().get('isAsgn') );}}})
			
			.addDcFilterFormView("ds", {name:"dsFilter", height:80, xtype:"ad_system_dc_SysDataSource$Filter"})
			.addDcGridView("ds", {name:"dsList", xtype:"ad_system_dc_SysDataSource$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnSynchronize"), this._elems_.get("btnInfo")]}]})
			.addDcGridView("fields", {name:"listFields", title:"Fields", xtype:"ad_system_dc_SysDsField$CtxList"})
			.addDcGridView("services", {name:"listServices", title:"Services", xtype:"ad_system_dc_SysDsService$CtxList"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"panelDetails", width:400, layout:"accordion", activeItem:0})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["dsFilter", "dsList", "panelDetails"], ["north", "center", "east"])
			.addChildrenTo("panelDetails", ["listFields", "listServices"])
			.addToolbarTo("canvas1", "tlbMList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMList", {dc: "ds"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Data-sources"})
			.end()
			;
	}

	
	,onBtnSynchronize: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) {
				this._getDc_("ds").doQuery();
			};
		s.callbacks['successFn'] = successFn;
		s.callbacks['successScope'] = this;
		try{
			this._getDc_("ds").doServiceFilter("synchronizeCatalog", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,showDsInfo: function() {
		
		var rd = this._getDc_("ds").getRecord(); 
		var w=window.open( Dnet.dsAPI(rd.get("name")+"Ds","html").info ,"DataSourceInfo","width=600,height=500,scrollbars=yes");
		w.focus();
	}
});
