/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IWorkRequirementService;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;

/**
 * Repository functionality for {@link WorkRequirement} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class WorkRequirementService
		extends
			AbstractEntityService<WorkRequirement>
		implements
			IWorkRequirementService {

	public WorkRequirementService() {
		super();
	}

	public WorkRequirementService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<WorkRequirement> getEntityClass() {
		return WorkRequirement.class;
	}

	/**
	 * Find by unique key
	 */
	public WorkRequirement findByName(String name) {
		return (WorkRequirement) this.getEntityManager()
				.createNamedQuery(WorkRequirement.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: type
	 */
	public List<WorkRequirement> findByType(WorkRequirementType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<WorkRequirement> findByTypeId(Long typeId) {
		return (List<WorkRequirement>) this
				.getEntityManager()
				.createQuery(
						"select e from WorkRequirement e where e.clientId = :pClientId and e.type.id = :pTypeId",
						WorkRequirement.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}
}
