/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.uom.frame.Uoms_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.uom.frame.Uoms_UI",
	_name_: "net.nan21.dnet.module.bd.uom.frame.Uoms_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("m", new net.nan21.dnet.module.bd.uom.dc.Uom({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("m", {name:"mFilter", height:80, xtype:"bd_uom_dc_Uom$Filter"})
			.addDcEditGridView("m", {name:"mEditList", xtype:"bd_uom_dc_Uom$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["mFilter", "mEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbMEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMEditList", {dc: "m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Units of measure"})
			.end()
			;
	}

});
