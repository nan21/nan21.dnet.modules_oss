/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.usr.ds.model.UserDs;
import net.nan21.dnet.module.ad.usr.ds.model.UserDsParam;

import net.nan21.dnet.core.api.session.Session;

public class UserDsQueryBuilder
		extends
			QueryBuilderWithJpql<UserDs, UserDs, UserDsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getWithRoleId() != null) {
			addFilterCondition("  e.id in ( select p.id from  User p, IN (p.roles) c where c.id = :withRoleId )  ");
			addCustomFilterItem("withRoleId", this.params.getWithRoleId());
		}
		if (this.params != null && this.params.getInGroupId() != null) {
			addFilterCondition("  e.id in ( select p.id from  User p, IN (p.groups) c where c.id = :inGroupId )  ");
			addCustomFilterItem("inGroupId", this.params.getInGroupId());
		}
	}
}
