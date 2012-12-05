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
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;

/**
 * Repository functionality for {@link PurchaseInvoiceItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PurchaseInvoiceItemService
		extends
			AbstractEntityService<PurchaseInvoiceItem> {

	public PurchaseInvoiceItemService() {
		super();
	}

	public PurchaseInvoiceItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PurchaseInvoiceItem> getEntityClass() {
		return PurchaseInvoiceItem.class;
	}

	/**
	 * Find by reference: purchaseInvoice
	 */
	public List<PurchaseInvoiceItem> findByPurchaseInvoice(
			PurchaseInvoice purchaseInvoice) {
		return this.findByPurchaseInvoiceId(purchaseInvoice.getId());
	}

	/**
	 * Find by ID of reference: purchaseInvoice.id
	 */
	public List<PurchaseInvoiceItem> findByPurchaseInvoiceId(
			Long purchaseInvoiceId) {
		return (List<PurchaseInvoiceItem>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoiceItem e where e.clientId = :pClientId and e.purchaseInvoice.id = :pPurchaseInvoiceId",
						PurchaseInvoiceItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPurchaseInvoiceId", purchaseInvoiceId)
				.getResultList();
	}

	/**
	 * Find by reference: product
	 */
	public List<PurchaseInvoiceItem> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<PurchaseInvoiceItem> findByProductId(Long productId) {
		return (List<PurchaseInvoiceItem>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoiceItem e where e.clientId = :pClientId and e.product.id = :pProductId",
						PurchaseInvoiceItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}

	/**
	 * Find by reference: uom
	 */
	public List<PurchaseInvoiceItem> findByUom(Uom uom) {
		return this.findByUomId(uom.getId());
	}

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<PurchaseInvoiceItem> findByUomId(Long uomId) {
		return (List<PurchaseInvoiceItem>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoiceItem e where e.clientId = :pClientId and e.uom.id = :pUomId",
						PurchaseInvoiceItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pUomId", uomId).getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseInvoiceItem> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseInvoiceItem> findByTaxId(Long taxId) {
		return (List<PurchaseInvoiceItem>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoiceItem e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						PurchaseInvoiceItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}

	/**
	 * Find by reference: itemTaxes
	 */
	public List<PurchaseInvoiceItem> findByItemTaxes(
			PurchaseInvoiceItemTax itemTaxes) {
		return this.findByItemTaxesId(itemTaxes.getId());
	}

	/**
	 * Find by ID of reference: itemTaxes.id
	 */
	public List<PurchaseInvoiceItem> findByItemTaxesId(Long itemTaxesId) {
		return (List<PurchaseInvoiceItem>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from PurchaseInvoiceItem e, IN (e.itemTaxes) c where e.clientId = :pClientId and c.id = :pItemTaxesId",
						PurchaseInvoiceItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pItemTaxesId", itemTaxesId).getResultList();
	}
}
