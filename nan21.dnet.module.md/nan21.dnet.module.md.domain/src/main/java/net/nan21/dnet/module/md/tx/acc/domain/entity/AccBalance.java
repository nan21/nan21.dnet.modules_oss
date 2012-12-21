/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.acc.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = AccBalance.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class AccBalance extends AbstractAuditable {

	public static final String TABLE_NAME = "TX_ACC_BALANCE";
	public static final String SEQUENCE_NAME = "TX_ACC_BALANCE_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "ACCOUNT", nullable = false, length = 255)
	@NotBlank
	private String account;

	@Column(name = "AMOUNT", nullable = false, scale = 2)
	@NotNull
	private Float amount;

	@Column(name = "INITIALAMOUNT", nullable = false, scale = 2)
	@NotNull
	private Float initialAmount;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
	@JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
	private Organization org;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
	@JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
	private AccSchema accSchema;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = FiscalPeriod.class)
	@JoinColumn(name = "PERIOD_ID", referencedColumnName = "ID")
	private FiscalPeriod period;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Float getInitialAmount() {
		return this.initialAmount;
	}

	public void setInitialAmount(Float initialAmount) {
		this.initialAmount = initialAmount;
	}

	public Organization getOrg() {
		return this.org;
	}

	public void setOrg(Organization org) {
		if (org != null) {
			this.__validate_client_context__(org.getClientId());
		}
		this.org = org;
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

	public FiscalPeriod getPeriod() {
		return this.period;
	}

	public void setPeriod(FiscalPeriod period) {
		if (period != null) {
			this.__validate_client_context__(period.getClientId());
		}
		this.period = period;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
