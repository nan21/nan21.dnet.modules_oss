/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"adress", type:"string"},
		{name:"billing", type:"boolean"},
		{name:"cityId", type:"int", useNull:true},
		{name:"cityName", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"countryCode", type:"string"},
		{name:"countryId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"mailing", type:"boolean"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"regionCode", type:"string"},
		{name:"regionId", type:"int", useNull:true},
		{name:"regionName", type:"string"},
		{name:"shipping", type:"boolean"},
		{name:"targetType", type:"string"},
		{name:"targetUuid", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]
});
