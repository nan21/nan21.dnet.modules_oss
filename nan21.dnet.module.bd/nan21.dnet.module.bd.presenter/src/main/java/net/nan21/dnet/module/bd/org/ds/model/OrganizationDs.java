/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.org.domain.entity.Calendar;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

@Ds(entity = Organization.class, sort = {@SortField(field = OrganizationDs.f_name)})
@RefLookups({
		@RefLookup(refId = OrganizationDs.f_typeId, namedQuery = OrganizationType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = OrganizationDs.f_type)}),
		@RefLookup(refId = OrganizationDs.f_calendarId, namedQuery = Calendar.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = OrganizationDs.f_calendar)})})
public class OrganizationDs extends AbstractTypeWithCodeDs<Organization> {

	public static final String f_valid = "valid";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_calendarId = "calendarId";
	public static final String f_calendar = "calendar";
	public static final String f_className = "className";

	@DsField
	private Boolean valid;

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField(join = "left", path = "calendar.id")
	private Long calendarId;

	@DsField(join = "left", path = "calendar.name")
	private String calendar;

	@DsField(fetch = false)
	private String className;

	public OrganizationDs() {
		super();
	}

	public OrganizationDs(Organization e) {
		super(e);
	}

	public Boolean getValid() {
		return this.valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
