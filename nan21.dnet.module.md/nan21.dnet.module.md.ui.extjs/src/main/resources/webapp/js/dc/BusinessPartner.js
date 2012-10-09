/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.bp.dc.BusinessPartner", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.bp.ds.model.BusinessPartnerDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.BusinessPartnerDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.BusinessPartnerDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BusinessPartner$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_bp_dc_BusinessPartner$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "person", "company"]
			})
			.addTextField({ name:"firstName", dataIndex:"firstName", anchor:"-20"})
			.addTextField({ name:"lastName", dataIndex:"lastName", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"gender", dataIndex:"gender", anchor:"-20",
				store:[ "male", "female"]
			})
			.addLov({xtype:"md_bp_lovs_CompanyLegalForms", name:"legalForm", dataIndex:"legalForm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "legalFormId"} 
				]})
			.addTextField({ name:"companyName", dataIndex:"companyName", anchor:"-20"})
			.addTextField({ name:"registrationNo", dataIndex:"registrationNo", anchor:"-20", maxLength:32})
			.addTextField({ name:"taxPayerNo", dataIndex:"taxPayerNo", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"bd_geo_lovs_Countries", name:"countryCode", dataIndex:"countryCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "countryId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:220, layout:"form"})
			.addPanel({ name:"col2",title:"Person", width:240, layout:"form", xtype:"fieldset", border:true, collapsible:true})
			.addPanel({ name:"col3",title:"Company", width:240, layout:"form", xtype:"fieldset", border:true, collapsible:true})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code", "active", "type", "countryCode", "taxPayerNo"])
			.addChildrenTo("col2", ["firstName", "lastName", "gender"])
			.addChildrenTo("col3", ["companyName", "registrationNo", "legalForm"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BusinessPartner$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_bp_dc_BusinessPartner$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"type", dataIndex:"type", width:100})
			.addTextColumn({ name:"countryCode", dataIndex:"countryCode", width:100})
			.addTextColumn({ name:"taxPayerNo", dataIndex:"taxPayerNo", width:80})
			.addBooleanColumn({ name:"active", dataIndex:"active", width:60})
			.addTextColumn({ name:"companyName", dataIndex:"companyName", hidden:true, width:200})
			.addTextColumn({ name:"firstName", dataIndex:"firstName", hidden:true, width:200})
			.addTextColumn({ name:"lastName", dataIndex:"lastName", hidden:true, width:200})
			.addTextColumn({ name:"identityCardNo", dataIndex:"identityCardNo", width:80})
			.addTextColumn({ name:"gender", dataIndex:"gender", hidden:true, width:60})
			.addTextColumn({ name:"legalForm", dataIndex:"legalForm", width:80})
			.addTextColumn({ name:"registrationNo", dataIndex:"registrationNo", width:80})
			.addDateColumn({ name:"registrationDate", dataIndex:"registrationDate", width:80, format: Dnet.DATE_FORMAT})
			.addDefaults();
	}});


/* ================= EDITOR: Create ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BusinessPartner$Create", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_bp_dc_BusinessPartner$Create",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "person", "company"]
			})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["type"])
		;
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.bp.dc.BusinessPartner$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_bp_dc_BusinessPartner$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addDisplayFieldText({ name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20", maxLength:16})
			.addLov({xtype:"bd_geo_lovs_Countries", name:"countryCode", dataIndex:"countryCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "countryId"} 
				]})
			.addTextField({ name:"taxPayerNo", dataIndex:"taxPayerNo", anchor:"-20"})
			.addTextField({ name:"firstName", dataIndex:"firstName", anchor:"-20",listeners:{
				change:{scope:this, fn:this._updatePersonName_}
			}
			})
			.addTextField({ name:"lastName", dataIndex:"lastName", anchor:"-20",listeners:{
				change:{scope:this, fn:this._updatePersonName_}
			}
			})
			.addTextField({ name:"middleName", dataIndex:"middleName", anchor:"-20",listeners:{
				change:{scope:this, fn:this._updatePersonName_}
			}
			})
			.addTextField({ name:"identityCardNo", dataIndex:"identityCardNo", anchor:"-20"})
			.addTextField({ name:"passportNo", dataIndex:"passportNo", anchor:"-20"})
			.addDateField({name:"birthDate", dataIndex:"birthDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addCombo({ xtype:"combo", name:"gender", dataIndex:"gender", anchor:"-20",
				store:[ "male", "female"]
			})
			.addTextField({ name:"companyName", dataIndex:"companyName", anchor:"-20",listeners:{
				change:{scope:this, fn:this._updateCompanyName_}
			}
			})
			.addTextField({ name:"registrationNo", dataIndex:"registrationNo", anchor:"-20", maxLength:32})
			.addDateField({name:"registrationDate", dataIndex:"registrationDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_bp_lovs_CompanyLegalForms", name:"legalForm", dataIndex:"legalForm", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "legalFormId"} 
				],
				filterFieldMapping: [
					{lovField:"countryId",dsField: "countryId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col0", layout:"card"})
			.addPanel({ name:"formCompany", width:600})
			.addPanel({ name:"formCompanyCol1", width:500, height:40, layout:"form"})
			.addPanel({ name:"formCompanyCol2", width:250, layout:"form"})
			.addPanel({ name:"formPerson", width:600, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"formPersonCol1", width:300, layout:"form"})
			.addPanel({ name:"formPersonCol2", width:250, layout:"form"})
			.addPanel({ name:"col1", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col0"])
			.addChildrenTo("col0", ["formCompany", "formPerson"])
			.addChildrenTo("formCompany", ["formCompanyCol1", "formCompanyCol2"])
			.addChildrenTo("formCompanyCol1", ["companyName"])
			.addChildrenTo("formCompanyCol2", ["legalForm", "registrationNo", "registrationDate"])
			.addChildrenTo("formPerson", ["formPersonCol1", "formPersonCol2"])
			.addChildrenTo("formPersonCol1", ["lastName", "firstName", "middleName"])
			.addChildrenTo("formPersonCol2", ["identityCardNo", "passportNo", "gender", "birthDate"])
			.addChildrenTo("col1", ["type", "countryCode", "taxPayerNo", "code", "active"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	onRecordChange: function() {
		var rec = this._controller_.getRecord();
				if(rec) {
					if( rec.get("type") == "company") {
						this._showStackedViewElement_("col0", "formCompany");
					} else {
						this._showStackedViewElement_("col0", "formPerson");
					}			
				};
	},
	
	_afterRender_: function() {
		this._controller_.on("recordChange", this.onRecordChange, this);;
	},
	
	_updatePersonName_: function() {
		var rec = this._controller_.getRecord();
				if(rec.get("type") == "person")	{
					var n = rec.get("lastName") + " " + rec.get("firstName") + " " + rec.get("middleName");
					if (rec.get("name") != n) {
						rec.set("name", n)
					}
				};
	},
	
	_updateCompanyName_: function() {
		var rec = this._controller_.getRecord();
				if(rec.get("type") == "company")	{
					var n = rec.get("companyName");
					if (rec.get("name") != n) {
						rec.set("name", n)
					}
				};
	}
});
