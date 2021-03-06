/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;

@Ds(entity = VendorGroup.class, sort = {@SortField(field = VendorGroupDs.f_name)})
public class VendorGroupDs extends AbstractTypeWithCodeDs<VendorGroup> {

	public VendorGroupDs() {
		super();
	}

	public VendorGroupDs(VendorGroup e) {
		super(e);
	}
}
