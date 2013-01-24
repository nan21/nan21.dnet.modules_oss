/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.contact.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.contact.business.service.ICommunicationChannelService;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannel;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

/**
 * Repository functionality for {@link CommunicationChannel} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CommunicationChannelService
		extends
			AbstractEntityService<CommunicationChannel>
		implements
			ICommunicationChannelService {

	public CommunicationChannelService() {
		super();
	}

	public CommunicationChannelService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CommunicationChannel> getEntityClass() {
		return CommunicationChannel.class;
	}

	/**
	 * Find by reference: type
	 */
	public List<CommunicationChannel> findByType(CommunicationChannelType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<CommunicationChannel> findByTypeId(Long typeId) {
		return (List<CommunicationChannel>) this
				.getEntityManager()
				.createQuery(
						"select e from CommunicationChannel e where e.clientId = :pClientId and e.type.id = :pTypeId",
						CommunicationChannel.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}
}
