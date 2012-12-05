/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

/**
 * Repository functionality for {@link SalesTxAmount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SalesTxAmountService extends AbstractEntityService<SalesTxAmount> {

	public SalesTxAmountService() {
		super();
	}

	public SalesTxAmountService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SalesTxAmount> getEntityClass() {
		return SalesTxAmount.class;
	}

	/**
	 * Find by reference: order
	 */
	public List<SalesTxAmount> findByOrder(SalesOrder order) {
		return this.findByOrderId(order.getId());
	}

	/**
	 * Find by ID of reference: order.id
	 */
	public List<SalesTxAmount> findByOrderId(Long orderId) {
		return (List<SalesTxAmount>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesTxAmount e where e.clientId = :pClientId and e.order.id = :pOrderId",
						SalesTxAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrderId", orderId).getResultList();
	}

	/**
	 * Find by reference: invoice
	 */
	public List<SalesTxAmount> findByInvoice(SalesInvoice invoice) {
		return this.findByInvoiceId(invoice.getId());
	}

	/**
	 * Find by ID of reference: invoice.id
	 */
	public List<SalesTxAmount> findByInvoiceId(Long invoiceId) {
		return (List<SalesTxAmount>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesTxAmount e where e.clientId = :pClientId and e.invoice.id = :pInvoiceId",
						SalesTxAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pInvoiceId", invoiceId).getResultList();
	}
}
