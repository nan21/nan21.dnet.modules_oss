/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.contact.dc.CommunicationChannel", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelDs",
	filterModel: "net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_contact_dc_CommunicationChannel$EditList",
	_noImport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_contact_lovs_CommunicationChannelTypes", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "typeId"} 
						]}})
			.addTextColumn({name:"value", dataIndex:"value", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"validTo", dataIndex:"validTo", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addTextColumn({name:"targetUuid", dataIndex:"targetUuid", hidden:true, width:100})
			.addTextColumn({name:"targetType", dataIndex:"targetType", hidden:true, width:150})
			.addNumberColumn({name:"typeId", dataIndex:"typeId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
