/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"planDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"project", type:"string"},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectName", type:"string"},
		{name:"releaseDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"uuid", type:"string"},
		{name:"version", type:"int", useNull:true}
	],
	validations: [
		{field: "name", type: 'presence'},
		{field: "planDate", type: 'presence'}
	]});
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [
		{name:"active", type:"boolean", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"description", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"name", type:"string"},
		{name:"planDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"planDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"planDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"project", type:"string"},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectId_From",type:"int", useNull:true},
		{name:"projectId_To",type:"int", useNull:true},
		{name:"projectName", type:"string"},
		{name:"releaseDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"releaseDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"releaseDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"uuid", type:"string"}
	]
});
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectVersionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"hideDue", type:"boolean"},
		{name:"hideReleased", type:"boolean"}
	]
});
