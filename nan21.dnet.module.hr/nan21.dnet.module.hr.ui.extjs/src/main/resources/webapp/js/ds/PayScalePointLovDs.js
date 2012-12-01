/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.grade.ds.model.PayScalePointLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"payScaleId", type:"int", useNull:true}
	]});

Ext.define("net.nan21.dnet.module.hr.grade.ds.model.PayScalePointLovDsFilter", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"payScaleId", type:"int", useNull:true},
		{name:"payScaleId_From",type:"int", useNull:true},
		{name:"payScaleId_To",type:"int", useNull:true}
	]
});
