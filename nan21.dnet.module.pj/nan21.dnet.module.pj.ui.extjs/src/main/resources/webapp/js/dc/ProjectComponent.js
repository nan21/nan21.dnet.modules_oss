/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectComponent", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectComponentDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectComponentDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.ProjectComponentDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectComponent$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.pj_md_dc_ProjectComponent$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextField({ name:"project", dataIndex:"project", anchor:"-20", maxLength:32})
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
			.addChildrenTo("main", [
				{layout:"anchor", border:false, items:[this._elems_.get("name")]},{layout:"anchor", border:false, items:[this._elems_.get("project")]},{layout:"anchor", border:false, items:[this._elems_.get("active")]}
			 ])
		;
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectComponent$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.pj_md_dc_ProjectComponent$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"project", dataIndex:"project", hidden:true, width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"projectId", dataIndex:"projectId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
