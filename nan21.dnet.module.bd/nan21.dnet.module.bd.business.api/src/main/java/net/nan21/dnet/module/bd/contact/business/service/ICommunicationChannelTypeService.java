/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.contact.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

/**
 * Interface to expose business functions specific for {@link CommunicationChannelType} domain
 * entity.
 */
public interface ICommunicationChannelTypeService
		extends
			IEntityService<CommunicationChannelType> {

	/**
	 * Find by unique key
	 */
	public CommunicationChannelType findByName(String name);
}
