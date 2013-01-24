/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementValueDs;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementValueDsFilter;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementValueDsParam;

import net.nan21.dnet.core.api.session.Session;

public class PayrollElementValueDsQueryBuilder
		extends
			QueryBuilderWithJpql<PayrollElementValueDs, PayrollElementValueDsFilter, PayrollElementValueDsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getElementSetId() != null) {
			addFilterCondition("  e.element.id in ( select ese.element.id from  ElementSetElement ese where ese.elementSet.id = :elementSetId )  ");
			addCustomFilterItem("elementSetId", this.params.getElementSetId());
		}
	}
}
