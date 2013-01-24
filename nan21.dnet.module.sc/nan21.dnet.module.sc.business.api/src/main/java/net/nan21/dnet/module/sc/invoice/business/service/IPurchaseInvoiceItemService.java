/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;

/**
 * Interface to expose business functions specific for {@link PurchaseInvoiceItem} domain
 * entity.
 */
public interface IPurchaseInvoiceItemService
		extends
			IEntityService<PurchaseInvoiceItem> {

	/**
	 * Find by reference: purchaseInvoice
	 */
	public List<PurchaseInvoiceItem> findByPurchaseInvoice(
			PurchaseInvoice purchaseInvoice);

	/**
	 * Find by ID of reference: purchaseInvoice.id
	 */
	public List<PurchaseInvoiceItem> findByPurchaseInvoiceId(
			Long purchaseInvoiceId);

	/**
	 * Find by reference: product
	 */
	public List<PurchaseInvoiceItem> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<PurchaseInvoiceItem> findByProductId(Long productId);

	/**
	 * Find by reference: uom
	 */
	public List<PurchaseInvoiceItem> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<PurchaseInvoiceItem> findByUomId(Long uomId);

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseInvoiceItem> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseInvoiceItem> findByTaxId(Long taxId);

	/**
	 * Find by reference: itemTaxes
	 */
	public List<PurchaseInvoiceItem> findByItemTaxes(
			PurchaseInvoiceItemTax itemTaxes);

	/**
	 * Find by ID of reference: itemTaxes.id
	 */
	public List<PurchaseInvoiceItem> findByItemTaxesId(Long itemTaxesId);
}
