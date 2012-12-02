/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDs;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDsParam;

import net.nan21.dnet.core.api.session.Session;

public class ActProcessInstanceHistoryDsQueryBuilder
		extends
			QueryBuilderWithJpql<ActProcessInstanceHistoryDs, ActProcessInstanceHistoryDs, ActProcessInstanceHistoryDsParam> {

	@Override
	public void setFilter(ActProcessInstanceHistoryDs filter) {
		filter.setClientId(Session.user.get().getClientId());
		this.filter = filter;
	}
}
