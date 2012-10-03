/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.data.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

public interface IAttachmentService extends IEntityService<Attachment> {
	
	public List<Attachment> findByType(AttachmentType type);
	
	public List<Attachment> findByTypeId(Long typeId);
	
}
