/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.activity.ds.service;

import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEvent;
import net.nan21.dnet.module.md.activity.ds.filter.MyCalendarTaskDsFilter;
import net.nan21.dnet.module.md.activity.ds.model.MyCalendarTaskDs;


public class MyCalendarTaskDsService 
	extends AbstractEntityDsService<MyCalendarTaskDs,MyCalendarTaskDsFilter, EmptyParam, CalendarEvent> 
	implements IDsService<MyCalendarTaskDs,MyCalendarTaskDsFilter, EmptyParam> {
	
	@Override
	public void preInsert(MyCalendarTaskDs ds, EmptyParam params) {
		ds.setEventType("task");
	}
}
