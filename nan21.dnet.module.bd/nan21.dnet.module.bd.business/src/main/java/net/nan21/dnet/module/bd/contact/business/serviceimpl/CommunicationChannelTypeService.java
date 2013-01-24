/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.contact.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.contact.business.service.ICommunicationChannelTypeService;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

/**
 * Repository functionality for {@link CommunicationChannelType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CommunicationChannelTypeService
		extends
			AbstractEntityService<CommunicationChannelType>
		implements
			ICommunicationChannelTypeService {

	public CommunicationChannelTypeService() {
		super();
	}

	public CommunicationChannelTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CommunicationChannelType> getEntityClass() {
		return CommunicationChannelType.class;
	}

	/**
	 * Find by unique key
	 */
	public CommunicationChannelType findByName(String name) {
		return (CommunicationChannelType) this.getEntityManager()
				.createNamedQuery(CommunicationChannelType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
