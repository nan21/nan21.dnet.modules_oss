/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.geo.frame.CountryMD_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.geo.frame.CountryMD_UI",
	_name_: "net.nan21.dnet.module.bd.geo.frame.CountryMD_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("country", new net.nan21.dnet.module.bd.geo.dc.Country({}))
			.addDc("region", new net.nan21.dnet.module.bd.geo.dc.Region({multiEdit:true}))
	
			.linkDc("region", "country",{fields:[
				{childField:"countryId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("country", {name:"countryFilter", height:80, xtype:"bd_geo_dc_Country$Filter"})
			.addDcGridView("country", {name:"countryList", xtype:"bd_geo_dc_Country$List"})
			.addDcFormView("country", {name:"countryEdit", height:140, xtype:"bd_geo_dc_Country$Edit"})
			.addDcEditGridView("region", {name:"regionEditList", xtype:"bd_geo_dc_Region$EditListContext", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["countryFilter", "countryList"], ["north", "center"])
			.addChildrenTo("canvas2", ["countryEdit", "regionEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbCountryList")
			.addToolbarTo("canvas2", "tlbCountryEdit")
			.addToolbarTo("regionEditList", "tlbRegionList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCountryList", {dc: "country"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Countries"})
			.end()
			.beginToolbar("tlbCountryEdit", {dc: "country"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Country"})
			.end()
			.beginToolbar("tlbRegionList", {dc: "region"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Regions"})
			.end()
			;
	}

});
