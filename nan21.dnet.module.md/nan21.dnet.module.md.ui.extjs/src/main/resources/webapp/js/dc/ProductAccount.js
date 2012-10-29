/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccount", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountDs",
	filterModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.prod.ds.param.ProductAccountDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_mm_prod_dc_ProductAccount$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addLov({xtype:"md_mm_prod_lovs_ProductAccountGroups", name:"groupCode", dataIndex:"groupCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "groupId"} 
				]})
			.addTextField({ name:"productCode", dataIndex:"productCode", anchor:"-20", maxLength:32})
			.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment", anchor:"-20", maxLength:32})
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
			.addChildrenTo("col1", ["org", "productCode"])
			.addChildrenTo("col2", ["groupCode", "analiticSegment"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccount$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_prod_dc_ProductAccount$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"org", dataIndex:"org", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_org_lovs_LegalEntityOrganizations", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "orgId"} 
						]}})
			.addLov({name:"groupCode", dataIndex:"groupCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_mm_prod_lovs_ProductAccountGroups", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "groupId"} 
						]}})
			.addTextColumn({name:"productCode", dataIndex:"productCode", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"analiticSegment", dataIndex:"analiticSegment", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"orgId", dataIndex:"orgId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"groupId", dataIndex:"groupId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"productId", dataIndex:"productId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccount$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_prod_dc_ProductAccount$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"org", dataIndex:"org", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_org_lovs_LegalEntityOrganizations", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "orgId"} 
						]}})
			.addLov({name:"groupCode", dataIndex:"groupCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_mm_prod_lovs_ProductAccountGroups", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "groupId"} 
						]}})
			.addTextColumn({name:"analiticSegment", dataIndex:"analiticSegment", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"orgId", dataIndex:"orgId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"groupId", dataIndex:"groupId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"productId", dataIndex:"productId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
