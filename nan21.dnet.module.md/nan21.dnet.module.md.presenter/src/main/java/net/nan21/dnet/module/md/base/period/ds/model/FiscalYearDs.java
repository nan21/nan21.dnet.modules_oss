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
import net.nan21.dnet.module.bd.org.domain.entity.Calendar;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

@Ds(entity = FiscalYear.class, sort = {@SortField(field = FiscalYearDs.f_startDate, desc = true)})
@RefLookups({@RefLookup(refId = FiscalYearDs.f_calendarId, namedQuery = Calendar.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = FiscalYearDs.f_calendar)})})
public class FiscalYearDs extends AbstractTypeWithCodeDs<FiscalYear> {

	public static final String f_startDate = "startDate";
	public static final String f_endDate = "endDate";
	public static final String f_calendarId = "calendarId";
	public static final String f_calendar = "calendar";

	@DsField
	private Date startDate;

	@DsField
	private Date endDate;

	@DsField(join = "left", path = "calendar.id")
	private Long calendarId;

	@DsField(join = "left", path = "calendar.name")
	private String calendar;

	public FiscalYearDs() {
		super();
	}

	public FiscalYearDs(FiscalYear e) {
		super(e);
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

	public Long getCalendarId() {
		return this.calendarId;
	}

	public void setCalendarId(Long calendarId) {
		this.calendarId = calendarId;
	}

	public String getCalendar() {
		return this.calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}
}
