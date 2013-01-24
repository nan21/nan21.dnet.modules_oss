/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;

/**
 * Interface to expose business functions specific for {@link CustomerGroupAcct} domain
 * entity.
 */
public interface ICustomerGroupAcctService
		extends
			IEntityService<CustomerGroupAcct> {

	/**
	 * Find by unique key
	 */
	public CustomerGroupAcct findByGroup_schema(CustomerGroup custGroup,
			AccSchema accSchema);

	/**
	 * Find by unique key
	 */
	public CustomerGroupAcct findByGroup_schema(Long custGroupId,
			Long accSchemaId);

	/**
	 * Find by reference: custGroup
	 */
	public List<CustomerGroupAcct> findByCustGroup(CustomerGroup custGroup);

	/**
	 * Find by ID of reference: custGroup.id
	 */
	public List<CustomerGroupAcct> findByCustGroupId(Long custGroupId);

	/**
	 * Find by reference: accSchema
	 */
	public List<CustomerGroupAcct> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<CustomerGroupAcct> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: salesAccount
	 */
	public List<CustomerGroupAcct> findBySalesAccount(Account salesAccount);

	/**
	 * Find by ID of reference: salesAccount.id
	 */
	public List<CustomerGroupAcct> findBySalesAccountId(Long salesAccountId);

	/**
	 * Find by reference: prepayAccount
	 */
	public List<CustomerGroupAcct> findByPrepayAccount(Account prepayAccount);

	/**
	 * Find by ID of reference: prepayAccount.id
	 */
	public List<CustomerGroupAcct> findByPrepayAccountId(Long prepayAccountId);
}
