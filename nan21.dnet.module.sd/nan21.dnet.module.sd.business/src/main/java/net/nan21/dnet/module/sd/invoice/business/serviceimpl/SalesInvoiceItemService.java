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
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;

/**
 * Repository functionality for {@link SalesInvoiceItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SalesInvoiceItemService
		extends
			AbstractEntityService<SalesInvoiceItem> {

	public SalesInvoiceItemService() {
		super();
	}

	public SalesInvoiceItemService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SalesInvoiceItem> getEntityClass() {
		return SalesInvoiceItem.class;
	}

	/**
	 * Find by reference: salesInvoice
	 */
	public List<SalesInvoiceItem> findBySalesInvoice(SalesInvoice salesInvoice) {
		return this.findBySalesInvoiceId(salesInvoice.getId());
	}

	/**
	 * Find by ID of reference: salesInvoice.id
	 */
	public List<SalesInvoiceItem> findBySalesInvoiceId(Long salesInvoiceId) {
		return (List<SalesInvoiceItem>) this.em
				.createQuery(
						"select e from SalesInvoiceItem e where e.clientId = :pClientId and e.salesInvoice.id = :pSalesInvoiceId",
						SalesInvoiceItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesInvoiceId", salesInvoiceId)
				.getResultList();
	}

	/**
	 * Find by reference: product
	 */
	public List<SalesInvoiceItem> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<SalesInvoiceItem> findByProductId(Long productId) {
		return (List<SalesInvoiceItem>) this.em
				.createQuery(
						"select e from SalesInvoiceItem e where e.clientId = :pClientId and e.product.id = :pProductId",
						SalesInvoiceItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}

	/**
	 * Find by reference: uom
	 */
	public List<SalesInvoiceItem> findByUom(Uom uom) {
		return this.findByUomId(uom.getId());
	}

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<SalesInvoiceItem> findByUomId(Long uomId) {
		return (List<SalesInvoiceItem>) this.em
				.createQuery(
						"select e from SalesInvoiceItem e where e.clientId = :pClientId and e.uom.id = :pUomId",
						SalesInvoiceItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pUomId", uomId).getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<SalesInvoiceItem> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesInvoiceItem> findByTaxId(Long taxId) {
		return (List<SalesInvoiceItem>) this.em
				.createQuery(
						"select e from SalesInvoiceItem e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						SalesInvoiceItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}

	/**
	 * Find by reference: itemTaxes
	 */
	public List<SalesInvoiceItem> findByItemTaxes(SalesInvoiceItemTax itemTaxes) {
		return this.findByItemTaxesId(itemTaxes.getId());
	}

	/**
	 * Find by ID of reference: itemTaxes.id
	 */
	public List<SalesInvoiceItem> findByItemTaxesId(Long itemTaxesId) {
		return (List<SalesInvoiceItem>) this.em
				.createQuery(
						"select distinct e from SalesInvoiceItem e, IN (e.itemTaxes) c where e.clientId = :pClientId and c.id = :pItemTaxesId",
						SalesInvoiceItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pItemTaxesId", itemTaxesId).getResultList();
	}
}
