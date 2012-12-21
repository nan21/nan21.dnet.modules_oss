/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.domain.entity;

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
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@Table(name = PurchaseOrderItemTax.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class PurchaseOrderItemTax extends AbstractAuditable {

	public static final String TABLE_NAME = "SC_ORD_ITEM_TAX";
	public static final String SEQUENCE_NAME = "SC_ORD_ITEM_TAX_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "BASEAMOUNT", nullable = false, scale = 2)
	@NotNull
	private Float baseAmount;

	@Column(name = "TAXAMOUNT", nullable = false, scale = 2)
	@NotNull
	private Float taxAmount;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PurchaseOrderItem.class)
	@JoinColumn(name = "PURCHASEORDERITEM_ID", referencedColumnName = "ID")
	private PurchaseOrderItem purchaseOrderItem;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Tax.class)
	@JoinColumn(name = "TAX_ID", referencedColumnName = "ID")
	private Tax tax;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getBaseAmount() {
		return this.baseAmount;
	}

	public void setBaseAmount(Float baseAmount) {
		this.baseAmount = baseAmount;
	}

	public Float getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(Float taxAmount) {
		this.taxAmount = taxAmount;
	}

	public PurchaseOrderItem getPurchaseOrderItem() {
		return this.purchaseOrderItem;
	}

	public void setPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
		if (purchaseOrderItem != null) {
			this.__validate_client_context__(purchaseOrderItem.getClientId());
		}
		this.purchaseOrderItem = purchaseOrderItem;
	}

	public Tax getTax() {
		return this.tax;
	}

	public void setTax(Tax tax) {
		if (tax != null) {
			this.__validate_client_context__(tax.getClientId());
		}
		this.tax = tax;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
