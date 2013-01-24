/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.system.ds.model.UiViewStateRTLovDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"clientId", type:"int", useNull:true},
		{name:"cmp", type:"string"},
		{name:"cmpType", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"owner", type:"string"},
		{name:"stateValue", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.UiViewStateRTLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"hideMine", type:"boolean"},
		{name:"hideOthers", type:"boolean"}
	]
});
