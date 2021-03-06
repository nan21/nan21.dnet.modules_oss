/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeAssignmentDs;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeAssignmentDsParam;

import net.nan21.dnet.core.api.session.Session;

public class EmployeeAssignmentDsQueryBuilder
		extends
			QueryBuilderWithJpql<EmployeeAssignmentDs, EmployeeAssignmentDs, EmployeeAssignmentDsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getValidAt() != null) {
			addFilterCondition("  e.validFrom <= :validAt and ( e.validTo is null or e.validTo >= :validAt) ");
			addCustomFilterItem("validAt", this.params.getValidAt());
		}
	}
}
