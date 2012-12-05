/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzJobDetailService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzJobDetail;

/**
 * Repository functionality for {@link QuartzJobDetail} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzJobDetailService
		extends
			AbstractEntityService<QuartzJobDetail>
		implements
			IQuartzJobDetailService {

	public QuartzJobDetailService() {
		super();
	}

	public QuartzJobDetailService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzJobDetail> getEntityClass() {
		return QuartzJobDetail.class;
	}
}
