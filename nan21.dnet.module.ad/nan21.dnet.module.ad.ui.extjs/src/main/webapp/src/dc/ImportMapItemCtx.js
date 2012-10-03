/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDsFilter",
	paramModel: "net.nan21.dnet.module.ad.impex.ds.param.ImportMapItemDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.ad_impex_dc_ImportMapItemCtx$Filter",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"ad_system_lovs_SysDataSource", name:"dataSource", dataIndex:"dataSource", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.ad.system.lovs.SysDataSource", selectOnFocus:true}})
			.addTextField({ name:"fileName", dataIndex:"fileName", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
		;
	},

});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_impex_dc_ImportMapItemCtx$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"dataSource", dataIndex:"dataSource", xtype:"gridcolumn", width:150,
					editor:{xtype:"ad_system_lovs_SysDataSource", selectOnFocus:true}})
			.addTextColumn({name:"path", dataIndex:"path", width:150,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"fileName", dataIndex:"fileName", width:300,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"ukFieldName", dataIndex:"ukFieldName", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
