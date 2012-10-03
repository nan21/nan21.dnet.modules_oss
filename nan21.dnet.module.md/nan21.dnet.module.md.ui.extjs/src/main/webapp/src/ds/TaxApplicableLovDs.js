/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.base.tax.ds.model.TaxApplicableLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"rate", type:"float", useNull:true},
		{name:"summary", type:"boolean"}
	]});
Ext.define("net.nan21.dnet.module.md.base.tax.ds.model.TaxApplicableLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"rate", type:"float", useNull:true},
		{name:"rate_From",type:"float", useNull:true},
		{name:"rate_To",type:"float", useNull:true},
		{name:"summary", type:"boolean", useNull:true}
	]
});
Ext.define("net.nan21.dnet.module.md.base.tax.ds.param.TaxApplicableLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
