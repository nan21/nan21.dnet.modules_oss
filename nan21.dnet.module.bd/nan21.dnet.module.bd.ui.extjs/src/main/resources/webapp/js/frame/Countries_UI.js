/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/ds/CountryDs", "nan21.dnet.module.bd.ui.extjs/dc/Country"]);

Ext.define("net.nan21.dnet.module.bd.geo.frame.Countries_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.geo.frame.Countries_UI",
	_name_: "net.nan21.dnet.module.bd.geo.frame.Countries_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("m", new net.nan21.dnet.module.bd.geo.dc.Country({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("m", {name:"mFilter", height:80, xtype:"bd_geo_dc_Country$Filter"})
			.addDcEditGridView("m", {name:"mEditList", xtype:"bd_geo_dc_Country$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["mFilter", "mEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbMEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMEditList", {dc: "m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Countries"})
			.end()
	}

});
