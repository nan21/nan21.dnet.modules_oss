/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;

@Ds(entity = LicenseType.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = LicenseTypeLovDs.f_name)})
public class LicenseTypeLovDs extends AbstractTypeLov<LicenseType> {

	public LicenseTypeLovDs() {
		super();
	}

	public LicenseTypeLovDs(LicenseType e) {
		super(e);
	}
}
