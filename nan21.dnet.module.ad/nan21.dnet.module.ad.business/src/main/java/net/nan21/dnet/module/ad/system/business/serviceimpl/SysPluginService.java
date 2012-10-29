/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysPluginService;
import net.nan21.dnet.module.ad.system.domain.entity.SysPlugin;


public class SysPluginService extends AbstractEntityService<SysPlugin>
		implements ISysPluginService {
 
	public SysPluginService() {
		super();
	}

	public SysPluginService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SysPlugin> getEntityClass() {
		return SysPlugin.class;
	}
	
	public SysPlugin findByName(String name) {		 
		return (SysPlugin) this.em
			.createNamedQuery(SysPlugin.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
