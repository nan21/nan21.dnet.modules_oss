/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchyItem", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemDs"
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchyItem$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_org_dc_OrganizationHierarchyItem$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"org", dataIndex:"org", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_org_lovs_Organizations", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "orgId"} 
						]}})
			.addNumberColumn({name:"parentId", dataIndex:"parentId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"parentCode", dataIndex:"parentCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_org_lovs_OrganizationHierarchyItems", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"orgId", dsField: "parentId"} 
						],
						filterFieldMapping: [
							{lovField:"hierarchyId",dsField: "hierarchyId"} 
						]}})
			.addNumberColumn({name:"hierarchyId", dataIndex:"hierarchyId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"orgId", dataIndex:"orgId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
