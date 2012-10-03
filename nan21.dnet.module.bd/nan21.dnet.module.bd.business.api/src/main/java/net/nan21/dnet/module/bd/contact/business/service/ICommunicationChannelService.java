/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.contact.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannel;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

public interface ICommunicationChannelService extends IEntityService<CommunicationChannel> {
	
	public List<CommunicationChannel> findByType(CommunicationChannelType type);
	
	public List<CommunicationChannel> findByTypeId(Long typeId);
	
}
