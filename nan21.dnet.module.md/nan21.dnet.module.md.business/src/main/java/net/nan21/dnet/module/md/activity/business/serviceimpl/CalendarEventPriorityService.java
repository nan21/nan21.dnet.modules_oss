/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.activity.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.activity.business.service.ICalendarEventPriorityService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;

/**
 * Repository functionality for {@link CalendarEventPriority} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CalendarEventPriorityService
		extends
			AbstractEntityService<CalendarEventPriority>
		implements
			ICalendarEventPriorityService {

	public CalendarEventPriorityService() {
		super();
	}

	public CalendarEventPriorityService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CalendarEventPriority> getEntityClass() {
		return CalendarEventPriority.class;
	}

	/**
	 * Find by unique key
	 */
	public CalendarEventPriority findByType_and_name(String eventType,
			String name) {
		return (CalendarEventPriority) this
				.getEntityManager()
				.createNamedQuery(
						CalendarEventPriority.NQ_FIND_BY_TYPE_AND_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEventType", eventType)
				.setParameter("pName", name).getSingleResult();
	}
}
