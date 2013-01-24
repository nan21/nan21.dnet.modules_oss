/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.period.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;

@Ds(entity = FiscalPeriod.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = FiscalPeriodLovDs.f_code)})
public class FiscalPeriodLovDs extends AbstractTypeWithCodeLov<FiscalPeriod> {

	public static final String f_yearId = "yearId";
	public static final String f_year = "year";

	@DsField(join = "left", path = "year.id")
	private Long yearId;

	@DsField(join = "left", path = "year.code")
	private String year;

	public FiscalPeriodLovDs() {
		super();
	}

	public FiscalPeriodLovDs(FiscalPeriod e) {
		super(e);
	}

	public Long getYearId() {
		return this.yearId;
	}

	public void setYearId(Long yearId) {
		this.yearId = yearId;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
