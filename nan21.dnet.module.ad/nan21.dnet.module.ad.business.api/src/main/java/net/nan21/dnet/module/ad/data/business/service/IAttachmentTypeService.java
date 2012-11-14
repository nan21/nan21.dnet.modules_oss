/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.data.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

/**
 * Interface to expose business functions specific for {@link AttachmentType} domain
 * entity.
 */
public interface IAttachmentTypeService extends IEntityService<AttachmentType> {

	/**
	 * Find by unique key
	 */
	public AttachmentType findByName(String name);
}
