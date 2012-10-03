/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.uom.ds.model.UomConversionDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"divideTo", type:"float", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"multiplyWith", type:"float", useNull:true},
		{name:"sourceCode", type:"string"},
		{name:"sourceId", type:"int", useNull:true},
		{name:"targetCode", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.bd.uom.ds.model.UomConversionDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"divideTo", type:"float", useNull:true},
		{name:"divideTo_From",type:"float", useNull:true},
		{name:"divideTo_To",type:"float", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"multiplyWith", type:"float", useNull:true},
		{name:"multiplyWith_From",type:"float", useNull:true},
		{name:"multiplyWith_To",type:"float", useNull:true},
		{name:"sourceCode", type:"string"},
		{name:"sourceId", type:"int", useNull:true},
		{name:"sourceId_From",type:"int", useNull:true},
		{name:"sourceId_To",type:"int", useNull:true},
		{name:"targetCode", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"targetId_From",type:"int", useNull:true},
		{name:"targetId_To",type:"int", useNull:true},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.bd.uom.ds.param.UomConversionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
