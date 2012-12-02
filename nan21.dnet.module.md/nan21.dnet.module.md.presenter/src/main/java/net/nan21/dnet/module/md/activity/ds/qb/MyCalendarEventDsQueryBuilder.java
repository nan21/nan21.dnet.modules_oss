/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.activity.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.md.activity.ds.model.MyCalendarEventDs;

import net.nan21.dnet.core.api.session.Session;

public class MyCalendarEventDsQueryBuilder
		extends
			QueryBuilderWithJpql<MyCalendarEventDs, MyCalendarEventDs, EmptyParam> {

	@Override
	public void setFilter(MyCalendarEventDs filter) {
		filter.setCreatedBy(Session.user.get().getUsername());
		this.filter = filter;
	}
}
