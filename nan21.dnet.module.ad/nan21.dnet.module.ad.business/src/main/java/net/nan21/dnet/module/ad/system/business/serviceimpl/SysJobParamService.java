/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysJobParamService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJob;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;

/**
 * Repository functionality for {@link SysJobParam} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysJobParamService extends AbstractEntityService<SysJobParam>
		implements
			ISysJobParamService {

	public SysJobParamService() {
		super();
	}

	public SysJobParamService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SysJobParam> getEntityClass() {
		return SysJobParam.class;
	}

	/**
	 * Find by unique key
	 */
	public SysJobParam findByName(SysJob job, String name) {
		return (SysJobParam) this.em
				.createNamedQuery(SysJobParam.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJob", job).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public SysJobParam findByName(Long jobId, String name) {
		return (SysJobParam) this.em
				.createNamedQuery(SysJobParam.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by reference: job
	 */
	public List<SysJobParam> findByJob(SysJob job) {
		return this.findByJobId(job.getId());
	}

	/**
	 * Find by ID of reference: job.id
	 */
	public List<SysJobParam> findByJobId(Long jobId) {
		return (List<SysJobParam>) this.em
				.createQuery(
						"select e from SysJobParam e where e.clientId = :pClientId and e.job.id = :pJobId",
						SysJobParam.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).getResultList();
	}
}
