/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.skill.frame.Qualification_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.skill.frame.Qualification_UI",
	_name_: "net.nan21.dnet.module.hr.skill.frame.Qualification_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("qualif", new net.nan21.dnet.module.hr.skill.dc.Qualification({multiEdit:true}))
			.addDc("skill", new net.nan21.dnet.module.hr.skill.dc.QualificationSkill({multiEdit:true}))
	
			.linkDc("skill", "qualif",{fields:[
				{childField:"qualificationId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("qualif", {name:"qualifFilter", height:40, xtype:"hr_skill_dc_Qualification$Filter"})
			.addDcEditGridView("qualif", {name:"qualifEditList", xtype:"hr_skill_dc_Qualification$EditList", frame:true})
			.addDcEditGridView("skill", {name:"skillCtxEditList", xtype:"hr_skill_dc_QualificationSkill$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"panelRequirements", width:500, layout:"accordion", activeItem:0})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["qualifFilter", "qualifEditList", "panelRequirements"], ["north", "center", "east"])
			.addChildrenTo("panelRequirements", ["skillCtxEditList"])
			.addToolbarTo("canvas1", "tlbQualifEditList")
			.addToolbarTo("skillCtxEditList", "tlbSkillCtxEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbQualifEditList", {dc: "qualif"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Qualifications"})
			.end()
			.beginToolbar("tlbSkillCtxEditList", {dc: "skill"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Required competences"})
			.end()
			;
	}

});
