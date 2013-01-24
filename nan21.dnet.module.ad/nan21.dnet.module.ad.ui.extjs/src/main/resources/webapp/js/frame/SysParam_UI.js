/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.system.frame.SysParam_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.system.frame.SysParam_UI",
	_name_: "net.nan21.dnet.module.ad.system.frame.SysParam_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("sysparam", new net.nan21.dnet.module.ad.system.dc.SysParam({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnSynchronize", text:"Synchronize", tooltip:"Scan classpath and synchronize catalog with parameters declared by modules.", iconCls:"icon-action-synchronize", disabled:false,
					handler: this.onBtnSynchronize, scope:this})
			
			.addDcFilterFormView("sysparam", {name:"sysparamFilter", xtype:"ad_system_dc_SysParam$Filter"})
			.addDcGridView("sysparam", {name:"sysparamList", xtype:"ad_system_dc_SysParam$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnSynchronize")]}]})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["sysparamFilter", "sysparamList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbSysparamList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSysparamList", {dc: "sysparam"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "System parameters"})
			.end()
			;
	}

	
	,onBtnSynchronize: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) {
				this._getDc_("sysparam").doQuery();
			};
		s.callbacks['successFn'] = successFn;
		s.callbacks['successScope'] = this;
		try{
			this._getDc_("sysparam").doServiceFilter("synchronizeCatalog", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
});
