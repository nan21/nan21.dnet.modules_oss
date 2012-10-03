/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.skill.dc.Qualification", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.QualificationDs",
	filterModel: "net.nan21.dnet.module.hr.skill.ds.model.QualificationDsFilter",
	paramModel: "net.nan21.dnet.module.hr.skill.ds.param.QualificationDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.Qualification$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_skill_dc_Qualification$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"hbox",
				defaults:{
					labelAlign:"right", labelWidth:80, width:210 
				}
			})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			this._elems_.get("main")["items"] = [
				{layout:"anchor", border:false, items:[this._elems_.get("name")]},{layout:"anchor", border:false, items:[this._elems_.get("active")]}
			 ];
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.hr.skill.dc.Qualification$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_skill_dc_Qualification$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}});
