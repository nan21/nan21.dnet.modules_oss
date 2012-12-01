/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAttributeValue", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeValueDs",
	filterModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeValueDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAttributeValue$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_mm_prod_dc_ProductAttributeValue$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"value", dataIndex:"value", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"dataType", dataIndex:"dataType", anchor:"-20",
				store:[ "string", "text", "integer", "decimal", "boolean", "date"]
			})
			.addLov({xtype:"md_mm_prod_lovs_Products", name:"productCode", dataIndex:"productCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "productId"} 
				]})
			.addLov({xtype:"bd_attr_lovs_Attribute", name:"attribute", dataIndex:"attribute", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "attributeId"} 
				]})
			.addLov({xtype:"bd_attr_lovs_AttributeCategory", name:"category", dataIndex:"category", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "categoryId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:280, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["productCode", "attribute", "category"])
			.addChildrenTo("col2", ["dataType", "value"])
		;
	}
});


/* ================= FILTER: FilterCtx ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAttributeValue$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.md_mm_prod_dc_ProductAttributeValue$FilterCtx",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_attr_lovs_Attribute", name:"attribute", dataIndex:"attribute", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.bd.attr.lovs.Attribute", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "attributeId"} 
					]}})
			.addLov({xtype:"bd_attr_lovs_AttributeCategory", name:"category", dataIndex:"category", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.bd.attr.lovs.AttributeCategory", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "categoryId"} 
					]}})
		;
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAttributeValue$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_prod_dc_ProductAttributeValue$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"category", dataIndex:"category", width:120})
			.addTextColumn({name:"attribute", dataIndex:"attribute", hidden:true, width:120})
			.addTextColumn({name:"title", dataIndex:"title", width:200})
			.addTextColumn({name:"value", dataIndex:"value", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"uom", dataIndex:"uom", width:100})
			.addNumberColumn({name:"productId", dataIndex:"productId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	},
	
	/* ==================== Business functions ==================== */
	
	_getCustomCellEditor_: function(record,column) {
		
				var ed = null;
				
				if (!Ext.isEmpty(record.data.listOfvalues)) {
			    	ed = new dnet.core.lov.LocalCombo({store:record.data.listOfvalues.split(",")});
			    }
				else if (record.data.dataType == "integer" || record.data.dataType == "decimal") {
			    	ed = new Ext.form.field.Number({ });
			    }
			    else if (record.data.dataType == "date") {
			    	ed = new Ext.form.field.Date({});
			    }
			    else if (record.data.dataType == "boolean") {
			    	ed = new dnet.core.lov.LocalCombo({store:["true","false"]});
			    }
		 
			    if(ed){
				    ed._dcView_ =  this;
			    }
		
			    return ed
	}

});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAttributeValue$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_prod_dc_ProductAttributeValue$EditList",
	_noImport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"product", dataIndex:"productCode", width:150})
			.addTextColumn({name:"productName", dataIndex:"productName", width:250})
			.addTextColumn({name:"category", dataIndex:"category", width:120})
			.addTextColumn({name:"attribute", dataIndex:"attribute", hidden:true, width:120})
			.addTextColumn({name:"title", dataIndex:"title", width:200})
			.addTextColumn({name:"value", dataIndex:"value", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"uom", dataIndex:"uom", width:100})
			.addNumberColumn({name:"productId", dataIndex:"productId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	},
	
	/* ==================== Business functions ==================== */
	
	_getCustomCellEditor_: function(record,column) {
		
				var ed = null;
				
				if (!Ext.isEmpty(record.data.listOfvalues)) {
			    	ed = new dnet.core.lov.LocalCombo({store:record.data.listOfvalues.split(",")});
			    }
				else if (record.data.dataType == "integer" || record.data.dataType == "decimal") {
			    	ed = new Ext.form.field.Number({ });
			    }
			    else if (record.data.dataType == "date") {
			    	ed = new Ext.form.field.Date({});
			    }
			    else if (record.data.dataType == "boolean") {
			    	ed = new dnet.core.lov.LocalCombo({store:["true","false"]});
			    }
		 
			    if(ed){
				    ed._dcView_ =  this;
			    }
		
			    return ed;
	}

});
