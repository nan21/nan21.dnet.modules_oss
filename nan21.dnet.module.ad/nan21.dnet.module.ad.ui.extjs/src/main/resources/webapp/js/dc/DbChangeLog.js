/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.system.dc.DbChangeLog", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.ad.system.ds.model.DbChangeLogDsFilter",
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.DbChangeLogDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.DbChangeLog$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_system_dc_DbChangeLog$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"author", dataIndex:"author", anchor:"-20"})
			.addTextField({ name:"liquibase", dataIndex:"liquibase", anchor:"-20"})
			.addTextField({ name:"filename", dataIndex:"filename", anchor:"-20"})
			.addTextField({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addTextField({ name:"txid", dataIndex:"txid", width:100})
			.addDateField({name:"dateExecuted_From", dataIndex:"dateExecuted_From", emptyText:"From" })
			.addDateField({name:"dateExecuted_To", dataIndex:"dateExecuted_To", emptyText:"To" })
			.addFieldContainer({name: "dateExecuted", fieldLabel:"Date Executed"})
				.addChildrenTo("dateExecuted",["dateExecuted_From", "dateExecuted_To"])
			.addNumberField({name:"orderExecuted_From", dataIndex:"orderExecuted_From", emptyText:"From" })
			.addNumberField({name:"orderExecuted_To", dataIndex:"orderExecuted_To", emptyText:"To" })
			.addFieldContainer({name: "orderExecuted", fieldLabel:"Order Executed"})
				.addChildrenTo("orderExecuted",["orderExecuted_From", "orderExecuted_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:290, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["liquibase", "txid", "author"])
			.addChildrenTo("col2", ["filename", "description"])
			.addChildrenTo("col3", ["dateExecuted", "orderExecuted"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.DbChangeLog$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_system_dc_DbChangeLog$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"liquibase", dataIndex:"liquibase", width:80})
			.addTextColumn({ name:"txid", dataIndex:"txid", width:100})
			.addTextColumn({ name:"author", dataIndex:"author", width:100})
			.addTextColumn({ name:"filename", dataIndex:"filename", width:200})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addDateColumn({ name:"dateExecuted", dataIndex:"dateExecuted", format: Dnet.DATETIME_FORMAT})
			.addNumberColumn({ name:"orderExecuted", dataIndex:"orderExecuted"})
			.addTextColumn({ name:"tag", dataIndex:"tag", width:200})
			.addTextColumn({ name:"md5sum", dataIndex:"md5sum", width:200})
			.addTextColumn({ name:"comments", dataIndex:"comments", hidden:true, width:200})
			.addDefaults();
	}
});
