/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpBankAccountDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accountNo", type:"string"},
		{name:"active", type:"boolean"},
		{name:"bankBranch", type:"string"},
		{name:"bankCode", type:"string"},
		{name:"bankId", type:"int", useNull:true},
		{name:"bpartnerCode", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currencyCode", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"ibanAccount", type:"boolean"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpBankAccountDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"accountNo", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"bankBranch", type:"string"},
		{name:"bankCode", type:"string"},
		{name:"bankId", type:"int", useNull:true},
		{name:"bankId_From",type:"int", useNull:true},
		{name:"bankId_To",type:"int", useNull:true},
		{name:"bpartnerCode", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartnerId_From",type:"int", useNull:true},
		{name:"bpartnerId_To",type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"currencyCode", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"ibanAccount", type:"boolean", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.md.bp.ds.param.BpBankAccountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
