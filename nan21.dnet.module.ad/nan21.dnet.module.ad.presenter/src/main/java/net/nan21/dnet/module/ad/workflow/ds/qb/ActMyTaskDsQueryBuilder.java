/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs;

import net.nan21.dnet.core.api.session.Session;

public class ActMyTaskDsQueryBuilder
		extends
			QueryBuilderWithJpql<ActMyTaskDs, ActMyTaskDs, EmptyParam> {

	@Override
	public void setFilter(ActMyTaskDs filter) {
		filter.setClientId(Session.user.get().getClientId());
		filter.setOwner(Session.user.get().getUsername());
		this.filter = filter;
	}
}
