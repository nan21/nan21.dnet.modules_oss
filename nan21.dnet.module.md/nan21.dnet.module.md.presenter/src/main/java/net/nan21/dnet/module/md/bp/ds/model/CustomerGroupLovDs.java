/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;

@Ds(entity = CustomerGroup.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = CustomerGroupLovDs.f_code)})
public class CustomerGroupLovDs extends AbstractTypeWithCodeLov<CustomerGroup> {

	public CustomerGroupLovDs() {
		super();
	}

	public CustomerGroupLovDs(CustomerGroup e) {
		super(e);
	}
}
