/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;

/**
 * Interface to expose business functions specific for {@link SalesInvoiceItem} domain
 * entity.
 */
public interface ISalesInvoiceItemService
		extends
			IEntityService<SalesInvoiceItem> {

	/**
	 * Find by reference: salesInvoice
	 */
	public List<SalesInvoiceItem> findBySalesInvoice(SalesInvoice salesInvoice);

	/**
	 * Find by ID of reference: salesInvoice.id
	 */
	public List<SalesInvoiceItem> findBySalesInvoiceId(Long salesInvoiceId);

	/**
	 * Find by reference: product
	 */
	public List<SalesInvoiceItem> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<SalesInvoiceItem> findByProductId(Long productId);

	/**
	 * Find by reference: uom
	 */
	public List<SalesInvoiceItem> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<SalesInvoiceItem> findByUomId(Long uomId);

	/**
	 * Find by reference: tax
	 */
	public List<SalesInvoiceItem> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesInvoiceItem> findByTaxId(Long taxId);

	/**
	 * Find by reference: itemTaxes
	 */
	public List<SalesInvoiceItem> findByItemTaxes(SalesInvoiceItemTax itemTaxes);

	/**
	 * Find by ID of reference: itemTaxes.id
	 */
	public List<SalesInvoiceItem> findByItemTaxesId(Long itemTaxesId);
}
