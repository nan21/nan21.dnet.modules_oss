/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.activity.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.md.activity.ds.model.MyCalendarTaskDs;

import net.nan21.dnet.core.api.session.Session;

public class MyCalendarTaskDsQueryBuilder
		extends
			QueryBuilderWithJpql<MyCalendarTaskDs, MyCalendarTaskDs, EmptyParam> {

	@Override
	public void setFilter(MyCalendarTaskDs filter) {
		filter.setCreatedBy(Session.user.get().getUsername());
		this.filter = filter;
	}
}
