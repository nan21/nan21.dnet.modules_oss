/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sd.invoice.domain.eventhandler.SalesInvoiceEventHandler;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({@NamedQuery(name = SalesInvoice.NQ_FIND_BY_CODE, query = "SELECT e FROM SalesInvoice e WHERE e.clientId = :pClientId and e.code = :pCode", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = SalesInvoice.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = SalesInvoice.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "CODE"})})
@Customizer(SalesInvoiceEventHandler.class)
public class SalesInvoice extends AbstractAuditable {

	public static final String TABLE_NAME = "SD_INV";
	public static final String SEQUENCE_NAME = "SD_INV_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "SalesInvoice.findByCode";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "CODE", nullable = false, length = 32)
	@NotBlank
	private String code;

	@Temporal(TemporalType.DATE)
	@Column(name = "DOCDATE", nullable = false)
	@NotNull
	private Date docDate;

	@Column(name = "DOCNO", length = 255)
	private String docNo;

	@Column(name = "DESCRIPTION", length = 400)
	private String description;

	@Column(name = "TOTALNETAMOUNT", scale = 2)
	private Float totalNetAmount;

	@Column(name = "TOTALTAXAMOUNT", scale = 2)
	private Float totalTaxAmount;

	@Column(name = "TOTALAMOUNT", scale = 2)
	private Float totalAmount;

	@Column(name = "CONFIRMED", nullable = false)
	@NotNull
	private Boolean confirmed;

	@Column(name = "POSTED", nullable = false)
	@NotNull
	private Boolean posted;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PriceList.class)
	@JoinColumn(name = "PRICELIST_ID", referencedColumnName = "ID")
	private PriceList priceList;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
	private Currency currency;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
	@JoinColumn(name = "PAYMENTMETHOD_ID", referencedColumnName = "ID")
	private PaymentMethod paymentMethod;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentTerm.class)
	@JoinColumn(name = "PAYMENTTERM_ID", referencedColumnName = "ID")
	private PaymentTerm paymentTerm;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = TxDocType.class)
	@JoinColumn(name = "DOCTYPE_ID", referencedColumnName = "ID")
	private TxDocType docType;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
	private BusinessPartner customer;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Location.class)
	@JoinColumn(name = "BILLTOLOCATION_ID", referencedColumnName = "ID")
	private Location billToLocation;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Contact.class)
	@JoinColumn(name = "BILLTOCONTACT_ID", referencedColumnName = "ID")
	private Contact billToContact;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
	@JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
	private Organization supplier;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesOrder.class)
	@JoinColumn(name = "SALESORDER_ID", referencedColumnName = "ID")
	private SalesOrder salesOrder;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = SalesInvoiceItem.class, mappedBy = "salesInvoice", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<SalesInvoiceItem> lines;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = SalesInvoiceTax.class, mappedBy = "salesInvoice", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<SalesInvoiceTax> taxes;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDocDate() {
		return this.docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getDocNo() {
		return this.docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getTotalNetAmount() {
		return this.totalNetAmount;
	}

	public void setTotalNetAmount(Float totalNetAmount) {
		this.totalNetAmount = totalNetAmount;
	}

	public Float getTotalTaxAmount() {
		return this.totalTaxAmount;
	}

	public void setTotalTaxAmount(Float totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}

	public Float getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Boolean getConfirmed() {
		return this.confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Boolean getPosted() {
		return this.posted;
	}

	public void setPosted(Boolean posted) {
		this.posted = posted;
	}

	@Transient
	public String getBusinessObject() {
		return "SalesInvoice";
	}

	public void setBusinessObject(String businessObject) {
	}

	public PriceList getPriceList() {
		return this.priceList;
	}

	public void setPriceList(PriceList priceList) {
		if (priceList != null) {
			this.__validate_client_context__(priceList.getClientId());
		}
		this.priceList = priceList;
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

	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		if (paymentMethod != null) {
			this.__validate_client_context__(paymentMethod.getClientId());
		}
		this.paymentMethod = paymentMethod;
	}

	public PaymentTerm getPaymentTerm() {
		return this.paymentTerm;
	}

	public void setPaymentTerm(PaymentTerm paymentTerm) {
		if (paymentTerm != null) {
			this.__validate_client_context__(paymentTerm.getClientId());
		}
		this.paymentTerm = paymentTerm;
	}

	public TxDocType getDocType() {
		return this.docType;
	}

	public void setDocType(TxDocType docType) {
		if (docType != null) {
			this.__validate_client_context__(docType.getClientId());
		}
		this.docType = docType;
	}

	public BusinessPartner getCustomer() {
		return this.customer;
	}

	public void setCustomer(BusinessPartner customer) {
		if (customer != null) {
			this.__validate_client_context__(customer.getClientId());
		}
		this.customer = customer;
	}

	public Location getBillToLocation() {
		return this.billToLocation;
	}

	public void setBillToLocation(Location billToLocation) {
		if (billToLocation != null) {
			this.__validate_client_context__(billToLocation.getClientId());
		}
		this.billToLocation = billToLocation;
	}

	public Contact getBillToContact() {
		return this.billToContact;
	}

	public void setBillToContact(Contact billToContact) {
		if (billToContact != null) {
			this.__validate_client_context__(billToContact.getClientId());
		}
		this.billToContact = billToContact;
	}

	public Organization getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Organization supplier) {
		if (supplier != null) {
			this.__validate_client_context__(supplier.getClientId());
		}
		this.supplier = supplier;
	}

	public SalesOrder getSalesOrder() {
		return this.salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		if (salesOrder != null) {
			this.__validate_client_context__(salesOrder.getClientId());
		}
		this.salesOrder = salesOrder;
	}

	public Collection<SalesInvoiceItem> getLines() {
		return this.lines;
	}

	public void setLines(Collection<SalesInvoiceItem> lines) {
		this.lines = lines;
	}

	public void addToLines(SalesInvoiceItem e) {
		if (this.lines == null) {
			this.lines = new ArrayList<SalesInvoiceItem>();
		}
		e.setSalesInvoice(this);
		this.lines.add(e);
	}

	public Collection<SalesInvoiceTax> getTaxes() {
		return this.taxes;
	}

	public void setTaxes(Collection<SalesInvoiceTax> taxes) {
		this.taxes = taxes;
	}

	public void addToTaxes(SalesInvoiceTax e) {
		if (this.taxes == null) {
			this.taxes = new ArrayList<SalesInvoiceTax>();
		}
		e.setSalesInvoice(this);
		this.taxes.add(e);
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getConfirmed() == null) {
			event.updateAttributeWithObject("confirmed", false);
		}
		if (this.getPosted() == null) {
			event.updateAttributeWithObject("posted", false);
		}
		if (this.getCode() == null || this.getCode().equals("")) {
			event.updateAttributeWithObject("code", "SI-" + this.getId());
		}
	}
}
