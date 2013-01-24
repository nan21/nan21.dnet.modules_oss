/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.activity.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEvent;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;

/**
 * Interface to expose business functions specific for {@link CalendarEvent} domain
 * entity.
 */
public interface ICalendarEventService extends IEntityService<CalendarEvent> {

	/**
	 * Find by reference: status
	 */
	public List<CalendarEvent> findByStatus(CalendarEventStatus status);

	/**
	 * Find by ID of reference: status.id
	 */
	public List<CalendarEvent> findByStatusId(Long statusId);

	/**
	 * Find by reference: priority
	 */
	public List<CalendarEvent> findByPriority(CalendarEventPriority priority);

	/**
	 * Find by ID of reference: priority.id
	 */
	public List<CalendarEvent> findByPriorityId(Long priorityId);

	/**
	 * Find by reference: bpartner
	 */
	public List<CalendarEvent> findByBpartner(BusinessPartner bpartner);

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<CalendarEvent> findByBpartnerId(Long bpartnerId);

	/**
	 * Find by reference: contact
	 */
	public List<CalendarEvent> findByContact(Contact contact);

	/**
	 * Find by ID of reference: contact.id
	 */
	public List<CalendarEvent> findByContactId(Long contactId);
}
