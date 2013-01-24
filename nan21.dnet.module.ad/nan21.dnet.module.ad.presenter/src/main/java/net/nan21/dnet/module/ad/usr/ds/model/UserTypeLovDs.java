/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

@Ds(entity = UserType.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = UserTypeLovDs.f_name)})
public class UserTypeLovDs extends AbstractTypeLov<UserType> {

	public UserTypeLovDs() {
		super();
	}

	public UserTypeLovDs(UserType e) {
		super(e);
	}
}
