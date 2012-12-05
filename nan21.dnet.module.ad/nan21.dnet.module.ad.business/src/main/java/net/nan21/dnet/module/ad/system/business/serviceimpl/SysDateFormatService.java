/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysDateFormatService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;

/**
 * Repository functionality for {@link SysDateFormat} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysDateFormatService extends AbstractEntityService<SysDateFormat>
		implements
			ISysDateFormatService {

	public SysDateFormatService() {
		super();
	}

	public SysDateFormatService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SysDateFormat> getEntityClass() {
		return SysDateFormat.class;
	}

	/**
	 * Find by unique key
	 */
	public SysDateFormat findByName(String name) {
		return (SysDateFormat) this.getEntityManager()
				.createNamedQuery(SysDateFormat.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
