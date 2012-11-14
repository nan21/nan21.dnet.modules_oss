/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/ds/SkillDs", "nan21.dnet.module.hr.ui.extjs/lov/SkillTypes", "nan21.dnet.module.hr.ui.extjs/ds/RatingScaleLovDs", "nan21.dnet.module.hr.ui.extjs/dc/Skill", "nan21.dnet.module.hr.ui.extjs/ds/SkillTypeLovDs", "nan21.dnet.module.hr.ui.extjs/lov/RatingScales"]);

Ext.define("net.nan21.dnet.module.hr.skill.frame.Skill_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.skill.frame.Skill_UI",
	_name_: "net.nan21.dnet.module.hr.skill.frame.Skill_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("m", new net.nan21.dnet.module.hr.skill.dc.Skill({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("m", {name:"mFilter", height:80, xtype:"hr_skill_dc_Skill$Filter"})
			.addDcEditGridView("m", {name:"mEditList", xtype:"hr_skill_dc_Skill$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["mFilter", "mEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlb")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlb", {dc: "m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Skills"})
			.end()
			;
	}

});
