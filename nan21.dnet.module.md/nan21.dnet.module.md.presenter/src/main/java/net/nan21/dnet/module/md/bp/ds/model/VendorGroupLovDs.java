/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;

@Ds(entity = VendorGroup.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = VendorGroupLovDs.f_code)})
public class VendorGroupLovDs extends AbstractTypeWithCodeLov<VendorGroup> {

	public VendorGroupLovDs() {
		super();
	}

	public VendorGroupLovDs(VendorGroup e) {
		super(e);
	}
}
