/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationToShipLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"asString", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"id", type:"int", useNull:true},
		{name:"targetType", type:"string"},
		{name:"targetUuid", type:"string"}
	]
});
