/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.attr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeCategory;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

@Ds(entity = Attribute.class, sort = {@SortField(field = AttributeDs.f_name)})
@RefLookups({
		@RefLookup(refId = AttributeDs.f_categoryId, namedQuery = AttributeCategory.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = AttributeDs.f_category)}),
		@RefLookup(refId = AttributeDs.f_uomId, namedQuery = Uom.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = AttributeDs.f_uom)})})
public class AttributeDs extends AbstractTypeDs<Attribute> {

	public static final String f_title = "title";
	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";
	public static final String f_dataType = "dataType";
	public static final String f_listOfvalues = "listOfvalues";
	public static final String f_uomId = "uomId";
	public static final String f_uom = "uom";

	@DsField
	private String title;

	@DsField(join = "left", path = "category.id")
	private Long categoryId;

	@DsField(join = "left", path = "category.name")
	private String category;

	@DsField
	private String dataType;

	@DsField
	private String listOfvalues;

	@DsField(join = "left", path = "uom.id")
	private Long uomId;

	@DsField(join = "left", path = "uom.code")
	private String uom;

	public AttributeDs() {
		super();
	}

	public AttributeDs(Attribute e) {
		super(e);
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getListOfvalues() {
		return this.listOfvalues;
	}

	public void setListOfvalues(String listOfvalues) {
		this.listOfvalues = listOfvalues;
	}

	public Long getUomId() {
		return this.uomId;
	}

	public void setUomId(Long uomId) {
		this.uomId = uomId;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}
}
