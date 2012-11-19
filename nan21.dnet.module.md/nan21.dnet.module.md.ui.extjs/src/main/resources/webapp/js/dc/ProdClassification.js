/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProdClassification", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProdClassificationDs",
	filterModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProdClassificationDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.prod.ds.param.ProdClassificationDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProdClassification$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_mm_prod_dc_ProdClassification$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"productCode", dataIndex:"productCode", anchor:"-20", maxLength:32})
			.addTextField({ name:"classificationSystem", dataIndex:"classificationSystem", anchor:"-20", maxLength:32})
			.addTextField({ name:"classificationCode", dataIndex:"classificationCode", anchor:"-20", maxLength:32})
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
			.addChildrenTo("col1", ["productCode"])
			.addChildrenTo("col2", ["classificationSystem", "classificationCode"])
		;
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProdClassification$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_prod_dc_ProdClassification$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"classificationSystem", dataIndex:"classificationSystem", xtype:"gridcolumn", width:150,
					editor:{xtype:"bd_standards_lovs_ClassificationSystems", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "classificationSystemId"} 
						],
						filterFieldMapping: [
							{lovField:"useInContext",value: "Product"} 
						]}})
			.addLov({name:"classificationCode", dataIndex:"classificationCode", xtype:"gridcolumn", width:150,
					editor:{xtype:"bd_standards_lovs_ClassificationItems", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "classificationId"} ,{lovField:"name", dsField: "classificationName"} 
						],
						filterFieldMapping: [
							{lovField:"classSystemId",dsField: "classificationSystemId"} 
						]}})
			.addTextColumn({name:"classificationName", dataIndex:"classificationName", width:300})
			.addNumberColumn({name:"classSystemId", dataIndex:"classificationSystemId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"classCodeId", dataIndex:"classificationId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
