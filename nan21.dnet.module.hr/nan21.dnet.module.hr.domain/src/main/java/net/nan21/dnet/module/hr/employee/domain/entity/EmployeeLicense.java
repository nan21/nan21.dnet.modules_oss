/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = EmployeeLicense.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class EmployeeLicense extends AbstractAuditable {

	public static final String TABLE_NAME = "HR_EMPL_LICENSE";
	public static final String SEQUENCE_NAME = "HR_EMPL_LICENSE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "DOCUMENTNO", length = 255)
	private String documentNo;

	@Column(name = "ISSUEDBY", length = 255)
	private String issuedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDFROM")
	private Date validFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDTO")
	private Date validTo;

	@Column(name = "NOTES", length = 4000)
	private String notes;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
	private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = LicenseType.class)
	@JoinColumn(name = "LICENSETYPE_ID", referencedColumnName = "ID")
	private LicenseType licenseType;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		if (employee != null) {
			this.__validate_client_context__(employee.getClientId());
		}
		this.employee = employee;
	}

	public LicenseType getLicenseType() {
		return this.licenseType;
	}

	public void setLicenseType(LicenseType licenseType) {
		if (licenseType != null) {
			this.__validate_client_context__(licenseType.getClientId());
		}
		this.licenseType = licenseType;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
