/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.skill.frame.RatingScale_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.skill.frame.RatingScale_UI",
	_name_: "net.nan21.dnet.module.hr.skill.frame.RatingScale_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("scale", new net.nan21.dnet.module.hr.skill.dc.RatingScale({multiEdit:true}))
			.addDc("level", new net.nan21.dnet.module.hr.skill.dc.RatingLevel({multiEdit:true}))
	
			.linkDc("level", "scale",{fields:[
				{childField:"ratingScaleId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("scale", {name:"scaleFilter", height:40, xtype:"hr_skill_dc_RatingScale$Filter"})
			.addDcEditGridView("scale", {name:"scaleList", xtype:"hr_skill_dc_RatingScale$EditList", frame:true})
			.addDcEditGridView("level", {name:"levelCtxEditList", height:250, xtype:"hr_skill_dc_RatingLevel$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["scaleFilter", "scaleList", "levelCtxEditList"], ["north", "center", "south"])
			.addToolbarTo("canvas1", "tlbScaleList")
			.addToolbarTo("levelCtxEditList", "tlbLevelCtxEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbScaleList", {dc: "scale"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Rating scales"})
			.end()
			.beginToolbar("tlbLevelCtxEditList", {dc: "level"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Proficiency levels"})
			.end()
			;
	}

});
