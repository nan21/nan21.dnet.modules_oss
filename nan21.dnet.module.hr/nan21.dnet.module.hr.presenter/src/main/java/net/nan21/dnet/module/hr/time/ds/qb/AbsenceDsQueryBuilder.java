/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.hr.time.ds.model.AbsenceDs;
import net.nan21.dnet.module.hr.time.ds.model.AbsenceDsParam;

import net.nan21.dnet.core.api.session.Session;

public class AbsenceDsQueryBuilder
		extends
			QueryBuilderWithJpql<AbsenceDs, AbsenceDs, AbsenceDsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getFrom() != null) {
			addFilterCondition("  e.eventDate >= :from ");
			addCustomFilterItem("from", this.params.getFrom());
		}
		if (this.params != null && this.params.getTo() != null) {
			addFilterCondition("  e.eventDate <= :to ");
			addCustomFilterItem("to", this.params.getTo());
		}
	}
}
