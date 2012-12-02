/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpBankAccountDs", {
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
	]
});
