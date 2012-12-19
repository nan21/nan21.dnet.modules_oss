/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.data.business.serviceext;

import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;

import net.nan21.dnet.module.ad.data.business.service.IAttachmentService;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;

/**
 * Business extensions specific for {@link Attachment} domain entity.
 * 
 */
public class AttachmentService extends
		net.nan21.dnet.module.ad.data.business.serviceimpl.AttachmentService
		implements IAttachmentService {

	@Override
	protected void postInsert(List<Attachment> list) throws BusinessException {

		// Map<String, Object> args = new HashMap<String, Object>();
		//
		// for (Attachment a : list) {
		// String target = a.getTargetType();
		// String uuid = a.getTargetUuid();
		//
		// if (!args.containsKey(target)) {
		// args.put(target, new ArrayList<String>());
		// }
		// ((List<String>) args.get(target)).add(uuid);
		// }
		//
		// this.fireEvent(EventData.POST_INSERT_ACTION, args);

	}
}
