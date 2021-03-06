/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.fin.domain.entity;

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
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = PaymentItem.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class PaymentItem extends AbstractAuditable {

	public static final String TABLE_NAME = "TX_PYMNT_ITEM";
	public static final String SEQUENCE_NAME = "TX_PYMNT_ITEM_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "QUANTITY", scale = 2)
	private Float quantity;

	@Column(name = "UNITPRICE", scale = 2)
	private Float unitPrice;

	@Column(name = "AMOUNT", nullable = false, scale = 2)
	@NotNull
	private Float amount;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Payment.class)
	@JoinColumn(name = "PAYMENT_ID", referencedColumnName = "ID")
	private Payment payment;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccItem.class)
	@JoinColumn(name = "ACCITEM_ID", referencedColumnName = "ID")
	private AccItem accItem;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
	@JoinColumn(name = "UOM_ID", referencedColumnName = "ID")
	private Uom uom;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		if (payment != null) {
			this.__validate_client_context__(payment.getClientId());
		}
		this.payment = payment;
	}

	public AccItem getAccItem() {
		return this.accItem;
	}

	public void setAccItem(AccItem accItem) {
		if (accItem != null) {
			this.__validate_client_context__(accItem.getClientId());
		}
		this.accItem = accItem;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		if (product != null) {
			this.__validate_client_context__(product.getClientId());
		}
		this.product = product;
	}

	public Uom getUom() {
		return this.uom;
	}

	public void setUom(Uom uom) {
		if (uom != null) {
			this.__validate_client_context__(uom.getClientId());
		}
		this.uom = uom;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
