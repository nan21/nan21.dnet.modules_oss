/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.acc.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

@Ds(entity = Account.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = AccountLovDs.f_code)})
public class AccountLovDs extends AbstractTypeWithCodeLov<Account> {

	public static final String f_accSchemaId = "accSchemaId";

	@DsField(join = "left", path = "accSchema.id")
	private Long accSchemaId;

	public AccountLovDs() {
		super();
	}

	public AccountLovDs(Account e) {
		super(e);
	}

	public Long getAccSchemaId() {
		return this.accSchemaId;
	}

	public void setAccSchemaId(Long accSchemaId) {
		this.accSchemaId = accSchemaId;
	}
}
