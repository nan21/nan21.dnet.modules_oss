/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tax.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxCategory;

/**
 * Interface to expose business functions specific for {@link TaxCategory} domain
 * entity.
 */
public interface ITaxCategoryService extends IEntityService<TaxCategory> {

	/**
	 * Find by unique key
	 */
	public TaxCategory findByName(String name);
}
