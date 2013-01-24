/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;

/**
 * Interface to expose business functions specific for {@link CustomerGroup} domain
 * entity.
 */
public interface ICustomerGroupService extends IEntityService<CustomerGroup> {

	/**
	 * Find by unique key
	 */
	public CustomerGroup findByCode(String code);

	/**
	 * Find by unique key
	 */
	public CustomerGroup findByName(String name);

	/**
	 * Find by reference: paymentMethod
	 */
	public List<CustomerGroup> findByPaymentMethod(PaymentMethod paymentMethod);

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<CustomerGroup> findByPaymentMethodId(Long paymentMethodId);

	/**
	 * Find by reference: paymentTerm
	 */
	public List<CustomerGroup> findByPaymentTerm(PaymentTerm paymentTerm);

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<CustomerGroup> findByPaymentTermId(Long paymentTermId);

	/**
	 * Find by reference: accounts
	 */
	public List<CustomerGroup> findByAccounts(CustomerGroupAcct accounts);

	/**
	 * Find by ID of reference: accounts.id
	 */
	public List<CustomerGroup> findByAccountsId(Long accountsId);
}
