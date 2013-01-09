/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/ds/SysParamValueDs", "nan21.dnet.module.ad.ui.extjs/ds/SysParamDs", "nan21.dnet.module.ad.ui.extjs/dc/SysParamValue", "nan21.dnet.module.ad.ui.extjs/dc/SysParam"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.SysParamValue_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.system.frame.SysParamValue_UI",
	_name_: "net.nan21.dnet.module.ad.system.frame.SysParamValue_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("sysparam", new net.nan21.dnet.module.ad.system.dc.SysParam({}))
			.addDc("val", new net.nan21.dnet.module.ad.system.dc.SysParamValue({multiEdit:true}))
	
			.linkDc("val", "sysparam",{fetchMode:"auto",fields:[
				{childField:"sysParam", parentField:"code"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnUpdateCache", text:"Update cache", tooltip:"Propagate changes to the cached configuration parameters", iconCls:"icon-action-refresh", disabled:false,
					handler: this.onBtnUpdateCache, scope:this})
			
			.addDcFilterFormView("sysparam", {name:"sysparamFilter", xtype:"ad_system_dc_SysParam$Filter"})
			.addDcGridView("sysparam", {name:"sysparamList", xtype:"ad_system_dc_SysParam$CtxList", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnUpdateCache")]}]})
			.addDcEditGridView("val", {name:"valList", width:500, xtype:"ad_system_dc_SysParamValue$CtxList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["sysparamFilter", "sysparamList", "valList"], ["north", "center", "east"])
			.addToolbarTo("canvas1", "tlbSysparamList")
			.addToolbarTo("valList", "tlbValList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSysparamList", {dc: "sysparam"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "System parameters"})
			.end()
			.beginToolbar("tlbValList", {dc: "val"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Values"})
			.end()
			;
	}

	
	,onBtnUpdateCache: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("sysparam").doServiceFilter("refreshSysConfig", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
});
