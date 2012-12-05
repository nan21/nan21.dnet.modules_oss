/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.activity.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.activity.business.service.ICalendarEventService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEvent;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;

/**
 * Repository functionality for {@link CalendarEvent} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CalendarEventService extends AbstractEntityService<CalendarEvent>
		implements
			ICalendarEventService {

	public CalendarEventService() {
		super();
	}

	public CalendarEventService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CalendarEvent> getEntityClass() {
		return CalendarEvent.class;
	}

	/**
	 * Find by reference: status
	 */
	public List<CalendarEvent> findByStatus(CalendarEventStatus status) {
		return this.findByStatusId(status.getId());
	}

	/**
	 * Find by ID of reference: status.id
	 */
	public List<CalendarEvent> findByStatusId(Long statusId) {
		return (List<CalendarEvent>) this
				.getEntityManager()
				.createQuery(
						"select e from CalendarEvent e where e.clientId = :pClientId and e.status.id = :pStatusId",
						CalendarEvent.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pStatusId", statusId).getResultList();
	}

	/**
	 * Find by reference: priority
	 */
	public List<CalendarEvent> findByPriority(CalendarEventPriority priority) {
		return this.findByPriorityId(priority.getId());
	}

	/**
	 * Find by ID of reference: priority.id
	 */
	public List<CalendarEvent> findByPriorityId(Long priorityId) {
		return (List<CalendarEvent>) this
				.getEntityManager()
				.createQuery(
						"select e from CalendarEvent e where e.clientId = :pClientId and e.priority.id = :pPriorityId",
						CalendarEvent.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPriorityId", priorityId).getResultList();
	}

	/**
	 * Find by reference: bpartner
	 */
	public List<CalendarEvent> findByBpartner(BusinessPartner bpartner) {
		return this.findByBpartnerId(bpartner.getId());
	}

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<CalendarEvent> findByBpartnerId(Long bpartnerId) {
		return (List<CalendarEvent>) this
				.getEntityManager()
				.createQuery(
						"select e from CalendarEvent e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
						CalendarEvent.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartnerId", bpartnerId).getResultList();
	}

	/**
	 * Find by reference: contact
	 */
	public List<CalendarEvent> findByContact(Contact contact) {
		return this.findByContactId(contact.getId());
	}

	/**
	 * Find by ID of reference: contact.id
	 */
	public List<CalendarEvent> findByContactId(Long contactId) {
		return (List<CalendarEvent>) this
				.getEntityManager()
				.createQuery(
						"select e from CalendarEvent e where e.clientId = :pClientId and e.contact.id = :pContactId",
						CalendarEvent.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pContactId", contactId).getResultList();
	}
}
