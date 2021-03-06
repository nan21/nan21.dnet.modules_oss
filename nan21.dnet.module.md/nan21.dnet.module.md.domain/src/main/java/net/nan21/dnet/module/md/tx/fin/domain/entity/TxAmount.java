/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.fin.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ENTITYTYPE", discriminatorType = DiscriminatorType.STRING, length = 32)
@Table(name = TxAmount.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class TxAmount extends AbstractAuditable {

	public static final String TABLE_NAME = "TX_AMNT";
	public static final String SEQUENCE_NAME = "TX_AMNT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "ENTITYTYPE", length = 32)
	private String entityType;

	@Temporal(TemporalType.DATE)
	@Column(name = "DUEDATE", nullable = false)
	@NotNull
	private Date dueDate;

	/**Total due amount */
	@Column(name = "DUEAMOUNT", scale = 2)
	private Float dueAmount;

	/**Total amount payed until now */
	@Column(name = "PAYEDAMOUNT", scale = 2)
	private Float payedAmount;

	/**The amount remained to be paid. */
	@Column(name = "AMOUNT", scale = 2)
	private Float amount;

	@Column(name = "SALES", nullable = false)
	@NotNull
	private Boolean sales;

	@Column(name = "CREDIT", nullable = false)
	@NotNull
	private Boolean credit;

	@Column(name = "FROMORDER", nullable = false)
	@NotNull
	private Boolean fromOrder;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
	@JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
	private BusinessPartner bpartner;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
	@JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
	private Organization org;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
	@JoinColumn(name = "PAYMENTMETHOD_ID", referencedColumnName = "ID")
	private PaymentMethod paymentMethod;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
	private Currency currency;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntityType() {
		return this.entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Transient
	public Integer getDueInDays() {
		return (int) ((this.dueDate.getTime() - (new Date()).getTime()) / 86400000);
	}

	public void setDueInDays(Integer dueInDays) {
	}

	public Float getDueAmount() {
		return this.dueAmount;
	}

	public void setDueAmount(Float dueAmount) {
		this.dueAmount = dueAmount;
	}

	public Float getPayedAmount() {
		return this.payedAmount;
	}

	public void setPayedAmount(Float payedAmount) {
		this.payedAmount = payedAmount;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Boolean getSales() {
		return this.sales;
	}

	public void setSales(Boolean sales) {
		this.sales = sales;
	}

	public Boolean getCredit() {
		return this.credit;
	}

	public void setCredit(Boolean credit) {
		this.credit = credit;
	}

	public Boolean getFromOrder() {
		return this.fromOrder;
	}

	public void setFromOrder(Boolean fromOrder) {
		this.fromOrder = fromOrder;
	}

	public BusinessPartner getBpartner() {
		return this.bpartner;
	}

	public void setBpartner(BusinessPartner bpartner) {
		if (bpartner != null) {
			this.__validate_client_context__(bpartner.getClientId());
		}
		this.bpartner = bpartner;
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

	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		if (paymentMethod != null) {
			this.__validate_client_context__(paymentMethod.getClientId());
		}
		this.paymentMethod = paymentMethod;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		if (currency != null) {
			this.__validate_client_context__(currency.getClientId());
		}
		this.currency = currency;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getSales() == null) {
			event.updateAttributeWithObject("sales", false);
		}
		if (this.getCredit() == null) {
			event.updateAttributeWithObject("credit", false);
		}
		if (this.getFromOrder() == null) {
			event.updateAttributeWithObject("fromOrder", false);
		}
	}
}
