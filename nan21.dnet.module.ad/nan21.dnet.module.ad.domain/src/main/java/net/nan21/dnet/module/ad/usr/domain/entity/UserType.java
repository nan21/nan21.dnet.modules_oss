/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Application users. By default the users are defined and authenticated inside of the application.
 <BR> It is possible also to use external sources (as LDAP, other application, single-sign-on etc ).
 <BR> For this reason there is not reference across the application to an user through this object but only by a username (the <code>code<code> field).
 */
@NamedQueries({@NamedQuery(name = UserType.NQ_FIND_BY_NAME, query = "SELECT e FROM UserType e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = UserType.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = UserType.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class UserType extends AbstractType {

	public static final String TABLE_NAME = "AD_USR_TYPE";
	public static final String SEQUENCE_NAME = "AD_USR_TYPE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "UserType.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	/** User account for an employee.*/
	@Column(name = "EMPLOYEEACCOUNT", nullable = false)
	@NotNull
	private Boolean employeeAccount;

	/** User account for an external business partner.*/
	@Column(name = "BPACCOUNT", nullable = false)
	@NotNull
	private Boolean bpAccount;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getEmployeeAccount() {
		return this.employeeAccount;
	}

	public void setEmployeeAccount(Boolean employeeAccount) {
		this.employeeAccount = employeeAccount;
	}

	public Boolean getBpAccount() {
		return this.bpAccount;
	}

	public void setBpAccount(Boolean bpAccount) {
		this.bpAccount = bpAccount;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getEmployeeAccount() == null) {
			event.updateAttributeWithObject("employeeAccount", false);
		}
		if (this.getBpAccount() == null) {
			event.updateAttributeWithObject("bpAccount", false);
		}
	}
}
