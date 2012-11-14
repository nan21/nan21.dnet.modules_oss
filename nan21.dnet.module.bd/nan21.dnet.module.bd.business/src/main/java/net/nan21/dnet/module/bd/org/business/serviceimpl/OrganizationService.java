/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.org.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Calendar;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

/**
 * Repository functionality for {@link Organization} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OrganizationService extends AbstractEntityService<Organization>
		implements
			IOrganizationService {

	public OrganizationService() {
		super();
	}

	public OrganizationService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<Organization> getEntityClass() {
		return Organization.class;
	}

	/**
	 * Find by unique key
	 */
	public Organization findByCode(String code) {
		return (Organization) this.em
				.createNamedQuery(Organization.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Organization findByName(String name) {
		return (Organization) this.em
				.createNamedQuery(Organization.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: type
	 */
	public List<Organization> findByType(OrganizationType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Organization> findByTypeId(Long typeId) {
		return (List<Organization>) this.em
				.createQuery(
						"select e from Organization e where e.clientId = :pClientId and e.type.id = :pTypeId",
						Organization.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}

	/**
	 * Find by reference: calendar
	 */
	public List<Organization> findByCalendar(Calendar calendar) {
		return this.findByCalendarId(calendar.getId());
	}

	/**
	 * Find by ID of reference: calendar.id
	 */
	public List<Organization> findByCalendarId(Long calendarId) {
		return (List<Organization>) this.em
				.createQuery(
						"select e from Organization e where e.clientId = :pClientId and e.calendar.id = :pCalendarId",
						Organization.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCalendarId", calendarId).getResultList();
	}
}
