/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.tx.fin.domain.entity.TxAmount;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

@NamedQueries({})
@Entity
@CascadeOnDelete
@Table(name = SalesTxAmount.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class SalesTxAmount extends TxAmount {

	public static final String TABLE_NAME = "SD_TX_AMNT";
	public static final String SEQUENCE_NAME = "SD_TX_AMNT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesOrder.class)
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
	private SalesOrder order;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesInvoice.class)
	@JoinColumn(name = "INVOICE_ID", referencedColumnName = "ID")
	private SalesInvoice invoice;

	public SalesOrder getOrder() {
		return this.order;
	}

	public void setOrder(SalesOrder order) {
		if (order != null) {
			this.__validate_client_context__(order.getClientId());
		}
		this.order = order;
	}

	public SalesInvoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(SalesInvoice invoice) {
		if (invoice != null) {
			this.__validate_client_context__(invoice.getClientId());
		}
		this.invoice = invoice;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

	}
}
