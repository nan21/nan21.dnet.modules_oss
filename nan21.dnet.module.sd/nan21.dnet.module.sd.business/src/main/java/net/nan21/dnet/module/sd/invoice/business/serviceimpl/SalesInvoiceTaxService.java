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
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceTaxService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;

/**
 * Repository functionality for {@link SalesInvoiceTax} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SalesInvoiceTaxService
		extends
			AbstractEntityService<SalesInvoiceTax>
		implements
			ISalesInvoiceTaxService {

	public SalesInvoiceTaxService() {
		super();
	}

	public SalesInvoiceTaxService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SalesInvoiceTax> getEntityClass() {
		return SalesInvoiceTax.class;
	}

	/**
	 * Find by reference: salesInvoice
	 */
	public List<SalesInvoiceTax> findBySalesInvoice(SalesInvoice salesInvoice) {
		return this.findBySalesInvoiceId(salesInvoice.getId());
	}

	/**
	 * Find by ID of reference: salesInvoice.id
	 */
	public List<SalesInvoiceTax> findBySalesInvoiceId(Long salesInvoiceId) {
		return (List<SalesInvoiceTax>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesInvoiceTax e where e.clientId = :pClientId and e.salesInvoice.id = :pSalesInvoiceId",
						SalesInvoiceTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesInvoiceId", salesInvoiceId)
				.getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<SalesInvoiceTax> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesInvoiceTax> findByTaxId(Long taxId) {
		return (List<SalesInvoiceTax>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesInvoiceTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						SalesInvoiceTax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}
}
