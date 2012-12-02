/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.ad.workflow.ds.model.ActAvailableTaskDs;

import net.nan21.dnet.core.api.session.Session;

public class ActAvailableTaskDsQueryBuilder
		extends
			QueryBuilderWithJpql<ActAvailableTaskDs, ActAvailableTaskDs, EmptyParam> {

	@Override
	public void setFilter(ActAvailableTaskDs filter) {
		filter.setClientId(Session.user.get().getClientId());
		this.filter = filter;
	}
}
