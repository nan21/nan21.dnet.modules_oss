/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeValueDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"attribute", type:"string"},
		{name:"attributeId", type:"int", useNull:true},
		{name:"category", type:"string"},
		{name:"categoryId", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataType", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"listOfvalues", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"productCode", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productName", type:"string"},
		{name:"set", type:"string"},
		{name:"setId", type:"int", useNull:true},
		{name:"title", type:"string"},
		{name:"uom", type:"string"},
		{name:"uuid", type:"string"},
		{name:"value", type:"string"},
		{name:"version", type:"int", useNull:true}
	]});
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeValueDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"attribute", type:"string"},
		{name:"attributeId", type:"int", useNull:true},
		{name:"attributeId_From",type:"int", useNull:true},
		{name:"attributeId_To",type:"int", useNull:true},
		{name:"category", type:"string"},
		{name:"categoryId", type:"int", useNull:true},
		{name:"categoryId_From",type:"int", useNull:true},
		{name:"categoryId_To",type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"dataType", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"listOfvalues", type:"string"},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"productCode", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productId_From",type:"int", useNull:true},
		{name:"productId_To",type:"int", useNull:true},
		{name:"productName", type:"string"},
		{name:"set", type:"string"},
		{name:"setId", type:"int", useNull:true},
		{name:"setId_From",type:"int", useNull:true},
		{name:"setId_To",type:"int", useNull:true},
		{name:"title", type:"string"},
		{name:"uom", type:"string"},
		{name:"uuid", type:"string"},
		{name:"value", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.param.ProductAttributeValueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
});
