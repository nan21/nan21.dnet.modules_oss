/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeLicense;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;

@Ds(entity = EmployeeLicense.class)
@RefLookups({
		@RefLookup(refId = EmployeeLicenseDs.f_employeeId),
		@RefLookup(refId = EmployeeLicenseDs.f_licenseTypeId, namedQuery = LicenseType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = EmployeeLicenseDs.f_licenseType)})})
public class EmployeeLicenseDs extends AbstractAuditableDs<EmployeeLicense> {

	public static final String f_employeeId = "employeeId";
	public static final String f_licenseTypeId = "licenseTypeId";
	public static final String f_licenseType = "licenseType";
	public static final String f_documentNo = "documentNo";
	public static final String f_issuedBy = "issuedBy";
	public static final String f_validFrom = "validFrom";
	public static final String f_validTo = "validTo";
	public static final String f_notes = "notes";

	@DsField(join = "left", path = "employee.id")
	private Long employeeId;

	@DsField(join = "left", path = "licenseType.id")
	private Long licenseTypeId;

	@DsField(join = "left", path = "licenseType.name")
	private String licenseType;

	@DsField
	private String documentNo;

	@DsField
	private String issuedBy;

	@DsField
	private Date validFrom;

	@DsField
	private Date validTo;

	@DsField
	private String notes;

	public EmployeeLicenseDs() {
		super();
	}

	public EmployeeLicenseDs(EmployeeLicense e) {
		super(e);
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getLicenseTypeId() {
		return this.licenseTypeId;
	}

	public void setLicenseTypeId(Long licenseTypeId) {
		this.licenseTypeId = licenseTypeId;
	}

	public String getLicenseType() {
		return this.licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getDocumentNo() {
		return this.documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getIssuedBy() {
		return this.issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
