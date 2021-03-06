/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

@Ds(entity = AccessControl.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = AccessControlLovDs.f_name)})
public class AccessControlLovDs extends AbstractTypeLov<AccessControl> {

	public AccessControlLovDs() {
		super();
	}

	public AccessControlLovDs(AccessControl e) {
		super(e);
	}
}
