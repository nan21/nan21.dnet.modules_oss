/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.skill.frame.SkillType_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.skill.frame.SkillType_UI",
	_name_: "net.nan21.dnet.module.hr.skill.frame.SkillType_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("scateg", new net.nan21.dnet.module.hr.skill.dc.SkillCategory({multiEdit:true}))
			.addDc("stype", new net.nan21.dnet.module.hr.skill.dc.SkillType({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("scateg", {name:"scategFilter", height:80, xtype:"hr_skill_dc_SkillCategory$Filter"})
			.addDcEditGridView("scateg", {name:"scategEditList", xtype:"hr_skill_dc_SkillCategory$EditList", frame:true})
			.addDcFilterFormView("stype", {name:"stypeFilter", height:80, xtype:"hr_skill_dc_SkillType$Filter"})
			.addDcEditGridView("stype", {name:"stypeEditList", xtype:"hr_skill_dc_SkillType$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasCateg", title:"Categories", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasType", title:"Types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasType","canvasCateg"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasType", "canvasCateg"])
			.addChildrenTo("canvasCateg", ["scategFilter", "scategEditList"], ["north", "center"])
			.addChildrenTo("canvasType", ["stypeFilter", "stypeEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasCateg", "tlbscateg")
			.addToolbarTo("canvasType", "tlbstype")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbscateg", {dc: "scateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Categories"})
			.end()
			.beginToolbar("tlbstype", {dc: "stype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Types"})
			.end()
			;
	}

});
