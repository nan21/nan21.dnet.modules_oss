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
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceItemTaxService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;

/**
 * Repository functionality for {@link PurchaseInvoiceItemTax} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PurchaseInvoiceItemTaxService
		extends
			AbstractEntityService<PurchaseInvoiceItemTax>
		implements
			IPurchaseInvoiceItemTaxService {

	public PurchaseInvoiceItemTaxService() {
		super();
	}

	public PurchaseInvoiceItemTaxService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PurchaseInvoiceItemTax> getEntityClass() {
		return PurchaseInvoiceItemTax.class;
	}

	/**
	 * Find by reference: purchaseInvoiceItem
	 */
	public List<PurchaseInvoiceItemTax> findByPurchaseInvoiceItem(
			PurchaseInvoiceItem purchaseInvoiceItem) {
		return this.findByPurchaseInvoiceItemId(purchaseInvoiceItem.getId());
	}

	/**
	 * Find by ID of reference: purchaseInvoiceItem.id
	 */
	public List<PurchaseInvoiceItemTax> findByPurchaseInvoiceItemId(
			Long purchaseInvoiceItemId) {
		return (List<PurchaseInvoiceItemTax>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoiceItemTax e where e.clientId = :pClientId and e.purchaseInvoiceItem.id = :pPurchaseInvoiceItemId",
						PurchaseInvoiceItemTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPurchaseInvoiceItemId", purchaseInvoiceItemId)
				.getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseInvoiceItemTax> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseInvoiceItemTax> findByTaxId(Long taxId) {
		return (List<PurchaseInvoiceItemTax>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoiceItemTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						PurchaseInvoiceItemTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}
}
