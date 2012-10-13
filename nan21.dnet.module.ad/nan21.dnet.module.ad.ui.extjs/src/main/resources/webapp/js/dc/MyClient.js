/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.client.dc.MyClient", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.client.ds.model.MyClientDs",
	filterModel: "net.nan21.dnet.module.ad.client.ds.model.MyClientDsFilter",
	paramModel: "net.nan21.dnet.module.ad.client.ds.param.MyClientDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.ad.client.dc.MyClient$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_client_dc_MyClient$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addTextField({ name:"maintenanceLanguage", dataIndex:"maintenanceLanguage", anchor:"-20", maxLength:5, caseRestriction:"uppercase"})
			.addTextField({ name:"adminRole", dataIndex:"adminRole", allowBlank:false, anchor:"-20", maxLength:32})
			.addDisplayFieldDate({ name:"createdAt", _sharedLabel_:true, dataIndex:"createdAt", anchor:"-20" })
			.addDisplayFieldDate({ name:"modifiedAt", _sharedLabel_:true, dataIndex:"modifiedAt", anchor:"-20" })
			.addDisplayFieldText({ name:"createdBy", _sharedLabel_:true, dataIndex:"createdBy", anchor:"-20", maxLength:32})
			.addDisplayFieldText({ name:"modifiedBy", _sharedLabel_:true, dataIndex:"modifiedBy", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:350, layout:"form"})
			.addPanel({ name:"col3", width:220, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col3"])
			.addChildrenTo("col1", ["name", "code", "notes", "adminRole"])
			.addChildrenTo("col3", ["createdAt", "modifiedAt", "createdBy", "modifiedBy"])
		;
	}});
