/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScalePoint", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScalePointDs"
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScalePoint$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_grade_dc_PayScalePoint$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"payScaleId", dataIndex:"payScaleId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});
