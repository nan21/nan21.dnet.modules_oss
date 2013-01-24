/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;

/**
 * Interface to expose business functions specific for {@link Grade} domain
 * entity.
 */
public interface IGradeService extends IEntityService<Grade> {

	/**
	 * Find by unique key
	 */
	public Grade findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Grade findByName(String name);
}
