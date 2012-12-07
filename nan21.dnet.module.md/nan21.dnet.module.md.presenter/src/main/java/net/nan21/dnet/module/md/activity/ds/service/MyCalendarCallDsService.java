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
import net.nan21.dnet.module.md.activity.ds.model.MyCalendarCallDs;

public class MyCalendarCallDsService
		extends
			AbstractEntityDsService<MyCalendarCallDs, MyCalendarCallDs, EmptyParam, CalendarEvent>
		implements
			IDsService<MyCalendarCallDs, MyCalendarCallDs, EmptyParam> {

	@Override
	public void preInsert(MyCalendarCallDs ds, EmptyParam params) {
		ds.setEventType("call");
	}

	@Override
	public void preUpdate(MyCalendarCallDs ds, EmptyParam params) {
		ds.setEventType("call");
	}
}
