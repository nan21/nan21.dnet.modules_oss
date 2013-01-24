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
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;

@Ds(entity = EmployeeContact.class)
@RefLookups({
		@RefLookup(refId = EmployeeContactDs.f_employeeId),
		@RefLookup(refId = EmployeeContactDs.f_relationshipId, namedQuery = EmployeeContactRelationship.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = EmployeeContactDs.f_relationship)})})
public class EmployeeContactDs extends AbstractAuditableDs<EmployeeContact> {

	public static final String f_employeeId = "employeeId";
	public static final String f_firstName = "firstName";
	public static final String f_lastName = "lastName";
	public static final String f_birthDate = "birthDate";
	public static final String f_gender = "gender";
	public static final String f_relationshipId = "relationshipId";
	public static final String f_relationship = "relationship";
	public static final String f_isDependent = "isDependent";

	@DsField(join = "left", path = "employee.id")
	private Long employeeId;

	@DsField
	private String firstName;

	@DsField
	private String lastName;

	@DsField
	private Date birthDate;

	@DsField
	private String gender;

	@DsField(join = "left", path = "relationship.id")
	private Long relationshipId;

	@DsField(join = "left", path = "relationship.name")
	private String relationship;

	@DsField
	private Boolean isDependent;

	public EmployeeContactDs() {
		super();
	}

	public EmployeeContactDs(EmployeeContact e) {
		super(e);
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getRelationshipId() {
		return this.relationshipId;
	}

	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Boolean getIsDependent() {
		return this.isDependent;
	}

	public void setIsDependent(Boolean isDependent) {
		this.isDependent = isDependent;
	}
}
