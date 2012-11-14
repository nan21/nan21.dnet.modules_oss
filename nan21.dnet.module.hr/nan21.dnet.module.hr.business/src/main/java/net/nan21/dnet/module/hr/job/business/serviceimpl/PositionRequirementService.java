/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IPositionRequirementService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.job.domain.entity.PositionRequirement;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

/**
 * Repository functionality for {@link PositionRequirement} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PositionRequirementService
		extends
			AbstractEntityService<PositionRequirement>
		implements
			IPositionRequirementService {

	public PositionRequirementService() {
		super();
	}

	public PositionRequirementService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<PositionRequirement> getEntityClass() {
		return PositionRequirement.class;
	}

	/**
	 * Find by reference: position
	 */
	public List<PositionRequirement> findByPosition(Position position) {
		return this.findByPositionId(position.getId());
	}

	/**
	 * Find by ID of reference: position.id
	 */
	public List<PositionRequirement> findByPositionId(Long positionId) {
		return (List<PositionRequirement>) this.em
				.createQuery(
						"select e from PositionRequirement e where e.clientId = :pClientId and e.position.id = :pPositionId",
						PositionRequirement.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPositionId", positionId).getResultList();
	}

	/**
	 * Find by reference: requirement
	 */
	public List<PositionRequirement> findByRequirement(
			WorkRequirement requirement) {
		return this.findByRequirementId(requirement.getId());
	}

	/**
	 * Find by ID of reference: requirement.id
	 */
	public List<PositionRequirement> findByRequirementId(Long requirementId) {
		return (List<PositionRequirement>) this.em
				.createQuery(
						"select e from PositionRequirement e where e.clientId = :pClientId and e.requirement.id = :pRequirementId",
						PositionRequirement.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRequirementId", requirementId).getResultList();
	}
}
