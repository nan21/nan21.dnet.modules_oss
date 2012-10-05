/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/dc/DeliveryMethod", "nan21.dnet.module.md.ui.extjs/ds/PaymentTermDs", "nan21.dnet.module.md.ui.extjs/lov/TxDocTypesPay", "nan21.dnet.module.md.ui.extjs/ds/TxDocTypePayLovDs", "nan21.dnet.module.md.ui.extjs/dc/PaymentMethod", "nan21.dnet.module.md.ui.extjs/ds/DeliveryMethodDs", "nan21.dnet.module.md.ui.extjs/dc/PaymentTerm", "nan21.dnet.module.md.ui.extjs/ds/PaymentMethodDs"]);

Ext.define("net.nan21.dnet.module.md.base.tx.frame.TxBaseData_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.base.tx.frame.TxBaseData_UI",
	_name_: "net.nan21.dnet.module.md.base.tx.frame.TxBaseData_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("payMtd", new net.nan21.dnet.module.md.base.tx.dc.PaymentMethod({multiEdit:true}))
			.addDc("payTerm", new net.nan21.dnet.module.md.base.tx.dc.PaymentTerm({multiEdit:true}))
			.addDc("delivMtd", new net.nan21.dnet.module.md.base.tx.dc.DeliveryMethod({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("payMtd", {name:"payMtdFilter", height:90, xtype:"md_base_tx_dc_PaymentMethod$Filter"})	
			.addDcEditGridView("payMtd", {name:"payMtdEditList", xtype:"md_base_tx_dc_PaymentMethod$EditList", frame:true})	
			.addDcFilterFormView("payTerm", {name:"payTermFilter", height:90, xtype:"md_base_tx_dc_PaymentTerm$Filter"})	
			.addDcEditGridView("payTerm", {name:"payTermEditList", xtype:"md_base_tx_dc_PaymentTerm$EditList", frame:true})	
			.addDcFilterFormView("delivMtd", {name:"delivMtdFilter", height:90, xtype:"md_base_tx_dc_DeliveryMethod$Filter"})	
			.addDcEditGridView("delivMtd", {name:"delivMtdEditList", xtype:"md_base_tx_dc_DeliveryMethod$EditList", frame:true})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasPayMtd", title:"Payment methods", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasPayTerm", title:"Payment terms", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasDelivMtd", title:"Delivery methods", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasPayMtd","canvasPayTerm","canvasDelivMtd"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasPayMtd", "canvasPayTerm", "canvasDelivMtd"])
			.addChildrenTo("canvasPayMtd", ["payMtdFilter", "payMtdEditList"], ["north", "center"])
			.addChildrenTo("canvasPayTerm", ["payTermFilter", "payTermEditList"], ["north", "center"])
			.addChildrenTo("canvasDelivMtd", ["delivMtdFilter", "delivMtdEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasPayMtd", "tlbpayMtd")
			.addToolbarTo("canvasPayTerm", "tlbpayTerm")
			.addToolbarTo("canvasDelivMtd", "tlbdelivMtd")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbpayMtd", {dc: "payMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Payment methods"})
			.end()
			.beginToolbar("tlbpayTerm", {dc: "payTerm"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Payment terms"})
			.end()
			.beginToolbar("tlbdelivMtd", {dc: "delivMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Delivery methods"})
			.end()
	}

});
