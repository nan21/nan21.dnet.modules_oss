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

/**
 * Interface to expose business functions specific for {@link CommunicationChannel} domain
 * entity.
 */
public interface ICommunicationChannelService
		extends
			IEntityService<CommunicationChannel> {

	/**
	 * Find by reference: type
	 */
	public List<CommunicationChannel> findByType(CommunicationChannelType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<CommunicationChannel> findByTypeId(Long typeId);
}
