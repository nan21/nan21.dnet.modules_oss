/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.system.dc.SysParamValue", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysParamValueDs"
});


/* ================= E-GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysParamValue$CtxList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_system_dc_SysParamValue$CtxList",
	_noImport_: true,
	_noExport_: true,
	_noPrint_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"value", dataIndex:"value", width:250,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"validTo", dataIndex:"validTo", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDefaults();
	}
});
