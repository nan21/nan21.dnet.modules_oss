/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;

@Ds(entity = UserGroup.class, sort = {@SortField(field = UserGroupDs.f_name)})
public class UserGroupDs extends AbstractTypeDs<UserGroup> {

	public UserGroupDs() {
		super();
	}

	public UserGroupDs(UserGroup e) {
		super(e);
	}
}
