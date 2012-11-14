/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tax.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxCategory;

/**
 * Interface to expose business functions specific for {@link Tax} domain
 * entity.
 */
public interface ITaxService extends IEntityService<Tax> {

	/**
	 * Find by unique key
	 */
	public Tax findByName(String name);

	/**
	 * Find by reference: category
	 */
	public List<Tax> findByCategory(TaxCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<Tax> findByCategoryId(Long categoryId);

	/**
	 * Find by reference: parentTax
	 */
	public List<Tax> findByParentTax(Tax parentTax);

	/**
	 * Find by ID of reference: parentTax.id
	 */
	public List<Tax> findByParentTaxId(Long parentTaxId);

	/**
	 * Find by reference: children
	 */
	public List<Tax> findByChildren(Tax children);

	/**
	 * Find by ID of reference: children.id
	 */
	public List<Tax> findByChildrenId(Long childrenId);
}
