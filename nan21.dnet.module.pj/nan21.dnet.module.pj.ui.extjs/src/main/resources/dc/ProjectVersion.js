/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.ProjectVersionDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.pj_md_dc_ProjectVersion$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"pj_md_lovs_Projects", name:"project", dataIndex:"project", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "projectId"} 
				]})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addDateField({name:"planDate_From", dataIndex:"planDate_From", emptyText:"From" })
			.addDateField({name:"planDate_To", dataIndex:"planDate_To", emptyText:"To" })
			.addFieldContainer({name: "planDate", fieldLabel:"Plan Date"})
				.addChildrenTo("planDate",["planDate_From", "planDate_To"])
			.addDateField({name:"releaseDate_From", dataIndex:"releaseDate_From", emptyText:"From" })
			.addDateField({name:"releaseDate_To", dataIndex:"releaseDate_To", emptyText:"To" })
			.addFieldContainer({name: "releaseDate", fieldLabel:"Release Date"})
				.addChildrenTo("releaseDate",["releaseDate_From", "releaseDate_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["project", "name", "active"])
			.addChildrenTo("col2", ["planDate", "releaseDate"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.pj_md_dc_ProjectVersion$EditList",
	_bulkEditFields_: ["planDate","active","description"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"project", dataIndex:"project", xtype:"gridcolumn", width:100,
					editor:{xtype:"pj_md_lovs_Projects", selectOnFocus:true, noUpdate:true,
						retFieldMapping: [
							{lovField:"id", dsField: "projectId"} 
						]}})
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"planDate", dataIndex:"planDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"releaseDate", dataIndex:"releaseDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"projectId", dataIndex:"projectId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.pj_md_dc_ProjectVersion$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"project", dataIndex:"project", hidden:true, width:100})
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"planDate", dataIndex:"planDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"releaseDate", dataIndex:"releaseDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"projectId", dataIndex:"projectId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
