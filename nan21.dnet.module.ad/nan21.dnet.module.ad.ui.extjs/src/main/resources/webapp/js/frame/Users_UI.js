/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.usr.frame.Users_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.frame.Users_UI",
	_name_: "net.nan21.dnet.module.ad.usr.frame.Users_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("usr", new net.nan21.dnet.module.ad.usr.dc.User({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnAsgnRoles", text:"Roles", tooltip:"Assign roles", disabled:true,
					handler: this.onBtnAsgnRoles, scope:this, stateManager:{name:"record_is_clean", dc:"usr" }})
			.addButton({name:"btnAsgnGroups", text:"Groups", tooltip:"Add to user-groups", disabled:true,
					handler: this.onBtnAsgnGroups, scope:this, stateManager:{name:"record_is_clean", dc:"usr" }})
			.addButton({name:"btnChangePassword", text:"Change password", tooltip:"Change the user`s password", disabled:true,
					handler: this.onBtnChangePassword, scope:this, stateManager:{name:"record_is_clean", dc:"usr" }})
			.addButton({name:"btnSavePassword", text:"Save", tooltip:"Save new password", disabled:false,
					handler: this.onBtnSavePassword, scope:this})
			.addButton({name:"btnCreateAssignable", text:"Create assignable", tooltip:"Create assignable resource record", disabled:true,
					handler: this.onBtnCreateAssignable, scope:this, stateManager:{name:"record_is_clean", dc:"usr" }})
			
			.addDcFilterFormView("usr", {name:"usrFilter", height:120, xtype:"ad_usr_dc_User$Filter"})
			.addDcGridView("usr", {name:"usrList", xtype:"ad_usr_dc_User$List"})
			.addDcFormView("usr", {name:"usrEdit", xtype:"ad_usr_dc_User$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnAsgnRoles"), this._elems_.get("btnAsgnGroups"), this._elems_.get("btnChangePassword"), this._elems_.get("btnCreateAssignable")]}]})
			.addDcFormView("usr", {name:"canvasPassword", preventHeader:true, isCanvas:true, xtype:"ad_usr_dc_User$ChangePasswordForm"})
			.addWindow({name:"wdwChangePassword", title:"Change password", closeAction:'hide', resizable:true, layout:"fit", modal:true,
				items:[this._elems_.get("canvasPassword")], 
						dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
							items:[ this._elems_.get("btnSavePassword")]}]})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["usrFilter", "usrList"], ["north", "center"])
			.addChildrenTo("canvas2", ["usrEdit"], ["center"])
			.addToolbarTo("canvas1", "tlbUsrList")
			.addToolbarTo("canvas2", "tlbUsrEdit")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbUsrList", {dc: "usr"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Users"})
			.end()
			.beginToolbar("tlbUsrEdit", {dc: "usr"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "User"})
			.end()
			;
	}

	
	,onBtnAsgnRoles: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui ,{dc: "usr", objectIdField: "id"});
	}
	
	,onBtnAsgnGroups: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$Ui ,{dc: "usr", objectIdField: "id"});
	}
	
	,onBtnChangePassword: function() {
		this._getWindow_("wdwChangePassword").show();
	}
	
	,onBtnSavePassword: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) {
				this._getWindow_("wdwChangePassword").close();
			};
		s.callbacks['successFn'] = successFn;
		s.callbacks['successScope'] = this;
		try{
			this._getDc_("usr").doService("changePassword", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnCreateAssignable: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("usr").doService("createAssignableResource", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
});
