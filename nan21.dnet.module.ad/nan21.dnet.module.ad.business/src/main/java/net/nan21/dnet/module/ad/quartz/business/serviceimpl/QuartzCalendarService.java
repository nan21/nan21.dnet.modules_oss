/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzCalendarService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzCalendar;

/**
 * Repository functionality for {@link QuartzCalendar} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzCalendarService
		extends
			AbstractEntityService<QuartzCalendar>
		implements
			IQuartzCalendarService {

	public QuartzCalendarService() {
		super();
	}

	public QuartzCalendarService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzCalendar> getEntityClass() {
		return QuartzCalendar.class;
	}
}
