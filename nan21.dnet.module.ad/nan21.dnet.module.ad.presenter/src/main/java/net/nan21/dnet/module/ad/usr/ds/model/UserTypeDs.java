/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

@Ds(entity = UserType.class, sort = {@SortField(field = UserTypeDs.f_name)})
public class UserTypeDs extends AbstractTypeDs<UserType> {

	public static final String f_employeeAccount = "employeeAccount";
	public static final String f_bpAccount = "bpAccount";

	@DsField
	private Boolean employeeAccount;

	@DsField
	private Boolean bpAccount;

	public UserTypeDs() {
		super();
	}

	public UserTypeDs(UserType e) {
		super(e);
	}

	public Boolean getEmployeeAccount() {
		return this.employeeAccount;
	}

	public void setEmployeeAccount(Boolean employeeAccount) {
		this.employeeAccount = employeeAccount;
	}

	public Boolean getBpAccount() {
		return this.bpAccount;
	}

	public void setBpAccount(Boolean bpAccount) {
		this.bpAccount = bpAccount;
	}
}
