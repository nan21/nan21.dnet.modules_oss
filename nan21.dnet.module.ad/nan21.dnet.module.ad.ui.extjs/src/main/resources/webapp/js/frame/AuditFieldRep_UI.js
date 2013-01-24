/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.system.frame.AuditFieldRep_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.system.frame.AuditFieldRep_UI",
	_name_: "net.nan21.dnet.module.ad.system.frame.AuditFieldRep_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("audit", new net.nan21.dnet.module.ad.system.dc.AuditFieldRep({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("audit", {name:"auditFilter", xtype:"ad_system_dc_AuditFieldRep$Filter"})
			.addDcGridView("audit", {name:"auditList", xtype:"ad_system_dc_AuditFieldRep$List"})
			.addPanel({name:"main", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["auditFilter", "auditList"], ["north", "center"])
			.addToolbarTo("main", "tlbAuditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAuditList", {dc: "audit"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Audit trails"})
			.end()
			;
	}

});
