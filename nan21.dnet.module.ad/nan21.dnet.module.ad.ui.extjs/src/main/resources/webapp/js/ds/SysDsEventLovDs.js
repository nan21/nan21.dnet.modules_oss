/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsEventLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"dataSourceId", type:"int", useNull:true},
		{name:"dataSourceName", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]
});
