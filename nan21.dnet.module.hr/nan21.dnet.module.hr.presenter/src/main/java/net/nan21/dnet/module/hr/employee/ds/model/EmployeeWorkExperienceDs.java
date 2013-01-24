/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeWorkExperience;

@Ds(entity = EmployeeWorkExperience.class)
@RefLookups({@RefLookup(refId = EmployeeWorkExperienceDs.f_employeeId)})
public class EmployeeWorkExperienceDs
		extends
			AbstractAuditableDs<EmployeeWorkExperience> {

	public static final String f_employeeId = "employeeId";
	public static final String f_fromDate = "fromDate";
	public static final String f_toDate = "toDate";
	public static final String f_institute = "institute";
	public static final String f_notes = "notes";

	@DsField(join = "left", path = "employee.id")
	private Long employeeId;

	@DsField
	private Date fromDate;

	@DsField
	private Date toDate;

	@DsField
	private String institute;

	@DsField
	private String notes;

	public EmployeeWorkExperienceDs() {
		super();
	}

	public EmployeeWorkExperienceDs(EmployeeWorkExperience e) {
		super(e);
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getInstitute() {
		return this.institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
