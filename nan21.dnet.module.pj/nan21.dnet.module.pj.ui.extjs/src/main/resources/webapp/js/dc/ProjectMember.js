/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectMember", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectMemberDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectMember$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.pj_md_dc_ProjectMember$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"project", dataIndex:"project", anchor:"-20", maxLength:32})
			.addTextField({ name:"role", dataIndex:"role", anchor:"-20"})
			.addTextField({ name:"member", dataIndex:"member", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["project"])
			.addChildrenTo("col2", ["role", "member"])
		;
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectMember$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.pj_md_dc_ProjectMember$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"project", dataIndex:"project", hidden:true, width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"member", dataIndex:"member", xtype:"gridcolumn", width:150,
					editor:{xtype:"ad_usr_lovs_Assignables", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "memberId"} 
						]}})
			.addLov({name:"role", dataIndex:"role", xtype:"gridcolumn", width:150,
					editor:{xtype:"pj_base_lovs_ProjectRoles", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "roleId"} 
						]}})
			.addNumberColumn({name:"roleId", dataIndex:"roleId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"memberId", dataIndex:"memberId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
