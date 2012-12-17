/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.ad.system.ds.model.DbChangeLogDs", {
	extend: 'Ext.data.Model',
	fields: [
		{name:"author", type:"string"},
		{name:"comments", type:"string"},
		{name:"dateExecuted", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"description", type:"string"},
		{name:"filename", type:"string"},
		{name:"id", type:"string"},
		{name:"liquibase", type:"string"},
		{name:"md5sum", type:"string"},
		{name:"orderExecuted", type:"int", useNull:true},
		{name:"tag", type:"string"},
		{name:"txid", type:"string"}
	]
});

Dnet.createFilterModelFromRecordModel({
	recordModelFqn: "net.nan21.dnet.module.ad.system.ds.model.DbChangeLogDs",
	fields: [
		{name:"dateExecuted_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dateExecuted_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"orderExecuted_From",type:"int", useNull:true},
		{name:"orderExecuted_To",type:"int", useNull:true}
	]
});
