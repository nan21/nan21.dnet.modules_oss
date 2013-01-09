/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;

/**
 * Repository functionality for {@link SysParam} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysParamService extends AbstractEntityService<SysParam> {

	public SysParamService() {
		super();
	}

	public SysParamService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SysParam> getEntityClass() {
		return SysParam.class;
	}

	/**
	 * Find by unique key
	 */
	public SysParam findByCode(String code) {
		return (SysParam) this.getEntityManager()
				.createNamedQuery(SysParam.NQ_FIND_BY_CODE)
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public SysParam findByName(String name) {
		return (SysParam) this.getEntityManager()
				.createNamedQuery(SysParam.NQ_FIND_BY_NAME)
				.setParameter("pName", name).getSingleResult();
	}
}
