/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.tx.fin.domain.entity.TxAmount;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@CascadeOnDelete
@Table(name = PurchaseTxAmount.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class PurchaseTxAmount extends TxAmount {

	public static final String TABLE_NAME = "SC_TX_AMNT";
	public static final String SEQUENCE_NAME = "SC_TX_AMNT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PurchaseOrder.class)
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
	private PurchaseOrder order;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PurchaseInvoice.class)
	@JoinColumn(name = "INVOICE_ID", referencedColumnName = "ID")
	private PurchaseInvoice invoice;

	public PurchaseOrder getOrder() {
		return this.order;
	}

	public void setOrder(PurchaseOrder order) {
		if (order != null) {
			this.__validate_client_context__(order.getClientId());
		}
		this.order = order;
	}

	public PurchaseInvoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(PurchaseInvoice invoice) {
		if (invoice != null) {
			this.__validate_client_context__(invoice.getClientId());
		}
		this.invoice = invoice;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
