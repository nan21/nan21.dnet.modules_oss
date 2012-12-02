/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.base.tx.ds.model.DeliveryMethodLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"delivery", type:"boolean"},
		{name:"description", type:"string"},
		{name:"externalCourier", type:"boolean"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"}
	]
});
