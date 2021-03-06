/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderTaxService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderTax;

/**
 * Repository functionality for {@link PurchaseOrderTax} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PurchaseOrderTaxService
		extends
			AbstractEntityService<PurchaseOrderTax>
		implements
			IPurchaseOrderTaxService {

	public PurchaseOrderTaxService() {
		super();
	}

	public PurchaseOrderTaxService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PurchaseOrderTax> getEntityClass() {
		return PurchaseOrderTax.class;
	}

	/**
	 * Find by reference: purchaseOrder
	 */
	public List<PurchaseOrderTax> findByPurchaseOrder(
			PurchaseOrder purchaseOrder) {
		return this.findByPurchaseOrderId(purchaseOrder.getId());
	}

	/**
	 * Find by ID of reference: purchaseOrder.id
	 */
	public List<PurchaseOrderTax> findByPurchaseOrderId(Long purchaseOrderId) {
		return (List<PurchaseOrderTax>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseOrderTax e where e.clientId = :pClientId and e.purchaseOrder.id = :pPurchaseOrderId",
						PurchaseOrderTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPurchaseOrderId", purchaseOrderId)
				.getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseOrderTax> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseOrderTax> findByTaxId(Long taxId) {
		return (List<PurchaseOrderTax>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseOrderTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						PurchaseOrderTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}
}
