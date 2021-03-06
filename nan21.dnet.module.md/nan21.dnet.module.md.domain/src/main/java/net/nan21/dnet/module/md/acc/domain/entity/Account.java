/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Accounting schema definition.  */
@NamedQueries({@NamedQuery(name = Account.NQ_FIND_BY_CODE, query = "SELECT e FROM Account e WHERE e.clientId = :pClientId and e.code = :pCode", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Account.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = Account.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "CODE"})})
@Customizer(DefaultEventHandler.class)
public class Account extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_ACC_ACCT";
	public static final String SEQUENCE_NAME = "MD_ACC_ACCT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Account.findByCode";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "TYPE", length = 16)
	private String type;

	@Column(name = "SUMMARY", nullable = false)
	@NotNull
	private Boolean summary;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
	@JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
	private AccSchema accSchema;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getSummary() {
		return this.summary;
	}

	public void setSummary(Boolean summary) {
		this.summary = summary;
	}

	public AccSchema getAccSchema() {
		return this.accSchema;
	}

	public void setAccSchema(AccSchema accSchema) {
		if (accSchema != null) {
			this.__validate_client_context__(accSchema.getClientId());
		}
		this.accSchema = accSchema;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getSummary() == null) {
			event.updateAttributeWithObject("summary", false);
		}
	}
}
