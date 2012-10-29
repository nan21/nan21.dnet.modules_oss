/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/lov/ClassificationSystems", "nan21.dnet.module.bd.ui.extjs/dc/ClassificationCode", "nan21.dnet.module.bd.ui.extjs/ds/ClassificationItemDs", "nan21.dnet.module.bd.ui.extjs/ds/ClassificationSystemDs", "nan21.dnet.module.bd.ui.extjs/dc/ClassificationSystem", "nan21.dnet.module.bd.ui.extjs/ds/ClassificationSystemLovDs"]);

Ext.define("net.nan21.dnet.module.bd.standards.frame.Classifications_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.standards.frame.Classifications_UI",
	_name_: "net.nan21.dnet.module.bd.standards.frame.Classifications_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("classsys", new net.nan21.dnet.module.bd.standards.dc.ClassificationSystem({multiEdit:true}))
			.addDc("classcode", new net.nan21.dnet.module.bd.standards.dc.ClassificationCode({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("classsys", {name:"classsysFilter", height:120, xtype:"bd_standards_dc_ClassificationSystem$Filter"})
			.addDcEditGridView("classsys", {name:"classsysEditList", xtype:"bd_standards_dc_ClassificationSystem$EditList", frame:true})
			.addDcFilterFormView("classcode", {name:"classcodeFilter", height:80, xtype:"bd_standards_dc_ClassificationCode$Filter"})
			.addDcEditGridView("classcode", {name:"classcodeEditList", xtype:"bd_standards_dc_ClassificationCode$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasClasssys", title:"Classification systems", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasClasscode", title:"Classification codes", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasClasssys","canvasClasscode"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasClasssys", "canvasClasscode"])
			.addChildrenTo("canvasClasssys", ["classsysFilter", "classsysEditList"], ["north", "center"])
			.addChildrenTo("canvasClasscode", ["classcodeFilter", "classcodeEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasClasssys", "tlbClasssysEditList")
			.addToolbarTo("canvasClasscode", "tlbClasscodeEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbClasssysEditList", {dc: "classsys"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Classification systems"})
			.end()
			.beginToolbar("tlbClasscodeEditList", {dc: "classcode"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Classification codes"})
			.end()
	}

});
