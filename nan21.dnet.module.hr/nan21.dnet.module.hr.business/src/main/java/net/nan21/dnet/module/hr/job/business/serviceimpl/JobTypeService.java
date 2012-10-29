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


public class JobTypeService extends AbstractEntityService<JobType>
		implements IJobTypeService {
 
	public JobTypeService() {
		super();
	}

	public JobTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<JobType> getEntityClass() {
		return JobType.class;
	}
	
	public JobType findByName(String name) {		 
		return (JobType) this.em
			.createNamedQuery(JobType.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
