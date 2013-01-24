/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.data.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

/**
 * Interface to expose business functions specific for {@link Attachment} domain
 * entity.
 */
public interface IAttachmentService extends IEntityService<Attachment> {

	/**
	 * Find by reference: type
	 */
	public List<Attachment> findByType(AttachmentType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Attachment> findByTypeId(Long typeId);
}
