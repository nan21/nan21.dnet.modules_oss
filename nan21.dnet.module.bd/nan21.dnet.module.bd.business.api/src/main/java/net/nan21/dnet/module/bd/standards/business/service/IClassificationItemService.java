/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.standards.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

/**
 * Interface to expose business functions specific for {@link ClassificationItem} domain
 * entity.
 */
public interface IClassificationItemService
		extends
			IEntityService<ClassificationItem> {

	/**
	 * Find by unique key
	 */
	public ClassificationItem findBySyscode(ClassificationSystem classSystem,
			String code);

	/**
	 * Find by unique key
	 */
	public ClassificationItem findBySyscode(Long classSystemId, String code);

	/**
	 * Find by unique key
	 */
	public ClassificationItem findBySysname(ClassificationSystem classSystem,
			String name);

	/**
	 * Find by unique key
	 */
	public ClassificationItem findBySysname(Long classSystemId, String name);

	/**
	 * Find by reference: classSystem
	 */
	public List<ClassificationItem> findByClassSystem(
			ClassificationSystem classSystem);

	/**
	 * Find by ID of reference: classSystem.id
	 */
	public List<ClassificationItem> findByClassSystemId(Long classSystemId);
}
