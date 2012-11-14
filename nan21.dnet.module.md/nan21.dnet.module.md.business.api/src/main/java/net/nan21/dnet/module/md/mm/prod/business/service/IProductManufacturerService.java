/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;

/**
 * Interface to expose business functions specific for {@link ProductManufacturer} domain
 * entity.
 */
public interface IProductManufacturerService
		extends
			IEntityService<ProductManufacturer> {

	/**
	 * Find by unique key
	 */
	public ProductManufacturer findByCode(String code);

	/**
	 * Find by unique key
	 */
	public ProductManufacturer findByName(String name);
}
