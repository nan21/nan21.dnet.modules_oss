/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeEducation;

@Ds(entity = EmployeeEducation.class)
@RefLookups({
		@RefLookup(refId = EmployeeEducationDs.f_employeeId),
		@RefLookup(refId = EmployeeEducationDs.f_typeId, namedQuery = EducationType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = EmployeeEducationDs.f_type)})})
public class EmployeeEducationDs extends AbstractAuditableDs<EmployeeEducation> {

	public static final String f_employeeId = "employeeId";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_fromDate = "fromDate";
	public static final String f_toDate = "toDate";
	public static final String f_institute = "institute";
	public static final String f_degree = "degree";
	public static final String f_notes = "notes";

	@DsField(join = "left", path = "employee.id")
	private Long employeeId;

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField
	private Date fromDate;

	@DsField
	private Date toDate;

	@DsField
	private String institute;

	@DsField
	private String degree;

	@DsField
	private String notes;

	public EmployeeEducationDs() {
		super();
	}

	public EmployeeEducationDs(EmployeeEducation e) {
		super(e);
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
