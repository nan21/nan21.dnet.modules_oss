/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDs;
import net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDsParam;

import net.nan21.dnet.core.api.session.Session;

public class ActTaskInstanceDsQueryBuilder
		extends
			QueryBuilderWithJpql<ActTaskInstanceDs, ActTaskInstanceDs, ActTaskInstanceDsParam> {

	@Override
	public void setFilter(ActTaskInstanceDs filter) {
		filter.setClientId(Session.user.get().getClientId());
		this.filter = filter;
	}

	@Override
	public void beforeBuildWhere() {
		if (this.params.getHideActive() != null
				&& this.params.getHideActive() == true) {
			addFilterCondition("  e.endTime is not null ");
		}
		if (this.params.getHideCompleted() != null
				&& this.params.getHideCompleted() == true) {
			addFilterCondition("  e.endTime is  null ");
		}
	}
}
