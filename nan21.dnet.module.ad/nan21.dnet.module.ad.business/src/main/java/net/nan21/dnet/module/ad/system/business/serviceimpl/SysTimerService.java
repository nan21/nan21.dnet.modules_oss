/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import net.nan21.dnet.module.ad.system.domain.entity.SysTimer;

/**
 * Repository functionality for {@link SysTimer} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysTimerService extends AbstractEntityService<SysTimer> {

	public SysTimerService() {
		super();
	}

	public SysTimerService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SysTimer> getEntityClass() {
		return SysTimer.class;
	}

	/**
	 * Find by unique key
	 */
	public SysTimer findByName(SysJobCtx jobCtx, String name) {
		return (SysTimer) this.getEntityManager()
				.createNamedQuery(SysTimer.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobCtx", jobCtx).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public SysTimer findByName(Long jobCtxId, String name) {
		return (SysTimer) this.getEntityManager()
				.createNamedQuery(SysTimer.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobCtxId", jobCtxId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: jobCtx
	 */
	public List<SysTimer> findByJobCtx(SysJobCtx jobCtx) {
		return this.findByJobCtxId(jobCtx.getId());
	}

	/**
	 * Find by ID of reference: jobCtx.id
	 */
	public List<SysTimer> findByJobCtxId(Long jobCtxId) {
		return (List<SysTimer>) this
				.getEntityManager()
				.createQuery(
						"select e from SysTimer e where e.clientId = :pClientId and e.jobCtx.id = :pJobCtxId",
						SysTimer.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobCtxId", jobCtxId).getResultList();
	}
}
