/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

/**
 * Interface to expose business functions specific for {@link Assignable} domain
 * entity.
 */
public interface IAssignableService extends IEntityService<Assignable> {

	/**
	 * Find by unique key
	 */
	public Assignable findByName(String name);

	/**
	 * Find by reference: assignableType
	 */
	public List<Assignable> findByAssignableType(AssignableType assignableType);

	/**
	 * Find by ID of reference: assignableType.id
	 */
	public List<Assignable> findByAssignableTypeId(Long assignableTypeId);
}
