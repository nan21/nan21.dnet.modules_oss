/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;

/**
 * Interface to expose business functions specific for {@link WorkRequirement} domain
 * entity.
 */
public interface IWorkRequirementService
		extends
			IEntityService<WorkRequirement> {

	/**
	 * Find by unique key
	 */
	public WorkRequirement findByName(String name);

	/**
	 * Find by reference: type
	 */
	public List<WorkRequirement> findByType(WorkRequirementType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<WorkRequirement> findByTypeId(Long typeId);
}
