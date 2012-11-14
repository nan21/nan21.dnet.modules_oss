/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;

/**
 * Interface to expose business functions specific for {@link PurchaseInvoiceItemTax} domain
 * entity.
 */
public interface IPurchaseInvoiceItemTaxService
		extends
			IEntityService<PurchaseInvoiceItemTax> {

	/**
	 * Find by reference: purchaseInvoiceItem
	 */
	public List<PurchaseInvoiceItemTax> findByPurchaseInvoiceItem(
			PurchaseInvoiceItem purchaseInvoiceItem);

	/**
	 * Find by ID of reference: purchaseInvoiceItem.id
	 */
	public List<PurchaseInvoiceItemTax> findByPurchaseInvoiceItemId(
			Long purchaseInvoiceItemId);

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseInvoiceItemTax> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseInvoiceItemTax> findByTaxId(Long taxId);
}
