/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.activity.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;

/**
 * Interface to expose business functions specific for {@link CalendarEventStatus} domain
 * entity.
 */
public interface ICalendarEventStatusService
		extends
			IEntityService<CalendarEventStatus> {

	/**
	 * Find by unique key
	 */
	public CalendarEventStatus findByType_and_name(String eventType, String name);
}
