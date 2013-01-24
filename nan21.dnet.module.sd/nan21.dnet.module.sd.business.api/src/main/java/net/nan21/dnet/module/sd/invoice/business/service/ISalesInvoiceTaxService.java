/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;

/**
 * Interface to expose business functions specific for {@link SalesInvoiceTax} domain
 * entity.
 */
public interface ISalesInvoiceTaxService
		extends
			IEntityService<SalesInvoiceTax> {

	/**
	 * Find by reference: salesInvoice
	 */
	public List<SalesInvoiceTax> findBySalesInvoice(SalesInvoice salesInvoice);

	/**
	 * Find by ID of reference: salesInvoice.id
	 */
	public List<SalesInvoiceTax> findBySalesInvoiceId(Long salesInvoiceId);

	/**
	 * Find by reference: tax
	 */
	public List<SalesInvoiceTax> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesInvoiceTax> findByTaxId(Long taxId);
}
