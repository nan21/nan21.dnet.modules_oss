/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.job.domain.entity.PositionRequirement;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

/**
 * Interface to expose business functions specific for {@link PositionRequirement} domain
 * entity.
 */
public interface IPositionRequirementService
		extends
			IEntityService<PositionRequirement> {

	/**
	 * Find by reference: position
	 */
	public List<PositionRequirement> findByPosition(Position position);

	/**
	 * Find by ID of reference: position.id
	 */
	public List<PositionRequirement> findByPositionId(Long positionId);

	/**
	 * Find by reference: requirement
	 */
	public List<PositionRequirement> findByRequirement(
			WorkRequirement requirement);

	/**
	 * Find by ID of reference: requirement.id
	 */
	public List<PositionRequirement> findByRequirementId(Long requirementId);
}
