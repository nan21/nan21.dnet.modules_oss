/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.dc.BpBankAccount", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.bp.ds.model.BpBankAccountDs"
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BpBankAccount$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_bp_dc_BpBankAccount$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"bpartnerCode", dataIndex:"bpartnerCode", hidden:true, width:100})
			.addLov({name:"bankCode", dataIndex:"bankCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_bp_lovs_Banks", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "bankId"} 
						]}})
			.addTextColumn({name:"bankBranch", dataIndex:"bankBranch", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"currencyCode", dataIndex:"currencyCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_currency_lovs_Currencies", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "currencyId"} 
						]}})
			.addTextColumn({name:"accountNo", dataIndex:"accountNo", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"ibanAccount", dataIndex:"ibanAccount"})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"bpartnerId", dataIndex:"bpartnerId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"bankId", dataIndex:"bankId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"currencyId", dataIndex:"currencyId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
