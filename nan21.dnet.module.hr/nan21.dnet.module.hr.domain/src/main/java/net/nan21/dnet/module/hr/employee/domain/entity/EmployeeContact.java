/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.bd.contact.domain.entity.Person;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactType;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@CascadeOnDelete
@Table(name = EmployeeContact.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class EmployeeContact extends Person {

	public static final String TABLE_NAME = "HR_EMPL_CNTC";
	public static final String SEQUENCE_NAME = "HR_EMPL_CNTC_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "ISDEPENDENT", nullable = false)
	@NotNull
	private Boolean isDependent;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
	private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = EmployeeContactType.class)
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
	private EmployeeContactType type;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = EmployeeContactRelationship.class)
	@JoinColumn(name = "RELATIONSHIP_ID", referencedColumnName = "ID")
	private EmployeeContactRelationship relationship;

	public Boolean getIsDependent() {
		return this.isDependent;
	}

	public void setIsDependent(Boolean isDependent) {
		this.isDependent = isDependent;
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

	public EmployeeContactType getType() {
		return this.type;
	}

	public void setType(EmployeeContactType type) {
		if (type != null) {
			this.__validate_client_context__(type.getClientId());
		}
		this.type = type;
	}

	public EmployeeContactRelationship getRelationship() {
		return this.relationship;
	}

	public void setRelationship(EmployeeContactRelationship relationship) {
		if (relationship != null) {
			this.__validate_client_context__(relationship.getClientId());
		}
		this.relationship = relationship;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getIsDependent() == null) {
			event.updateAttributeWithObject("isDependent", false);
		}
	}
}
