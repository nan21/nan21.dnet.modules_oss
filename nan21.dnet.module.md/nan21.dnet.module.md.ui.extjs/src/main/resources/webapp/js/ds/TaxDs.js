/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.base.tax.ds.model.TaxDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"category", type:"string"},
		{name:"categoryId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"parentTax", type:"string"},
		{name:"parentTaxId", type:"int", useNull:true},
		{name:"rate", type:"float", useNull:true},
		{name:"summary", type:"boolean"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	
	validations: [
		{field: "name", type: 'presence'}
	]
});
