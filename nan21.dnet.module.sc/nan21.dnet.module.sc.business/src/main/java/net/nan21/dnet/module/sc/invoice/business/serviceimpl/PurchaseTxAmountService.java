/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

/**
 * Repository functionality for {@link PurchaseTxAmount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PurchaseTxAmountService
		extends
			AbstractEntityService<PurchaseTxAmount> {

	public PurchaseTxAmountService() {
		super();
	}

	public PurchaseTxAmountService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<PurchaseTxAmount> getEntityClass() {
		return PurchaseTxAmount.class;
	}

	/**
	 * Find by reference: order
	 */
	public List<PurchaseTxAmount> findByOrder(PurchaseOrder order) {
		return this.findByOrderId(order.getId());
	}

	/**
	 * Find by ID of reference: order.id
	 */
	public List<PurchaseTxAmount> findByOrderId(Long orderId) {
		return (List<PurchaseTxAmount>) this.em
				.createQuery(
						"select e from PurchaseTxAmount e where e.clientId = :pClientId and e.order.id = :pOrderId",
						PurchaseTxAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrderId", orderId).getResultList();
	}

	/**
	 * Find by reference: invoice
	 */
	public List<PurchaseTxAmount> findByInvoice(PurchaseInvoice invoice) {
		return this.findByInvoiceId(invoice.getId());
	}

	/**
	 * Find by ID of reference: invoice.id
	 */
	public List<PurchaseTxAmount> findByInvoiceId(Long invoiceId) {
		return (List<PurchaseTxAmount>) this.em
				.createQuery(
						"select e from PurchaseTxAmount e where e.clientId = :pClientId and e.invoice.id = :pInvoiceId",
						PurchaseTxAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pInvoiceId", invoiceId).getResultList();
	}
}
