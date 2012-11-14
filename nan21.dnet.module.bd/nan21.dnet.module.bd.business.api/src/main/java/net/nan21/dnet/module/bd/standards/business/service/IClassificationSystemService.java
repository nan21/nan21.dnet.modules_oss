/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.standards.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

/**
 * Interface to expose business functions specific for {@link ClassificationSystem} domain
 * entity.
 */
public interface IClassificationSystemService
		extends
			IEntityService<ClassificationSystem> {

	/**
	 * Find by unique key
	 */
	public ClassificationSystem findByCode(String code);

	/**
	 * Find by unique key
	 */
	public ClassificationSystem findByName(String name);
}
