/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceItemTaxService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;

/**
 * Repository functionality for {@link SalesInvoiceItemTax} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SalesInvoiceItemTaxService
		extends
			AbstractEntityService<SalesInvoiceItemTax>
		implements
			ISalesInvoiceItemTaxService {

	public SalesInvoiceItemTaxService() {
		super();
	}

	public SalesInvoiceItemTaxService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SalesInvoiceItemTax> getEntityClass() {
		return SalesInvoiceItemTax.class;
	}

	/**
	 * Find by reference: salesInvoiceItem
	 */
	public List<SalesInvoiceItemTax> findBySalesInvoiceItem(
			SalesInvoiceItem salesInvoiceItem) {
		return this.findBySalesInvoiceItemId(salesInvoiceItem.getId());
	}

	/**
	 * Find by ID of reference: salesInvoiceItem.id
	 */
	public List<SalesInvoiceItemTax> findBySalesInvoiceItemId(
			Long salesInvoiceItemId) {
		return (List<SalesInvoiceItemTax>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesInvoiceItemTax e where e.clientId = :pClientId and e.salesInvoiceItem.id = :pSalesInvoiceItemId",
						SalesInvoiceItemTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesInvoiceItemId", salesInvoiceItemId)
				.getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<SalesInvoiceItemTax> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesInvoiceItemTax> findByTaxId(Long taxId) {
		return (List<SalesInvoiceItemTax>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesInvoiceItemTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						SalesInvoiceItemTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}
}
