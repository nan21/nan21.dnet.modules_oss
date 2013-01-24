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
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

@Ds(entity = Employee.class)
@RefLookups({
		@RefLookup(refId = EmployeeDs.f_employerId, namedQuery = Organization.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = EmployeeDs.f_employerCode)}),
		@RefLookup(refId = EmployeeDs.f_citizenshipId, namedQuery = Country.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = EmployeeDs.f_citizenshipCode)})})
public class EmployeeDs extends AbstractAuditableDs<Employee> {

	public static final String f_code = "code";
	public static final String f_employerId = "employerId";
	public static final String f_employerCode = "employerCode";
	public static final String f_businessObject = "businessObject";
	public static final String f_firstName = "firstName";
	public static final String f_lastName = "lastName";
	public static final String f_middleName = "middleName";
	public static final String f_birthdate = "birthdate";
	public static final String f_gender = "gender";
	public static final String f_maritalStatus = "maritalStatus";
	public static final String f_sinNo = "sinNo";
	public static final String f_ssnNo = "ssnNo";
	public static final String f_hasDisability = "hasDisability";
	public static final String f_firstHireDate = "firstHireDate";
	public static final String f_currentHireDate = "currentHireDate";
	public static final String f_officeEmail = "officeEmail";
	public static final String f_citizenshipId = "citizenshipId";
	public static final String f_citizenshipCode = "citizenshipCode";
	public static final String f_passportNo = "passportNo";
	public static final String f_className = "className";
	public static final String f_photoUrl = "photoUrl";
	public static final String f_photoLocation = "photoLocation";

	@DsField
	private String code;

	@DsField(join = "left", path = "employer.id")
	private Long employerId;

	@DsField(join = "left", path = "employer.code")
	private String employerCode;

	@DsField(fetch = false)
	private String businessObject;

	@DsField
	private String firstName;

	@DsField
	private String lastName;

	@DsField
	private String middleName;

	@DsField
	private Date birthdate;

	@DsField
	private String gender;

	@DsField
	private String maritalStatus;

	@DsField
	private String sinNo;

	@DsField
	private String ssnNo;

	@DsField
	private Boolean hasDisability;

	@DsField
	private Date firstHireDate;

	@DsField
	private Date currentHireDate;

	@DsField
	private String officeEmail;

	@DsField(join = "left", path = "citizenship.id")
	private Long citizenshipId;

	@DsField(join = "left", path = "citizenship.code")
	private String citizenshipCode;

	@DsField
	private String passportNo;

	@DsField(fetch = false)
	private String className;

	@DsField
	private String photoUrl;

	private String photoLocation;

	public EmployeeDs() {
		super();
	}

	public EmployeeDs(Employee e) {
		super(e);
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getEmployerId() {
		return this.employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getEmployerCode() {
		return this.employerCode;
	}

	public void setEmployerCode(String employerCode) {
		this.employerCode = employerCode;
	}

	public String getBusinessObject() {
		return this.businessObject;
	}

	public void setBusinessObject(String businessObject) {
		this.businessObject = businessObject;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSinNo() {
		return this.sinNo;
	}

	public void setSinNo(String sinNo) {
		this.sinNo = sinNo;
	}

	public String getSsnNo() {
		return this.ssnNo;
	}

	public void setSsnNo(String ssnNo) {
		this.ssnNo = ssnNo;
	}

	public Boolean getHasDisability() {
		return this.hasDisability;
	}

	public void setHasDisability(Boolean hasDisability) {
		this.hasDisability = hasDisability;
	}

	public Date getFirstHireDate() {
		return this.firstHireDate;
	}

	public void setFirstHireDate(Date firstHireDate) {
		this.firstHireDate = firstHireDate;
	}

	public Date getCurrentHireDate() {
		return this.currentHireDate;
	}

	public void setCurrentHireDate(Date currentHireDate) {
		this.currentHireDate = currentHireDate;
	}

	public String getOfficeEmail() {
		return this.officeEmail;
	}

	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}

	public Long getCitizenshipId() {
		return this.citizenshipId;
	}

	public void setCitizenshipId(Long citizenshipId) {
		this.citizenshipId = citizenshipId;
	}

	public String getCitizenshipCode() {
		return this.citizenshipCode;
	}

	public void setCitizenshipCode(String citizenshipCode) {
		this.citizenshipCode = citizenshipCode;
	}

	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhotoLocation() {
		return this.photoLocation;
	}

	public void setPhotoLocation(String photoLocation) {
		this.photoLocation = photoLocation;
	}
}
