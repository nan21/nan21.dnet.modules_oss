/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

/**
 * Repository functionality for {@link PaymentItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PaymentItemService extends AbstractEntityService<PaymentItem> {

	public PaymentItemService() {
		super();
	}

	public PaymentItemService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<PaymentItem> getEntityClass() {
		return PaymentItem.class;
	}

	/**
	 * Find by reference: payment
	 */
	public List<PaymentItem> findByPayment(Payment payment) {
		return this.findByPaymentId(payment.getId());
	}

	/**
	 * Find by ID of reference: payment.id
	 */
	public List<PaymentItem> findByPaymentId(Long paymentId) {
		return (List<PaymentItem>) this.em
				.createQuery(
						"select e from PaymentItem e where e.clientId = :pClientId and e.payment.id = :pPaymentId",
						PaymentItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentId", paymentId).getResultList();
	}

	/**
	 * Find by reference: accItem
	 */
	public List<PaymentItem> findByAccItem(AccItem accItem) {
		return this.findByAccItemId(accItem.getId());
	}

	/**
	 * Find by ID of reference: accItem.id
	 */
	public List<PaymentItem> findByAccItemId(Long accItemId) {
		return (List<PaymentItem>) this.em
				.createQuery(
						"select e from PaymentItem e where e.clientId = :pClientId and e.accItem.id = :pAccItemId",
						PaymentItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccItemId", accItemId).getResultList();
	}

	/**
	 * Find by reference: product
	 */
	public List<PaymentItem> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<PaymentItem> findByProductId(Long productId) {
		return (List<PaymentItem>) this.em
				.createQuery(
						"select e from PaymentItem e where e.clientId = :pClientId and e.product.id = :pProductId",
						PaymentItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}

	/**
	 * Find by reference: uom
	 */
	public List<PaymentItem> findByUom(Uom uom) {
		return this.findByUomId(uom.getId());
	}

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<PaymentItem> findByUomId(Long uomId) {
		return (List<PaymentItem>) this.em
				.createQuery(
						"select e from PaymentItem e where e.clientId = :pClientId and e.uom.id = :pUomId",
						PaymentItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pUomId", uomId).getResultList();
	}
}
