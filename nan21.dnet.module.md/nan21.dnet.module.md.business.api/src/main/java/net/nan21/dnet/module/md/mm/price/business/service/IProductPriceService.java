/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.price.business.service;

import java.util.Date;
import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceListVersion;
import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

/**
 * Interface to expose business functions specific for {@link ProductPrice} domain
 * entity.
 */
public interface IProductPriceService extends IEntityService<ProductPrice> {

	public ProductPrice getDefaultSalesProductPrice(Long productId,
			Date eventDate) throws BusinessException;

	public ProductPrice getDefaultPurchaseProductPrice(Long productId,
			Date eventDate) throws BusinessException;

	public ProductPrice getProductPrice(Long productId, Long priceListId,
			Date eventDate) throws BusinessException;

	/**
	 * Find by unique key
	 */
	public ProductPrice findByName(PriceListVersion priceListVersion,
			Product product);

	/**
	 * Find by unique key
	 */
	public ProductPrice findByName(Long priceListVersionId, Long productId);

	/**
	 * Find by reference: priceListVersion
	 */
	public List<ProductPrice> findByPriceListVersion(
			PriceListVersion priceListVersion);

	/**
	 * Find by ID of reference: priceListVersion.id
	 */
	public List<ProductPrice> findByPriceListVersionId(Long priceListVersionId);

	/**
	 * Find by reference: product
	 */
	public List<ProductPrice> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProductPrice> findByProductId(Long productId);

	/**
	 * Find by reference: uom
	 */
	public List<ProductPrice> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<ProductPrice> findByUomId(Long uomId);
}
