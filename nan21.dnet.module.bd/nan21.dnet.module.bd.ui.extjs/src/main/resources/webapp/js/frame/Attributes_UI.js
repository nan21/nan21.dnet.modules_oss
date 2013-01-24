/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.attr.frame.Attributes_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.attr.frame.Attributes_UI",
	_name_: "net.nan21.dnet.module.bd.attr.frame.Attributes_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("attr", new net.nan21.dnet.module.bd.attr.dc.Attribute({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("attr", {name:"attrFilter", height:80, xtype:"bd_attr_dc_Attribute$Filter"})
			.addDcEditGridView("attr", {name:"attrEditList", xtype:"bd_attr_dc_Attribute$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasAttr", title:"Attributes", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasAttr"])
			.addChildrenTo("canvasAttr", ["attrFilter", "attrEditList"], ["north", "center"])
			.addToolbarTo("canvasAttr", "tlbAttrEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAttrEditList", {dc: "attr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Attributes"})
			.end()
			;
	}

});
