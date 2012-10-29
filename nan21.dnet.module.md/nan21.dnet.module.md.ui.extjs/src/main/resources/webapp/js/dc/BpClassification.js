/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.dc.BpClassification", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.bp.ds.model.BpClassificationDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.BpClassificationDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.BpClassificationDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BpClassification$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_bp_dc_BpClassification$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"businessPartner", dataIndex:"businessPartner", anchor:"-20", maxLength:32})
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
			.addChildrenTo("col1", ["businessPartner"])
			.addChildrenTo("col2", ["classificationSystem", "classificationCode"])
		;
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BpClassification$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_bp_dc_BpClassification$CtxEditList",
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
							{lovField:"useInContext",dsField: "businessPartnerBO"} 
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
