/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.res.domain.entity.EmployeeBase;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({@NamedQuery(name = Employee.NQ_FIND_BY_CODE, query = "SELECT e FROM Employee e WHERE e.clientId = :pClientId and e.code = :pCode", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@CascadeOnDelete
@Table(name = Employee.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = Employee.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "CODE"})})
@Customizer(DefaultEventHandler.class)
public class Employee extends EmployeeBase {

	public static final String TABLE_NAME = "HR_EMPL";
	public static final String SEQUENCE_NAME = "HR_EMPL_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Employee.findByCode";

	@OneToMany(fetch = FetchType.LAZY, targetEntity = EmployeeContact.class, mappedBy = "employee", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<EmployeeContact> contacts;

	@Transient
	public String getBusinessObject() {
		return "Employee";
	}

	public void setBusinessObject(String businessObject) {
	}

	public Collection<EmployeeContact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Collection<EmployeeContact> contacts) {
		this.contacts = contacts;
	}

	public void addToContacts(EmployeeContact e) {
		if (this.contacts == null) {
			this.contacts = new ArrayList<EmployeeContact>();
		}
		e.setEmployee(this);
		this.contacts.add(e);
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
