/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.usr.frame.Assignables_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.frame.Assignables_UI",
	_name_: "net.nan21.dnet.module.ad.usr.frame.Assignables_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("assignableType", new net.nan21.dnet.module.ad.usr.dc.AssignableType({multiEdit:true}))
			.addDc("assignable", new net.nan21.dnet.module.ad.usr.dc.Assignable({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("assignableType", {name:"assignableTypeFilter", height:80, xtype:"ad_usr_dc_AssignableType$Filter"})
			.addDcEditGridView("assignableType", {name:"assignableTypeEditList", xtype:"ad_usr_dc_AssignableType$EditList", frame:true})
			.addDcFilterFormView("assignable", {name:"assignableFilter", height:80, xtype:"ad_usr_dc_Assignable$Filter"})
			.addDcEditGridView("assignable", {name:"assignableEditList", xtype:"ad_usr_dc_Assignable$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasType", title:"Assignable types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasResource", title:"Assignable resources", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasType","canvasResource"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasType", "canvasResource"])
			.addChildrenTo("canvasType", ["assignableTypeFilter", "assignableTypeEditList"], ["north", "center"])
			.addChildrenTo("canvasResource", ["assignableFilter", "assignableEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasType", "tlbAssignableTypeEditList")
			.addToolbarTo("canvasResource", "tlbAssignableEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAssignableTypeEditList", {dc: "assignableType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Assignable types"})
			.end()
			.beginToolbar("tlbAssignableEditList", {dc: "assignable"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Assignable resources"})
			.end()
			;
	}

});
