/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.usr.ds.model.AccessControlDs;
import net.nan21.dnet.module.ad.usr.ds.model.AccessControlDsParam;

import net.nan21.dnet.core.api.session.Session;

public class AccessControlDsQueryBuilder
		extends
			QueryBuilderWithJpql<AccessControlDs, AccessControlDs, AccessControlDsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getWithRoleId() != null) {
			addFilterCondition("  e.id in ( select p.id from  AccessControl p, IN (p.roles) c where c.id = :withRoleId )  ");
			addCustomFilterItem("withRoleId", this.params.getWithRoleId());
		}
	}
}
