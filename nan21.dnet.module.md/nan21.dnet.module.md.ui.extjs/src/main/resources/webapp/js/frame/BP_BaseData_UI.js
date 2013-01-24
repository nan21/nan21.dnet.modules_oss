/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI",
	_name_: "net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("custGroup", new net.nan21.dnet.module.md.bp.dc.CustomerGroup({multiEdit:true}))
			.addDc("custGroupAcct", new net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct({multiEdit:true}))
			.addDc("vendGroup", new net.nan21.dnet.module.md.bp.dc.VendorGroup({multiEdit:true}))
			.addDc("vendGroupAcct", new net.nan21.dnet.module.md.bp.dc.VendorGroupAcct({multiEdit:true}))
			.addDc("legalForm", new net.nan21.dnet.module.md.bp.dc.CompanyLegalForm({multiEdit:true}))
	
			.linkDc("custGroupAcct", "custGroup",{fields:[
				{childField:"custGroupId", parentField:"id"}]}
			)
			.linkDc("vendGroupAcct", "vendGroup",{fields:[
				{childField:"vendorGroupId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("custGroup", {name:"custGroupFilter", height:80, xtype:"md_bp_dc_CustomerGroup$Filter"})
			.addDcEditGridView("custGroup", {name:"custGroupEditList", xtype:"md_bp_dc_CustomerGroup$EditList", frame:true})
			.addDcEditGridView("custGroupAcct", {name:"custGroupAcctEditList", height:220, xtype:"md_bp_dc_CustomerGroupAcct$CtxEditList", frame:true})
			.addDcFilterFormView("vendGroup", {name:"vendGroupFilter", height:80, xtype:"md_bp_dc_VendorGroup$Filter"})
			.addDcEditGridView("vendGroup", {name:"vendGroupEditList", xtype:"md_bp_dc_VendorGroup$EditList", frame:true})
			.addDcEditGridView("vendGroupAcct", {name:"vendGroupAcctEditList", height:220, xtype:"md_bp_dc_VendorGroupAcct$CtxEditList", frame:true})
			.addDcFilterFormView("legalForm", {name:"legalFormFilter", height:80, xtype:"md_bp_dc_CompanyLegalForm$Filter"})
			.addDcEditGridView("legalForm", {name:"legalFormEditList", xtype:"md_bp_dc_CompanyLegalForm$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasCustGroup", title:"Customer groups", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasVendGroup", title:"Vendor groups", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasLegalForm", title:"Company legal form", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasLegalForm","canvasCustGroup","canvasVendGroup"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasLegalForm", "canvasCustGroup", "canvasVendGroup"])
			.addChildrenTo("canvasCustGroup", ["custGroupFilter", "custGroupEditList", "custGroupAcctEditList"], ["north", "center", "south"])
			.addChildrenTo("canvasVendGroup", ["vendGroupFilter", "vendGroupEditList", "vendGroupAcctEditList"], ["north", "center", "south"])
			.addChildrenTo("canvasLegalForm", ["legalFormFilter", "legalFormEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasCustGroup", "tlbCustGroup")
			.addToolbarTo("canvasVendGroup", "tlbVendGroup")
			.addToolbarTo("custGroupAcctEditList", "tlbCustGroupAcct")
			.addToolbarTo("vendGroupAcctEditList", "tlbVendGroupAcct")
			.addToolbarTo("canvasLegalForm", "tlblegalForm")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCustGroup", {dc: "custGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Customer groups"})
			.end()
			.beginToolbar("tlbVendGroup", {dc: "vendGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Vendor groups"})
			.end()
			.beginToolbar("tlbCustGroupAcct", {dc: "custGroupAcct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			.beginToolbar("tlbVendGroupAcct", {dc: "vendGroupAcct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			.beginToolbar("tlblegalForm", {dc: "legalForm"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Company legal form"})
			.end()
			;
	}

});
