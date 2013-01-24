/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.activity.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;

@Ds(entity = CalendarEventStatus.class, jpqlWhere = "  e.eventType = 'task' ", sort = {@SortField(field = CalendarEventStatusTaskLovDs.f_name)})
public class CalendarEventStatusTaskLovDs
		extends
			AbstractTypeLov<CalendarEventStatus> {

	public static final String f_eventType = "eventType";

	@DsField
	private String eventType;

	public CalendarEventStatusTaskLovDs() {
		super();
	}

	public CalendarEventStatusTaskLovDs(CalendarEventStatus e) {
		super(e);
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
}
