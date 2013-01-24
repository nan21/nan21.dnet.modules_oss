/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.Qualification;

/**
 * Interface to expose business functions specific for {@link Qualification} domain
 * entity.
 */
public interface IQualificationService extends IEntityService<Qualification> {

	/**
	 * Find by unique key
	 */
	public Qualification findByName(String name);
}
