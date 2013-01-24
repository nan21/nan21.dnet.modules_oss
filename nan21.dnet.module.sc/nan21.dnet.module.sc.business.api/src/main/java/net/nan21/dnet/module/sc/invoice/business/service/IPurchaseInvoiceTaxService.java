/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceTax;

/**
 * Interface to expose business functions specific for {@link PurchaseInvoiceTax} domain
 * entity.
 */
public interface IPurchaseInvoiceTaxService
		extends
			IEntityService<PurchaseInvoiceTax> {

	/**
	 * Find by reference: purchaseInvoice
	 */
	public List<PurchaseInvoiceTax> findByPurchaseInvoice(
			PurchaseInvoice purchaseInvoice);

	/**
	 * Find by ID of reference: purchaseInvoice.id
	 */
	public List<PurchaseInvoiceTax> findByPurchaseInvoiceId(
			Long purchaseInvoiceId);

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseInvoiceTax> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseInvoiceTax> findByTaxId(Long taxId);
}
