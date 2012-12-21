/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.tax.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxCategory;

@Ds(entity = Tax.class, sort = {@SortField(field = TaxDs.f_name)})
@RefLookups({
		@RefLookup(refId = TaxDs.f_categoryId, namedQuery = TaxCategory.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = TaxDs.f_category)}),
		@RefLookup(refId = TaxDs.f_parentTaxId, namedQuery = Tax.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = TaxDs.f_parentTax)})})
public class TaxDs extends AbstractTypeDs<Tax> {

	public static final String f_rate = "rate";
	public static final String f_summary = "summary";
	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";
	public static final String f_parentTaxId = "parentTaxId";
	public static final String f_parentTax = "parentTax";

	@DsField
	private Float rate;

	@DsField
	private Boolean summary;

	@DsField(join = "left", path = "category.id")
	private Long categoryId;

	@DsField(join = "left", path = "category.name")
	private String category;

	@DsField(join = "left", path = "parentTax.id")
	private Long parentTaxId;

	@DsField(join = "left", path = "parentTax.name")
	private String parentTax;

	public TaxDs() {
		super();
	}

	public TaxDs(Tax e) {
		super(e);
	}

	public Float getRate() {
		return this.rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Boolean getSummary() {
		return this.summary;
	}

	public void setSummary(Boolean summary) {
		this.summary = summary;
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

	public Long getParentTaxId() {
		return this.parentTaxId;
	}

	public void setParentTaxId(Long parentTaxId) {
		this.parentTaxId = parentTaxId;
	}

	public String getParentTax() {
		return this.parentTax;
	}

	public void setParentTax(String parentTax) {
		this.parentTax = parentTax;
	}
}
