/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

@Ds(entity = User.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = UserLovDs.f_code)})
public class UserLovDs extends AbstractTypeWithCodeLov<User> {

	public UserLovDs() {
		super();
	}

	public UserLovDs(User e) {
		super(e);
	}
}
