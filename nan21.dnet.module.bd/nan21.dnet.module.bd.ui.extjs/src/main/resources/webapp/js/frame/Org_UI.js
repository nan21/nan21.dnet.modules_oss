/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/lov/Regions", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationTypeDs", "nan21.dnet.module.bd.ui.extjs/lov/Calendars", "nan21.dnet.module.bd.ui.extjs/dc/Organization", "nan21.dnet.module.bd.ui.extjs/dc/OrganizationHierarchyItem", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationHierarchyItemLovDs", "nan21.dnet.module.bd.ui.extjs/dc/Location", "nan21.dnet.module.bd.ui.extjs/dc/OrganizationHierarchy", "nan21.dnet.module.bd.ui.extjs/ds/CalendarLovDs", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationLovDs", "nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationHierarchyDs", "nan21.dnet.module.bd.ui.extjs/lov/OrganizationHierarchyItems", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationDs", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.bd.ui.extjs/lov/Organizations", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationHierarchyItemDs", "nan21.dnet.module.bd.ui.extjs/lov/OrganizationTypes", "nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs", "nan21.dnet.module.bd.ui.extjs/dc/OrganizationType", "nan21.dnet.module.bd.ui.extjs/lov/Countries", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationTypeLovDs"]);

Ext.define("net.nan21.dnet.module.bd.org.frame.Org_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.org.frame.Org_UI",
	_name_: "net.nan21.dnet.module.bd.org.frame.Org_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("org", new net.nan21.dnet.module.bd.org.dc.Organization({}))
			.addDc("address", new net.nan21.dnet.module.bd.geo.dc.Location({}))
			.addDc("hierarchy", new net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy({}))
			.addDc("items", new net.nan21.dnet.module.bd.org.dc.OrganizationHierarchyItem({multiEdit:true}))
			.addDc("orgtype", new net.nan21.dnet.module.bd.org.dc.OrganizationType({multiEdit:true}))
	
			.linkDc("address", "org",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
			.linkDc("items", "hierarchy",{fields:[
				{childField:"hierarchyId", parentField:"id"}]}
			)
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("org", {name:"orgFilter", height:80, xtype:"bd_org_dc_Organization$Filter"})
			.addDcGridView("org", {name:"orgList", xtype:"bd_org_dc_Organization$List"})
			.addDcFormView("org", {name:"orgEdit", height:160, xtype:"bd_org_dc_Organization$Edit"})
			.addDcFilterFormView("hierarchy", {name:"hierarchyFilter", height:80, xtype:"bd_org_dc_OrganizationHierarchy$Filter"})
			.addDcGridView("hierarchy", {name:"hierarchyList", xtype:"bd_org_dc_OrganizationHierarchy$List"})
			.addDcFormView("hierarchy", {name:"hierarchyEdit", height:100, xtype:"bd_org_dc_OrganizationHierarchy$Edit"})
			.addDcFilterFormView("orgtype", {name:"orgtypeFilter", height:120, xtype:"bd_org_dc_OrganizationType$Filter"})
			.addDcEditGridView("orgtype", {name:"orgtypeEditList", xtype:"bd_org_dc_OrganizationType$EditList", frame:true})
			.addDcGridView("address", {name:"addressList", xtype:"bd_geo_dc_Location$ListCtx"})
			.addDcFormView("address", {name:"addressEdit", xtype:"bd_geo_dc_Location$EditCtx"})
			.addDcEditGridView("items", {name:"itemsEditList", xtype:"bd_org_dc_OrganizationHierarchyItem$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasOrg", title:"Organizations", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasOrgEdit", title:"Organization", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasHierarchy", title:"Hierarchies", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"panelHierarchy", layout:"card", activeItem:0})
			.addPanel({name:"panelHierarchyList", layout:"border", defaults:{split:true}})
			.addPanel({name:"panelHierarchyEdit", layout:"border", defaults:{split:true}})
			.addPanel({name:"addressPanel", layout:"card", activeItem:0})
			.addPanel({name:"addressEditWrapper", layout:"fit"})
			.addPanel({name:"canvasOrgType", title:"Organization types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasOrg","canvasHierarchy","canvasOrgType"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasOrg", "canvasOrgEdit", "canvasHierarchy", "canvasOrgType"])
			.addChildrenTo("canvasOrg", ["orgFilter", "orgList"], ["north", "center"])
			.addChildrenTo("canvasOrgEdit", ["orgEdit", "addressPanel"], ["north", "center"])
			.addChildrenTo("canvasHierarchy", ["panelHierarchy"], ["center"])
			.addChildrenTo("panelHierarchy", ["panelHierarchyList", "panelHierarchyEdit"])
			.addChildrenTo("panelHierarchyList", ["hierarchyFilter", "hierarchyList"], ["north", "center"])
			.addChildrenTo("panelHierarchyEdit", ["hierarchyEdit", "itemsEditList"], ["north", "center"])
			.addChildrenTo("addressPanel", ["addressList", "addressEditWrapper"])
			.addChildrenTo("addressEditWrapper", ["addressEdit"])
			.addChildrenTo("canvasOrgType", ["orgtypeFilter", "orgtypeEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasOrg", "tlbOrgList")
			.addToolbarTo("canvasOrgEdit", "tlbOrgEdit")
			.addToolbarTo("panelHierarchyList", "tlbHierarchyList")
			.addToolbarTo("panelHierarchyEdit", "tlbHierarchyEdit")
			.addToolbarTo("itemsEditList", "tlbItemsEditList")
			.addToolbarTo("canvasOrgType", "tlbOrgtypeList")
			.addToolbarTo("addressList", "tlbAddressList")
			.addToolbarTo("addressEditWrapper", "tlbAddressEdit")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrgList", {dc: "org"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Organizations"})
			.end()
			.beginToolbar("tlbOrgEdit", {dc: "org"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Organization"})
			.end()
			.beginToolbar("tlbHierarchyList", {dc: "hierarchy"}).addQuery(
			).addEdit(
			{inContainer:"panelHierarchy",showView:"panelHierarchyEdit"}
			).addNew(
			).addCopy(
			).addDeleteSelected(
			)
			.addReports().addSeparator().addSeparator().addTitle({text: "Hierarchies"})
			.end()
			.beginToolbar("tlbHierarchyEdit", {dc: "hierarchy"}).addBack(
			{inContainer:"panelHierarchy",showView:"panelHierarchyList"}
			).addSave(
			).addNew(
			).addCopy(
			).addCancel(
			).addPrevRec(
			).addNextRec(
			)
			.addReports().addSeparator().addSeparator().addTitle({text: "Hierarchy"})
			.end()
			.beginToolbar("tlbItemsEditList", {dc: "items"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports()
			.end()
			.beginToolbar("tlbOrgtypeList", {dc: "orgtype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Organization types"})
			.end()
			.beginToolbar("tlbAddressList", {dc: "address"}).addQuery(
			).addEdit(
			{inContainer:"addressPanel",showView:"addressEditWrapper"}
			).addNew(
			).addCopy(
			).addDeleteSelected(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Addresses"})
			.end()
			.beginToolbar("tlbAddressEdit", {dc: "address"}).addBack(
			{inContainer:"addressPanel",showView:"addressList"}
			).addSave(
			).addNew(
			).addCopy(
			).addCancel(
			).addPrevRec(
			).addNextRec(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Address"})
			.end()
	}

});
