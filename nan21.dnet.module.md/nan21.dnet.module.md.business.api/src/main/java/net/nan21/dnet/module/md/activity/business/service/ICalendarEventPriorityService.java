/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.activity.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;

/**
 * Interface to expose business functions specific for {@link CalendarEventPriority} domain
 * entity.
 */
public interface ICalendarEventPriorityService
		extends
			IEntityService<CalendarEventPriority> {

	/**
	 * Find by unique key
	 */
	public CalendarEventPriority findByType_and_name(String eventType,
			String name);
}
