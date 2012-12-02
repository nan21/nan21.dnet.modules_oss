/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.org.ds.model.FinancialAccountMethodDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"allowPayIn", type:"boolean"},
		{name:"allowPayOut", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"financialAccount", type:"string"},
		{name:"financialAccountId", type:"int", useNull:true},
		{name:"financialAccountType", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"payMethod", type:"string"},
		{name:"payMethodId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
