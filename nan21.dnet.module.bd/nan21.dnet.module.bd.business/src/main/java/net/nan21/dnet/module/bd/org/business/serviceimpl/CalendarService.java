/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.org.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.business.service.ICalendarService;
import net.nan21.dnet.module.bd.org.domain.entity.Calendar;

/**
 * Repository functionality for {@link Calendar} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CalendarService extends AbstractEntityService<Calendar>
		implements
			ICalendarService {

	public CalendarService() {
		super();
	}

	public CalendarService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Calendar> getEntityClass() {
		return Calendar.class;
	}

	/**
	 * Find by unique key
	 */
	public Calendar findByName(String name) {
		return (Calendar) this.getEntityManager()
				.createNamedQuery(Calendar.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
