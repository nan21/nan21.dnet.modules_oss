/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductSubstitute;

/**
 * Interface to expose business functions specific for {@link ProductSubstitute} domain
 * entity.
 */
public interface IProductSubstituteService
		extends
			IEntityService<ProductSubstitute> {

	/**
	 * Find by reference: refProduct
	 */
	public List<ProductSubstitute> findByRefProduct(Product refProduct);

	/**
	 * Find by ID of reference: refProduct.id
	 */
	public List<ProductSubstitute> findByRefProductId(Long refProductId);

	/**
	 * Find by reference: equivalence
	 */
	public List<ProductSubstitute> findByEquivalence(Product equivalence);

	/**
	 * Find by ID of reference: equivalence.id
	 */
	public List<ProductSubstitute> findByEquivalenceId(Long equivalenceId);
}
