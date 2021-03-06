/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.usr.frame.Menu_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.frame.Menu_UI",
	_name_: "net.nan21.dnet.module.ad.usr.frame.Menu_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("menu", new net.nan21.dnet.module.ad.usr.dc.Menu({multiEdit:true}))
			.addDc("menuitem", new net.nan21.dnet.module.ad.usr.dc.MenuItem({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnAsgnItemRoles", text:"Roles", tooltip:"Assign roles to the selected menu item", disabled:true,
					handler: this.onBtnAsgnItemRoles, scope:this, stateManager:{name:"selected_one_clean", dc:"menuitem" }})
			.addButton({name:"btnAsgnMenuRoles", text:"Roles", tooltip:"Assign roles to the selected menu", disabled:true,
					handler: this.onBtnAsgnMenuRoles, scope:this, stateManager:{name:"selected_one_clean", dc:"menu" }})
			
			.addDcFilterFormView("menu", {name:"menuFilter", xtype:"ad_usr_dc_Menu$Filter"})
			.addDcEditGridView("menu", {name:"menuEditList", xtype:"ad_usr_dc_Menu$EditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnAsgnMenuRoles")]}]})
			.addDcFilterFormView("menuitem", {name:"menuitemFilter", xtype:"ad_usr_dc_MenuItem$Filter"})
			.addDcEditGridView("menuitem", {name:"menuitemList", xtype:"ad_usr_dc_MenuItem$EditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnAsgnItemRoles")]}]})
			.addDcFormView("menuitem", {name:"menuitemEdit", xtype:"ad_usr_dc_MenuItem$Edit"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasMenu", title:"Menus", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasItem", title:"Menu items", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasItem","canvasMenu"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasItem", "canvasMenu"])
			.addChildrenTo("canvasMenu", ["menuFilter", "menuEditList"], ["north", "center"])
			.addChildrenTo("canvasItem", ["menuitemFilter", "menuitemList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasMenu", "tlbMenuEditList")
			.addToolbarTo("canvasItem", "tlbMenuitemList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMenuEditList", {dc: "menu"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Menus"})
			.end()
			.beginToolbar("tlbMenuitemList", {dc: "menuitem"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Menu items"})
			.end()
			;
	}

	
	,onBtnAsgnItemRoles: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.MenuItemRoles$Ui ,{dc: "menuitem", objectIdField: "id"});
	}
	
	,onBtnAsgnMenuRoles: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.MenuRoles$Ui ,{dc: "menu", objectIdField: "id"});
	}
});
