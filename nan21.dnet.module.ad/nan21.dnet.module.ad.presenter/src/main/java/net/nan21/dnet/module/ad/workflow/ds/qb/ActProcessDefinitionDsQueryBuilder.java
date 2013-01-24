/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDsParam;

import net.nan21.dnet.core.api.session.Session;

public class ActProcessDefinitionDsQueryBuilder
		extends
			QueryBuilderWithJpql<ActProcessDefinitionDs, ActProcessDefinitionDs, ActProcessDefinitionDsParam> {

	@Override
	public void setFilter(ActProcessDefinitionDs filter) {
		filter.setClientId(Session.user.get().getClientId());
		this.filter = filter;
	}
}
