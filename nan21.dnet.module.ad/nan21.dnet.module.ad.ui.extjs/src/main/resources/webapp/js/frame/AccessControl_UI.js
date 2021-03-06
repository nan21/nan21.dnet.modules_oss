/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.usr.frame.AccessControl_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.frame.AccessControl_UI",
	_name_: "net.nan21.dnet.module.ad.usr.frame.AccessControl_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("ctrl", new net.nan21.dnet.module.ad.usr.dc.AccessControl({multiEdit:true}))
			.addDc("dsAccess", new net.nan21.dnet.module.ad.usr.dc.DsAccessControl({multiEdit:true}))
			.addDc("asgnAccess", new net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl({multiEdit:true}))
			.addDc("dsMtdAccess", new net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl({multiEdit:true}))
	
			.linkDc("dsAccess", "ctrl",{fetchMode:"auto",fields:[
				{childField:"accessControlId", parentField:"id"}]}
			)
			.linkDc("asgnAccess", "ctrl",{fetchMode:"auto",fields:[
				{childField:"accessControlId", parentField:"id"}]}
			)
			.linkDc("dsMtdAccess", "ctrl",{fetchMode:"auto",fields:[
				{childField:"accessControlId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnAsgnRoleToAccessCtrl", text:"Roles", tooltip:"Assign selected privilege to roles", disabled:true,
					handler: this.onBtnAsgnRoleToAccessCtrl, scope:this, stateManager:{name:"selected_one_clean", dc:"ctrl" }})
			.addButton({name:"btnShowUiAsgnRules", text:"ASGN rules", tooltip:"Open assignment rules frame", disabled:false,
					handler: this.onBtnShowUiAsgnRules, scope:this})
			.addButton({name:"btnShowUiDsRules", text:"DS rules", tooltip:"Open data-source rules frame", disabled:false,
					handler: this.onBtnShowUiDsRules, scope:this})
			.addButton({name:"btnCopyRules", text:"Copy rules", tooltip:"Copy rules from another privilege", disabled:true,
					handler: this.onBtnCopyRules, scope:this, stateManager:{name:"selected_one_clean", dc:"ctrl" }})
			.addButton({name:"btnCopyRulesExec", text:"OK", tooltip:"Copy rules from selected privilege", disabled:false,
					handler: this.onBtnCopyRulesExec, scope:this})
			
			.addDcFilterFormView("ctrl", {name:"privilegeFilter", xtype:"ad_usr_dc_AccessControl$Filter"})
			.addDcEditGridView("ctrl", {name:"privilegeEditList", width:600, xtype:"ad_usr_dc_AccessControl$EditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnAsgnRoleToAccessCtrl"), this._elems_.get("btnCopyRules"), this._elems_.get("btnShowUiDsRules"), this._elems_.get("btnShowUiAsgnRules")]}]})
			.addDcFormView("ctrl", {name:"privilegeCopyRules", xtype:"ad_usr_dc_AccessControl$CopyRulesFromSource"})
			.addDcEditGridView("dsAccess", {name:"dsAccessCtxEditList", title:"Data-source", xtype:"ad_usr_dc_DsAccessControl$CtxEditList", frame:true})
			.addDcEditGridView("asgnAccess", {name:"asgnAccessCtxEditList", title:"Assignment", xtype:"ad_usr_dc_AsgnAccessControl$CtxEditList", frame:true})
			.addDcEditGridView("dsMtdAccess", {name:"dsMtdAccessCtxEditList", title:"Methods", xtype:"ad_usr_dc_DsMethodAccessControl$CtxEditList", frame:true})
			.addWindow({name:"wdwCopyRules", title:"Select source", width:400, height:180, closeAction:'hide', resizable:true, layout:"fit", modal:true,
				items:[this._elems_.get("privilegeCopyRules")], 
						dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
							items:[ this._elems_.get("btnCopyRulesExec")]}]})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"detailTabs", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["privilegeFilter", "privilegeEditList", "detailTabs"], ["north", "west", "center"])
			.addChildrenTo("detailTabs", ["dsAccessCtxEditList", "asgnAccessCtxEditList", "dsMtdAccessCtxEditList"])
			.addToolbarTo("canvas1", "tlbCtrlEditList")
			.addToolbarTo("dsAccessCtxEditList", "tlbDsAccessCtxEditList")
			.addToolbarTo("asgnAccessCtxEditList", "tlbAsgnAccessCtxEditList")
			.addToolbarTo("dsMtdAccessCtxEditList", "tlbDsMtdAccessCtxEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCtrlEditList", {dc: "ctrl"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Privileges"})
			.end()
			.beginToolbar("tlbDsAccessCtxEditList", {dc: "dsAccess"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "DS rules"})
			.end()
			.beginToolbar("tlbAsgnAccessCtxEditList", {dc: "asgnAccess"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "ASGN rules"})
			.end()
			.beginToolbar("tlbDsMtdAccessCtxEditList", {dc: "dsMtdAccess"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "DS Methods"})
			.end()
			;
	}

	
	,onBtnAsgnRoleToAccessCtrl: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$Ui ,{dc: "ctrl", objectIdField: "id"});
	}
	
	,onBtnShowUiAsgnRules: function() {
		var bundle = "nan21.dnet.module.ad.ui.extjs";
		var frame = "net.nan21.dnet.module.ad.usr.frame.AsgnAccessControl_UI";
		getApplication().showFrameByName(bundle, frame);
	}
	
	,onBtnShowUiDsRules: function() {
		var bundle = "nan21.dnet.module.ad.ui.extjs";
		var frame = "net.nan21.dnet.module.ad.usr.frame.DsAccessControl_UI";
		getApplication().showFrameByName(bundle, frame);
	}
	
	,onBtnCopyRules: function() {
		this._getWindow_("wdwCopyRules").show();
	}
	
	,onBtnCopyRulesExec: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) {
				this._getWindow_("wdwCopyRules").close();
				this._getDc_("dsAccess").doQuery();
				this._getDc_("asgnAccess").doQuery();
			};
		s.callbacks['successFn'] = successFn;
		s.callbacks['successScope'] = this;
		try{
			this._getDc_("ctrl").doService("copyRulesFromAccessControl", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
});
