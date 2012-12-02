/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"currency", type:"string"},
		{name:"docNo", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"supplier", type:"string"},
		{name:"totalAmount", type:"float", useNull:true}
	]
});
