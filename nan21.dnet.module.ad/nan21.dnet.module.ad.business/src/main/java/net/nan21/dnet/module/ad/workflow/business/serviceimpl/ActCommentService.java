/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActCommentService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActComment;

/**
 * Repository functionality for {@link ActComment} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActCommentService extends AbstractEntityService<ActComment>
		implements
			IActCommentService {

	public ActCommentService() {
		super();
	}

	public ActCommentService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ActComment> getEntityClass() {
		return ActComment.class;
	}
}
