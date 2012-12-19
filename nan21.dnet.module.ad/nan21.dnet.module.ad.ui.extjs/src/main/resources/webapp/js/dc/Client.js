/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.client.dc.Client", {
	extend: "dnet.core.dc.AbstractDc",

	paramModel: "net.nan21.dnet.module.ad.client.ds.model.ClientDsParam",
	recordModel: "net.nan21.dnet.module.ad.client.ds.model.ClientDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.client.dc.Client$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_client_dc_Client$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"systemClient", dataIndex:"systemClient", anchor:"-20"})
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
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["systemClient"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.client.dc.Client$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_client_dc_Client$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
			.addTextColumn({ name:"maintenanceLanguage", dataIndex:"maintenanceLanguage", hidden:true, width:80})
			.addTextColumn({ name:"defaultImportPath", dataIndex:"defaultImportPath", hidden:true, width:200})
			.addTextColumn({ name:"defaultExportPath", dataIndex:"defaultExportPath", hidden:true, width:200})
			.addTextColumn({ name:"tempPath", dataIndex:"tempPath", hidden:true, width:200})
			.addBooleanColumn({ name:"systemClient", dataIndex:"systemClient"})
			.addTextColumn({ name:"adminRole", dataIndex:"adminRole", hidden:true, width:100})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.ad.client.dc.Client$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_client_dc_Client$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", allowBlank:false, anchor:"-20", maxLength:32})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20", height:60})
			.addTextField({ name:"defaultImportPath", dataIndex:"defaultImportPath", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"defaultExportPath", dataIndex:"defaultExportPath", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"tempPath", dataIndex:"tempPath", allowBlank:false, anchor:"-20"})
			.addBooleanField({ name:"systemClient", dataIndex:"systemClient", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:350, layout:"form"})
			.addPanel({ name:"col2", width:450, layout:"form", defaults:{labelAlign:"right", labelWidth:120}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "code", "notes", "systemClient"])
			.addChildrenTo("col2", ["defaultImportPath", "defaultExportPath", "tempPath"])
		;
	}
});


/* ================= EDITOR: Create ================= */


Ext.define("net.nan21.dnet.module.ad.client.dc.Client$Create", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_client_dc_Client$Create",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", allowBlank:false, anchor:"-20", maxLength:32})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20", height:60})
			.addTextField({ name:"defaultImportPath", dataIndex:"defaultImportPath", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"defaultExportPath", dataIndex:"defaultExportPath", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"tempPath", dataIndex:"tempPath", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"adminUserName", paramIndex:"adminUserName", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"adminUserCode", paramIndex:"adminUserCode", allowBlank:false, anchor:"-20", maxLength:32})
			.addTextField({ name:"adminPassword", paramIndex:"adminPassword", allowBlank:false, anchor:"-20"})
			.addBooleanField({ name:"systemClient", dataIndex:"systemClient", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:350, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:400, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code", "notes", "systemClient"])
			.addChildrenTo("col2", ["adminUserName", "adminUserCode", "adminPassword"])
			.addChildrenTo("col3", ["defaultImportPath", "defaultExportPath", "tempPath"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_shouldValidate_: function() {
		return this._controller_.record.phantom;
	}

});
