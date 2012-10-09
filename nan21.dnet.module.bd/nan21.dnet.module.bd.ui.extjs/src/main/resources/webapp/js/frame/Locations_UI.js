/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs", "nan21.dnet.module.bd.ui.extjs/lov/Regions", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs", "nan21.dnet.module.bd.ui.extjs/dc/Location", "nan21.dnet.module.bd.ui.extjs/lov/Countries"]);

Ext.define("net.nan21.dnet.module.bd.geo.frame.Locations_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.geo.frame.Locations_UI",
	_name_: "net.nan21.dnet.module.bd.geo.frame.Locations_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("location", new net.nan21.dnet.module.bd.geo.dc.Location({}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("location", {name:"locationFilter", xtype:"bd_geo_dc_Location$Filter"})	
			.addDcGridView("location", {name:"locationListCtx", xtype:"bd_geo_dc_Location$ListCtx"})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["locationFilter", "locationListCtx"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbLocationListCtx")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbLocationListCtx", {dc: "location"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Addresses"})
			.end()
	}

});
