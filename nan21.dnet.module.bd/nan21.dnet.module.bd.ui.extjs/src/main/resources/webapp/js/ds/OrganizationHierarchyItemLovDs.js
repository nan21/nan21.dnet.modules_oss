/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"hierarchyId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"orgId", type:"int", useNull:true}
	]
});
