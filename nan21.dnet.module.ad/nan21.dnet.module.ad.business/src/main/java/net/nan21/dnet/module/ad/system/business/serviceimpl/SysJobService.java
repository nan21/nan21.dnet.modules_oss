/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysJobService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJob;

/**
 * Repository functionality for {@link SysJob} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysJobService extends AbstractEntityService<SysJob>
		implements
			ISysJobService {

	public SysJobService() {
		super();
	}

	public SysJobService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SysJob> getEntityClass() {
		return SysJob.class;
	}

	/**
	 * Find by unique key
	 */
	public SysJob findByName(String name) {
		return (SysJob) this.getEntityManager()
				.createNamedQuery(SysJob.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public SysJob findByJclass(String javaClass) {
		return (SysJob) this.getEntityManager()
				.createNamedQuery(SysJob.NQ_FIND_BY_JCLASS)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJavaClass", javaClass).getSingleResult();
	}
}
