/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysPluginService;
import net.nan21.dnet.module.ad.system.domain.entity.SysPlugin;

/**
 * Repository functionality for {@link SysPlugin} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysPluginService extends AbstractEntityService<SysPlugin>
		implements
			ISysPluginService {

	public SysPluginService() {
		super();
	}

	public SysPluginService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SysPlugin> getEntityClass() {
		return SysPlugin.class;
	}

	/**
	 * Find by unique key
	 */
	public SysPlugin findByName(String name) {
		return (SysPlugin) this.getEntityManager()
				.createNamedQuery(SysPlugin.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
