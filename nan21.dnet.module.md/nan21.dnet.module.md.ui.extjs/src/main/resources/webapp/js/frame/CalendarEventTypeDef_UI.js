/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/ds/CalendarEventPriorityDs", "nan21.dnet.module.md.ui.extjs/dc/CalendarEventStatus", "nan21.dnet.module.md.ui.extjs/dc/CalendarEventPriority", "nan21.dnet.module.md.ui.extjs/ds/CalendarEventStatusDs"]);

Ext.define("net.nan21.dnet.module.md.activity.frame.CalendarEventTypeDef_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.activity.frame.CalendarEventTypeDef_UI",
	_name_: "net.nan21.dnet.module.md.activity.frame.CalendarEventTypeDef_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("status", new net.nan21.dnet.module.md.activity.dc.CalendarEventStatus({multiEdit:true}))
			.addDc("priority", new net.nan21.dnet.module.md.activity.dc.CalendarEventPriority({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("status", {name:"statusFilter", height:120, xtype:"md_activity_dc_CalendarEventStatus$Filter"})
			.addDcEditGridView("status", {name:"statusEditList", xtype:"md_activity_dc_CalendarEventStatus$EditList", frame:true})
			.addDcFilterFormView("priority", {name:"priorityFilter", height:120, xtype:"md_activity_dc_CalendarEventPriority$Filter"})
			.addDcEditGridView("priority", {name:"priorityEditList", xtype:"md_activity_dc_CalendarEventPriority$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasStatus", title:"Event status", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasPriority", title:"Event priority", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasStatus","canvasPriority"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasStatus", "canvasPriority"])
			.addChildrenTo("canvasStatus", ["statusFilter", "statusEditList"], ["north", "center"])
			.addChildrenTo("canvasPriority", ["priorityFilter", "priorityEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasStatus", "statusTlb")
			.addToolbarTo("canvasPriority", "priorityTlb")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("statusTlb", {dc: "status"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Event status"})
			.end()
			.beginToolbar("priorityTlb", {dc: "priority"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Event priority"})
			.end()
			;
	}

});
