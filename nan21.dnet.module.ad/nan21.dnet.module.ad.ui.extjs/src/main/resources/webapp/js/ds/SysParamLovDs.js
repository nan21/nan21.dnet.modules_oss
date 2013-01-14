/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysParamLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]
});