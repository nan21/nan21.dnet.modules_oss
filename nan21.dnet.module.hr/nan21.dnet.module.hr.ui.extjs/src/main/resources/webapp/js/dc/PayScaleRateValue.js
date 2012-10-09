/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRateValue", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDs",
	filterModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDsFilter",
	paramModel: "net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateValueDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRateValue$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_grade_dc_PayScaleRateValue$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"scaleRateId", dataIndex:"scaleRateId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"scalePointId", dataIndex:"scalePointId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"scalePointCode", dataIndex:"scalePointCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"hr_grade_lovs_PayScalePoints", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "scalePointId"} 
						]}})
			.addNumberColumn({name:"value", dataIndex:"value", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addDateColumn({name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"validTo", dataIndex:"validTo", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDefaults();
	}});
