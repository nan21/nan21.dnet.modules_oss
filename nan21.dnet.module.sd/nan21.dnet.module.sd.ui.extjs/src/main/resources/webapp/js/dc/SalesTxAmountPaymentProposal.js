/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmountPaymentProposal", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountPaymentProposalDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountPaymentProposalDsParam",
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountPaymentProposalDs",
	
	/* ==================== Business functions ==================== */
	
	_registerListeners_: function() {
		
		this.callParent(arguments);
		this.mon(this.store, "load", this.distributePayment, this);
		this.mon(this.store, "changes_rejected", this.updateUnusedAmount, this);
	},
	
	distributePayment: function() {
		
		var receivedAmount = this.params.get("receivedAmount");
		var unallocated = receivedAmount;
		 
		this.store.each(function(record) {			
			var r=record;
			r.beginEdit();
			var o = r.get("outstandingAmount");
			if (unallocated <= o) {
				r.set("currentPayment",unallocated);
				unallocated = 0;
			} else {
				r.set("currentPayment",o);				 
				unallocated = unallocated - o;
			}
			r.set("remainingAmount",o-r.get("currentPayment"));
			r.endEdit();
		});
		this.setParamValue("unAllocatedAmount",unallocated);
	},
	
	updateUnusedAmount: function() {
		
		var u = 0;
		this.store.each(function(record) {
			u+=record.get("currentPayment");
		});
		this.setParamValue("unAllocatedAmount",this.getParamValue("receivedAmount") - u);
	}

});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmountPaymentProposal$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sd_invoice_dc_SalesTxAmountPaymentProposal$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"businessPartner", paramIndex:"businessPartner", anchor:"-20"})
			.addDisplayFieldNumber({ name:"receivedAmount", paramIndex:"receivedAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldNumber({ name:"unAllocatedAmount", paramIndex:"unAllocatedAmount", anchor:"-20", fieldCls:"displayfieldnumber important-field", decimals:2 })
			.addDisplayFieldText({ name:"currency", paramIndex:"paymentCurrency", anchor:"-20", fieldCls:"displayfield important-field", maxLength:32})
			.addDateField({name:"dueDate_From", dataIndex:"dueDate_From", emptyText:"From" })
			.addDateField({name:"dueDate_To", dataIndex:"dueDate_To", emptyText:"To" })
			.addFieldContainer({name: "dueDate", fieldLabel:"Due Date"})
				.addChildrenTo("dueDate",["dueDate_From", "dueDate_To"])
			.addNumberField({name:"dueAmount_From", dataIndex:"dueAmount_From", emptyText:"From" })
			.addNumberField({name:"dueAmount_To", dataIndex:"dueAmount_To", emptyText:"To" })
			.addFieldContainer({name: "dueAmount", fieldLabel:"Due Amount"})
				.addChildrenTo("dueAmount",["dueAmount_From", "dueAmount_To"])
			.addLov({xtype:"md_base_tx_lovs_PaymentMethodIn", name:"paymentMethod", dataIndex:"paymentMethod", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "paymentMethodId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["businessPartner", "currency", "receivedAmount", "unAllocatedAmount"])
			.addChildrenTo("col2", ["paymentMethod", "dueDate", "dueAmount"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmountPaymentProposal$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.sd_invoice_dc_SalesTxAmountPaymentProposal$EditList",
	_noImport_: true,
	_noExport_: true,
	_noPrint_: true,
	_noSort_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"orderCode", dataIndex:"orderCode", width:100})
			.addTextColumn({name:"orderDocNo", dataIndex:"orderDocNo", hidden:true, width:200})
			.addDateColumn({name:"orderDocDate", dataIndex:"orderDocDate", hidden:true, format: Dnet.DATE_FORMAT
			})
			.addTextColumn({name:"invoiceCode", dataIndex:"invoiceCode", width:100})
			.addTextColumn({name:"invoiceDocNo", dataIndex:"invoiceDocNo", hidden:true, width:200})
			.addDateColumn({name:"invoiceDocDate", dataIndex:"invoiceDocDate", hidden:true, format: Dnet.DATE_FORMAT
			})
			.addTextColumn({name:"paymentMethod", dataIndex:"paymentMethod", width:120})
			.addDateColumn({name:"dueDate", dataIndex:"dueDate", format: Dnet.DATE_FORMAT
			})
			.addNumberColumn({name:"dueAmount", dataIndex:"dueAmount", align:"right", decimals:2})
			.addNumberColumn({name:"payedAmount", dataIndex:"payedAmount", align:"right", decimals:2})
			.addNumberColumn({name:"outstandingAmount", dataIndex:"outstandingAmount", align:"right", decimals:2})
			.addNumberColumn({name:"currentPayment", dataIndex:"currentPayment", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"remainingAmount", dataIndex:"remainingAmount", align:"right", decimals:2})
			.addNumberColumn({name:"invoiceId", dataIndex:"invoiceId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"orderId", dataIndex:"orderId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	},
	
	/* ==================== Business functions ==================== */
	
	_afterEdit_: function(editor,e,eOpts) {
		
		var r = e.record;
		var ov = e.originalValue;
		var nv = e.value;
		r.set("remainingAmount", r.get("outstandingAmount") - r.get("currentPayment"));
		this._controller_.updateUnusedAmount();
	}

});
