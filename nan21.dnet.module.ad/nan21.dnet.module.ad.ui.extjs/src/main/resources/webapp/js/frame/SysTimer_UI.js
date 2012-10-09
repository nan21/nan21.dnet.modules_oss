/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/ds/SysJobCtxLovDs", "nan21.dnet.module.ad.ui.extjs/ds/SysTimerDs", "nan21.dnet.module.ad.ui.extjs/dc/SysTimer", "nan21.dnet.module.ad.ui.extjs/lov/SysJobCtx"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.SysTimer_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.system.frame.SysTimer_UI",
	_name_: "net.nan21.dnet.module.ad.system.frame.SysTimer_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("timer", new net.nan21.dnet.module.ad.system.dc.SysTimer({}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("timer", {name:"timerFilter", height:120, xtype:"ad_system_dc_SysTimer$Filter"})	
			.addDcGridView("timer", {name:"timerList", xtype:"ad_system_dc_SysTimer$List"})	
			.addDcFormView("timer", {name:"timerEdit", title:"Timer", width:500, xtype:"ad_system_dc_SysTimer$Edit", collapsible:true
			})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["timerFilter", "timerList", "timerEdit"], ["north", "center", "east"])
			.addToolbarTo("canvas1", "tlbTimerList")
			.addToolbarTo("timerEdit", "tlbTimerEdit")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTimerList", {dc: "timer"}).addQuery().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Timers"})
			.end()
			.beginToolbar("tlbTimerEdit", {dc: "timer"}).addSave().addNew().addCopy().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Timer"})
			.end()
	}

});
