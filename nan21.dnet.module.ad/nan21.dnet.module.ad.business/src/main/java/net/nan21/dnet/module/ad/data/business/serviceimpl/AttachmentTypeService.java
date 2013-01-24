/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.data.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentTypeService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

/**
 * Repository functionality for {@link AttachmentType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttachmentTypeService
		extends
			AbstractEntityService<AttachmentType>
		implements
			IAttachmentTypeService {

	public AttachmentTypeService() {
		super();
	}

	public AttachmentTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AttachmentType> getEntityClass() {
		return AttachmentType.class;
	}

	/**
	 * Find by unique key
	 */
	public AttachmentType findByName(String name) {
		return (AttachmentType) this.getEntityManager()
				.createNamedQuery(AttachmentType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
