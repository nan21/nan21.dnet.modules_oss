/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
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


public class CommunicationChannelService extends AbstractEntityService<CommunicationChannel>
		implements ICommunicationChannelService {
 
	public CommunicationChannelService() {
		super();
	}

	public CommunicationChannelService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<CommunicationChannel> getEntityClass() {
		return CommunicationChannel.class;
	}
	
	public List<CommunicationChannel> findByType(CommunicationChannelType type) {
		return this.findByTypeId(type.getId()); 
	}
	
	public List<CommunicationChannel> findByTypeId(Long typeId) {
		return (List<CommunicationChannel>) this.em
			.createQuery("select e from CommunicationChannel e where e.clientId = :pClientId and e.type.id = :pTypeId", CommunicationChannel.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pTypeId", typeId)			 	
			.getResultList(); 
	}
}
