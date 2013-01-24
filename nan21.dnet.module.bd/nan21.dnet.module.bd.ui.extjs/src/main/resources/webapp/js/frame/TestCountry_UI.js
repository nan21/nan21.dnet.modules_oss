/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.geo.frame.TestCountry_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.geo.frame.TestCountry_UI",
	_name_: "net.nan21.dnet.module.bd.geo.frame.TestCountry_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("country", new net.nan21.dnet.module.bd.geo.dc.Country({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("country", {name:"countryFilter", height:120, xtype:"bd_geo_dc_Country$Filter"})
			.addDcFilterFormView("country", {name:"countryFilterPG", width:300, xtype:"bd_geo_dc_Country$FilterPG"})
			.addDcGridView("country", {name:"countryList", title:"Grid", xtype:"bd_geo_dc_Country$List"})
			.addDcEditGridView("country", {name:"countryEditList", title:"Edit-Grid", xtype:"bd_geo_dc_Country$EditList", frame:true})
			.addDcFormView("country", {name:"countryEdit", height:120, xtype:"bd_geo_dc_Country$Edit"})
			.addDcFormView("country", {name:"countryEditPG", width:300, xtype:"bd_geo_dc_Country$EditPG"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"gridTabs", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["countryFilter", "gridTabs", "countryEdit", "countryEditPG", "countryFilterPG"], ["north", "center", "south", "east", "west"])
			.addChildrenTo("gridTabs", ["countryList", "countryEditList"])
			.addToolbarTo("canvas1", "tlbList")
			.addToolbarTo("countryEdit", "tlbEdit")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbList", {dc: "country"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Countries"})
			.end()
			.beginToolbar("tlbEdit", {dc: "country"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Country"})
			.end()
			;
	}

});
