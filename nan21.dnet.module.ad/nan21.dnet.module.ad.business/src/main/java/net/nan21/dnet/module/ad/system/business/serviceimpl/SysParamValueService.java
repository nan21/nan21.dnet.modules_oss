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
import net.nan21.dnet.module.ad.system.business.service.ISysParamValueService;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;
import net.nan21.dnet.module.ad.system.domain.entity.SysParamValue;

/**
 * Repository functionality for {@link SysParamValue} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysParamValueService extends AbstractEntityService<SysParamValue>
		implements
			ISysParamValueService {

	public SysParamValueService() {
		super();
	}

	public SysParamValueService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SysParamValue> getEntityClass() {
		return SysParamValue.class;
	}

	/**
	 * Find by reference: sysParam
	 */
	public List<SysParamValue> findBySysParam(SysParam sysParam) {
		return this.findBySysParamId(sysParam.getId());
	}

	/**
	 * Find by ID of reference: sysParam.id
	 */
	public List<SysParamValue> findBySysParamId(Long sysParamId) {
		return (List<SysParamValue>) this.em
				.createQuery(
						"select e from SysParamValue e where e.clientId = :pClientId and e.sysParam.id = :pSysParamId",
						SysParamValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSysParamId", sysParamId).getResultList();
	}
}
