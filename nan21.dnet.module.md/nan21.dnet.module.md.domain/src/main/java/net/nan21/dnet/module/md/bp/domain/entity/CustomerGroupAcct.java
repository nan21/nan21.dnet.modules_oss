/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({
		@NamedQuery(name = CustomerGroupAcct.NQ_FIND_BY_GROUP_SCHEMA, query = "SELECT e FROM CustomerGroupAcct e WHERE e.clientId = :pClientId and e.custGroup = :pCustGroup and e.accSchema = :pAccSchema", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = CustomerGroupAcct.NQ_FIND_BY_GROUP_SCHEMA_PRIMITIVE, query = "SELECT e FROM CustomerGroupAcct e WHERE e.clientId = :pClientId and e.custGroup.id = :pCustGroupId and e.accSchema.id = :pAccSchemaId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = CustomerGroupAcct.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = CustomerGroupAcct.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "CUSTGROUP_ID", "ACCSCHEMA_ID"})})
@Customizer(DefaultEventHandler.class)
public class CustomerGroupAcct extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_BP_CUSTGRP_ACCT";
	public static final String SEQUENCE_NAME = "MD_BP_CUSTGRP_ACCT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Group_schema.
	 */
	public static final String NQ_FIND_BY_GROUP_SCHEMA = "CustomerGroupAcct.findByGroup_schema";

	/**
	 * Named query find by unique key: Group_schema using the ID field for references.
	 */
	public static final String NQ_FIND_BY_GROUP_SCHEMA_PRIMITIVE = "CustomerGroupAcct.findByGroup_schema_PRIMITIVE";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomerGroup.class)
	@JoinColumn(name = "CUSTGROUP_ID", referencedColumnName = "ID")
	private CustomerGroup custGroup;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
	@JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
	private AccSchema accSchema;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
	@JoinColumn(name = "SALESACCOUNT_ID", referencedColumnName = "ID")
	private Account salesAccount;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
	@JoinColumn(name = "PREPAYACCOUNT_ID", referencedColumnName = "ID")
	private Account prepayAccount;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerGroup getCustGroup() {
		return this.custGroup;
	}

	public void setCustGroup(CustomerGroup custGroup) {
		if (custGroup != null) {
			this.__validate_client_context__(custGroup.getClientId());
		}
		this.custGroup = custGroup;
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

	public Account getSalesAccount() {
		return this.salesAccount;
	}

	public void setSalesAccount(Account salesAccount) {
		if (salesAccount != null) {
			this.__validate_client_context__(salesAccount.getClientId());
		}
		this.salesAccount = salesAccount;
	}

	public Account getPrepayAccount() {
		return this.prepayAccount;
	}

	public void setPrepayAccount(Account prepayAccount) {
		if (prepayAccount != null) {
			this.__validate_client_context__(prepayAccount.getClientId());
		}
		this.prepayAccount = prepayAccount;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
