/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductWithUomLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"purchase", type:"boolean"},
		{name:"sale", type:"boolean"},
		{name:"uom", type:"string"},
		{name:"uomId", type:"int", useNull:true}
	]
});
