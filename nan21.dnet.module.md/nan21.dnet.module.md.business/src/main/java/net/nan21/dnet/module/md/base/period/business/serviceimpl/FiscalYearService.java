/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.period.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Calendar;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

/**
 * Repository functionality for {@link FiscalYear} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FiscalYearService extends AbstractEntityService<FiscalYear> {

	public FiscalYearService() {
		super();
	}

	public FiscalYearService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<FiscalYear> getEntityClass() {
		return FiscalYear.class;
	}

	/**
	 * Find by unique key
	 */
	public FiscalYear findByCode(String code) {
		return (FiscalYear) this.getEntityManager()
				.createNamedQuery(FiscalYear.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public FiscalYear findByName(String name) {
		return (FiscalYear) this.getEntityManager()
				.createNamedQuery(FiscalYear.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: calendar
	 */
	public List<FiscalYear> findByCalendar(Calendar calendar) {
		return this.findByCalendarId(calendar.getId());
	}

	/**
	 * Find by ID of reference: calendar.id
	 */
	public List<FiscalYear> findByCalendarId(Long calendarId) {
		return (List<FiscalYear>) this
				.getEntityManager()
				.createQuery(
						"select e from FiscalYear e where e.clientId = :pClientId and e.calendar.id = :pCalendarId",
						FiscalYear.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCalendarId", calendarId).getResultList();
	}
}
