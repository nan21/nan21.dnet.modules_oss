/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.activity.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.activity.business.service.ICalendarEventStatusService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;

/**
 * Repository functionality for {@link CalendarEventStatus} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CalendarEventStatusService
		extends
			AbstractEntityService<CalendarEventStatus>
		implements
			ICalendarEventStatusService {

	public CalendarEventStatusService() {
		super();
	}

	public CalendarEventStatusService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CalendarEventStatus> getEntityClass() {
		return CalendarEventStatus.class;
	}

	/**
	 * Find by unique key
	 */
	public CalendarEventStatus findByType_and_name(String eventType, String name) {
		return (CalendarEventStatus) this.getEntityManager()
				.createNamedQuery(CalendarEventStatus.NQ_FIND_BY_TYPE_AND_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEventType", eventType)
				.setParameter("pName", name).getSingleResult();
	}
}
