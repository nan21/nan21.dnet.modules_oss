/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.bp.domain.entity.Bank;

@Ds(entity = Bank.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = BankLovDs.f_code)})
public class BankLovDs extends AbstractTypeWithCodeLov<Bank> {

	public BankLovDs() {
		super();
	}

	public BankLovDs(Bank e) {
		super(e);
	}
}
