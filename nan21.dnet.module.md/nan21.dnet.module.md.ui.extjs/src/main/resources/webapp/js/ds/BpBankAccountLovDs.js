/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpBankAccountLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accountNo", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true}
	]});

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpBankAccountLovDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accountNo", type:"string"},
		{name:"id", type:"int", useNull:true}
	]
});
