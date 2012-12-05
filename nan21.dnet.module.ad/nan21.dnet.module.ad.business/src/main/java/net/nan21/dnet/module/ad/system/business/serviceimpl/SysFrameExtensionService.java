/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysFrameExtensionService;
import net.nan21.dnet.module.ad.system.domain.entity.SysFrameExtension;

/**
 * Repository functionality for {@link SysFrameExtension} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysFrameExtensionService
		extends
			AbstractEntityService<SysFrameExtension>
		implements
			ISysFrameExtensionService {

	public SysFrameExtensionService() {
		super();
	}

	public SysFrameExtensionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SysFrameExtension> getEntityClass() {
		return SysFrameExtension.class;
	}

	/**
	 * Find by unique key
	 */
	public SysFrameExtension findByName(String frameFQN, String fileLocation) {
		return (SysFrameExtension) this.getEntityManager()
				.createNamedQuery(SysFrameExtension.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFrameFQN", frameFQN)
				.setParameter("pFileLocation", fileLocation).getSingleResult();
	}
}
