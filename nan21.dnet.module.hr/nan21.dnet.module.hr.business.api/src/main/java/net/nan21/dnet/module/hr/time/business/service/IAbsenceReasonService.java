/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

/**
 * Interface to expose business functions specific for {@link AbsenceReason} domain
 * entity.
 */
public interface IAbsenceReasonService extends IEntityService<AbsenceReason> {

	/**
	 * Find by unique key
	 */
	public AbsenceReason findByName(String name);

	/**
	 * Find by reference: type
	 */
	public List<AbsenceReason> findByType(AbsenceType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<AbsenceReason> findByTypeId(Long typeId);
}
