/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"accessControl", type:"string"},
		{name:"accessControlId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"deleteAllowed", type:"boolean"},
		{name:"dsName", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"exportAllowed", type:"boolean"},
		{name:"id", type:"int", useNull:true},
		{name:"importAllowed", type:"boolean"},
		{name:"insertAllowed", type:"boolean"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"queryAllowed", type:"boolean"},
		{name:"updateAllowed", type:"boolean"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
