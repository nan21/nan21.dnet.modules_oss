/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IJobTypeService;
import net.nan21.dnet.module.hr.job.domain.entity.JobType;

/**
 * Repository functionality for {@link JobType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobTypeService extends AbstractEntityService<JobType>
		implements
			IJobTypeService {

	public JobTypeService() {
		super();
	}

	public JobTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<JobType> getEntityClass() {
		return JobType.class;
	}

	/**
	 * Find by unique key
	 */
	public JobType findByName(String name) {
		return (JobType) this.getEntityManager()
				.createNamedQuery(JobType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
