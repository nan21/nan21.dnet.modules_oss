/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.period.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

@Ds(entity = FiscalPeriod.class, sort = {@SortField(field = FiscalPeriodDs.f_startDate, desc = true)})
@RefLookups({@RefLookup(refId = FiscalPeriodDs.f_yearId, namedQuery = FiscalYear.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = FiscalPeriodDs.f_year)})})
public class FiscalPeriodDs extends AbstractTypeWithCodeDs<FiscalPeriod> {

	public static final String f_yearId = "yearId";
	public static final String f_year = "year";
	public static final String f_type = "type";
	public static final String f_startDate = "startDate";
	public static final String f_endDate = "endDate";
	public static final String f_posting = "posting";

	@DsField(join = "left", path = "year.id")
	private Long yearId;

	@DsField(join = "left", path = "year.code")
	private String year;

	@DsField
	private String type;

	@DsField
	private Date startDate;

	@DsField
	private Date endDate;

	@DsField
	private Boolean posting;

	public FiscalPeriodDs() {
		super();
	}

	public FiscalPeriodDs(FiscalPeriod e) {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getPosting() {
		return this.posting;
	}

	public void setPosting(Boolean posting) {
		this.posting = posting;
	}
}
