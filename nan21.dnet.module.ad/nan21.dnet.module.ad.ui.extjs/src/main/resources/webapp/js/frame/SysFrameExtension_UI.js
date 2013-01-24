/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.system.frame.SysFrameExtension_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.system.frame.SysFrameExtension_UI",
	_name_: "net.nan21.dnet.module.ad.system.frame.SysFrameExtension_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("extensions", new net.nan21.dnet.module.ad.system.dc.SysFrameExtension({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("extensions", {name:"extensionsFilter", xtype:"ad_system_dc_SysFrameExtension$Filter"})
			.addDcEditGridView("extensions", {name:"extensionsEditList", xtype:"ad_system_dc_SysFrameExtension$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["extensionsFilter", "extensionsEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbExtensionsEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbExtensionsEditList", {dc: "extensions"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Frame extensions"})
			.end()
			;
	}

});
