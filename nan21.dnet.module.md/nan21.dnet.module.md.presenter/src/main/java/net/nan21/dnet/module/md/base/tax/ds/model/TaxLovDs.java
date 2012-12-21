/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.tax.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;

@Ds(entity = Tax.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = TaxLovDs.f_name)})
public class TaxLovDs extends AbstractTypeLov<Tax> {

	public static final String f_rate = "rate";
	public static final String f_summary = "summary";

	@DsField
	private Float rate;

	@DsField
	private Boolean summary;

	public TaxLovDs() {
		super();
	}

	public TaxLovDs(Tax e) {
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
}
