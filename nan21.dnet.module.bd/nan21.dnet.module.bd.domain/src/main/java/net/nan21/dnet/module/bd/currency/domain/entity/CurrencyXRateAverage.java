/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.currency.domain.entity;

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
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = CurrencyXRateAverage.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class CurrencyXRateAverage extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_CRNCY_XRATE_AVG";
	public static final String SEQUENCE_NAME = "BD_CRNCY_XRATE_AVG_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDFROM", nullable = false)
	@NotNull
	private Date validFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDTO", nullable = false)
	@NotNull
	private Date validTo;

	@Column(name = "VALUE", nullable = false, scale = 2)
	@NotNull
	private Float value;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CurrencyXRateProvider.class)
	@JoinColumn(name = "PROVIDER_ID", referencedColumnName = "ID")
	private CurrencyXRateProvider provider;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "SOURCE_ID", referencedColumnName = "ID")
	private Currency source;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "TARGET_ID", referencedColumnName = "ID")
	private Currency target;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Float getValue() {
		return this.value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public CurrencyXRateProvider getProvider() {
		return this.provider;
	}

	public void setProvider(CurrencyXRateProvider provider) {
		if (provider != null) {
			this.__validate_client_context__(provider.getClientId());
		}
		this.provider = provider;
	}

	public Currency getSource() {
		return this.source;
	}

	public void setSource(Currency source) {
		if (source != null) {
			this.__validate_client_context__(source.getClientId());
		}
		this.source = source;
	}

	public Currency getTarget() {
		return this.target;
	}

	public void setTarget(Currency target) {
		if (target != null) {
			this.__validate_client_context__(target.getClientId());
		}
		this.target = target;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
