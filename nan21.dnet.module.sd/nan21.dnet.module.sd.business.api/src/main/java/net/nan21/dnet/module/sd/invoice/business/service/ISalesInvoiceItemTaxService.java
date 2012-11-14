/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;

/**
 * Interface to expose business functions specific for {@link SalesInvoiceItemTax} domain
 * entity.
 */
public interface ISalesInvoiceItemTaxService
		extends
			IEntityService<SalesInvoiceItemTax> {

	/**
	 * Find by reference: salesInvoiceItem
	 */
	public List<SalesInvoiceItemTax> findBySalesInvoiceItem(
			SalesInvoiceItem salesInvoiceItem);

	/**
	 * Find by ID of reference: salesInvoiceItem.id
	 */
	public List<SalesInvoiceItemTax> findBySalesInvoiceItemId(
			Long salesInvoiceItemId);

	/**
	 * Find by reference: tax
	 */
	public List<SalesInvoiceItemTax> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesInvoiceItemTax> findByTaxId(Long taxId);
}
