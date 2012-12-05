/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderItemTaxService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

/**
 * Repository functionality for {@link PurchaseOrderItemTax} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PurchaseOrderItemTaxService
		extends
			AbstractEntityService<PurchaseOrderItemTax>
		implements
			IPurchaseOrderItemTaxService {

	public PurchaseOrderItemTaxService() {
		super();
	}

	public PurchaseOrderItemTaxService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PurchaseOrderItemTax> getEntityClass() {
		return PurchaseOrderItemTax.class;
	}

	/**
	 * Find by reference: purchaseOrderItem
	 */
	public List<PurchaseOrderItemTax> findByPurchaseOrderItem(
			PurchaseOrderItem purchaseOrderItem) {
		return this.findByPurchaseOrderItemId(purchaseOrderItem.getId());
	}

	/**
	 * Find by ID of reference: purchaseOrderItem.id
	 */
	public List<PurchaseOrderItemTax> findByPurchaseOrderItemId(
			Long purchaseOrderItemId) {
		return (List<PurchaseOrderItemTax>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseOrderItemTax e where e.clientId = :pClientId and e.purchaseOrderItem.id = :pPurchaseOrderItemId",
						PurchaseOrderItemTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPurchaseOrderItemId", purchaseOrderItemId)
				.getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseOrderItemTax> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseOrderItemTax> findByTaxId(Long taxId) {
		return (List<PurchaseOrderItemTax>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseOrderItemTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						PurchaseOrderItemTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}
}
