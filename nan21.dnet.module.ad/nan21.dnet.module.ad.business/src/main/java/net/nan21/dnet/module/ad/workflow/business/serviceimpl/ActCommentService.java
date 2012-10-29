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


public class ActCommentService extends AbstractEntityService<ActComment>
		implements IActCommentService {
 
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
