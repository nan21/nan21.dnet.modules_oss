/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysFrameExtensionService;
import net.nan21.dnet.module.ad.system.domain.entity.SysFrameExtension;


public class SysFrameExtensionService extends AbstractEntityService<SysFrameExtension>
		implements ISysFrameExtensionService {
 
	public SysFrameExtensionService() {
		super();
	}

	public SysFrameExtensionService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	protected Class<SysFrameExtension> getEntityClass() {
		return SysFrameExtension.class;
	}
	
	public SysFrameExtension findByName(String frameFQN,String fileLocation) {		 
		return (SysFrameExtension) this.em
			.createNamedQuery(SysFrameExtension.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pFrameFQN", frameFQN)
			.setParameter("pFileLocation", fileLocation)
			.getSingleResult(); 
	}
}
