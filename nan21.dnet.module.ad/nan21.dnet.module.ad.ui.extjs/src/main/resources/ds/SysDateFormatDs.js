/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDateFormatDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"extjsAltFormats", type:"string"},
		{name:"extjsDateFormat", type:"string"},
		{name:"extjsDateTimeFormat", type:"string"},
		{name:"extjsTimeFormat", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"javaDateFormat", type:"string"},
		{name:"javaDateTimeFormat", type:"string"},
		{name:"javaTimeFormat", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	validations: [
		{field: "name", type: 'presence'}
	]
});
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDateFormatDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"extjsAltFormats", type:"string"},
		{name:"extjsDateFormat", type:"string"},
		{name:"extjsDateTimeFormat", type:"string"},
		{name:"extjsTimeFormat", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"javaDateFormat", type:"string"},
		{name:"javaDateTimeFormat", type:"string"},
		{name:"javaTimeFormat", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDateFormatDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
