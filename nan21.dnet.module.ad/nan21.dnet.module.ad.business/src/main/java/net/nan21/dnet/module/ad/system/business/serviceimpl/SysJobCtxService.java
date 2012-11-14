/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;

/**
 * Repository functionality for {@link SysJobCtx} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysJobCtxService extends AbstractEntityService<SysJobCtx> {

	public SysJobCtxService() {
		super();
	}

	public SysJobCtxService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SysJobCtx> getEntityClass() {
		return SysJobCtx.class;
	}

	/**
	 * Find by unique key
	 */
	public SysJobCtx findByName(String name) {
		return (SysJobCtx) this.em.createNamedQuery(SysJobCtx.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
