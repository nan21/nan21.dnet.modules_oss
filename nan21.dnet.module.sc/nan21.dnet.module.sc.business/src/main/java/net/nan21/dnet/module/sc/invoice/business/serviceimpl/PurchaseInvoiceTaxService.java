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
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceTaxService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceTax;

/**
 * Repository functionality for {@link PurchaseInvoiceTax} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PurchaseInvoiceTaxService
		extends
			AbstractEntityService<PurchaseInvoiceTax>
		implements
			IPurchaseInvoiceTaxService {

	public PurchaseInvoiceTaxService() {
		super();
	}

	public PurchaseInvoiceTaxService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<PurchaseInvoiceTax> getEntityClass() {
		return PurchaseInvoiceTax.class;
	}

	/**
	 * Find by reference: purchaseInvoice
	 */
	public List<PurchaseInvoiceTax> findByPurchaseInvoice(
			PurchaseInvoice purchaseInvoice) {
		return this.findByPurchaseInvoiceId(purchaseInvoice.getId());
	}

	/**
	 * Find by ID of reference: purchaseInvoice.id
	 */
	public List<PurchaseInvoiceTax> findByPurchaseInvoiceId(
			Long purchaseInvoiceId) {
		return (List<PurchaseInvoiceTax>) this.em
				.createQuery(
						"select e from PurchaseInvoiceTax e where e.clientId = :pClientId and e.purchaseInvoice.id = :pPurchaseInvoiceId",
						PurchaseInvoiceTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPurchaseInvoiceId", purchaseInvoiceId)
				.getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseInvoiceTax> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseInvoiceTax> findByTaxId(Long taxId) {
		return (List<PurchaseInvoiceTax>) this.em
				.createQuery(
						"select e from PurchaseInvoiceTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						PurchaseInvoiceTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}
}
