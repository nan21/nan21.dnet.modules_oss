/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({@NamedQuery(name = Assignable.NQ_FIND_BY_NAME, query = "SELECT e FROM Assignable e WHERE e.clientId = :pClientId and e.name = :pName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Assignable.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = Assignable.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
@Customizer(DefaultEventHandler.class)
public class Assignable extends AbstractType {

	public static final String TABLE_NAME = "AD_ASGNBL";
	public static final String SEQUENCE_NAME = "AD_ASGNBL_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Assignable.findByName";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "USERCODE", length = 32)
	private String userCode;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AssignableType.class)
	@JoinColumn(name = "ASSIGNABLETYPE_ID", referencedColumnName = "ID")
	private AssignableType assignableType;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public AssignableType getAssignableType() {
		return this.assignableType;
	}

	public void setAssignableType(AssignableType assignableType) {
		if (assignableType != null) {
			this.__validate_client_context__(assignableType.getClientId());
		}
		this.assignableType = assignableType;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
