/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectMemberLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"member", type:"string"},
		{name:"memberId", type:"int", useNull:true},
		{name:"projectId", type:"int", useNull:true},
		{name:"role", type:"string"},
		{name:"roleId", type:"int", useNull:true}
	]
});
