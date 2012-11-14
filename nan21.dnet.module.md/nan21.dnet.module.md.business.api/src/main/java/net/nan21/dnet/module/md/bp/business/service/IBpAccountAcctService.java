/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;

/**
 * Interface to expose business functions specific for {@link BpAccountAcct} domain
 * entity.
 */
public interface IBpAccountAcctService extends IEntityService<BpAccountAcct> {

	/**
	 * Find by unique key
	 */
	public BpAccountAcct findByAccount_schema(BpAccount bpAccount,
			AccSchema accSchema);

	/**
	 * Find by unique key
	 */
	public BpAccountAcct findByAccount_schema(Long bpAccountId, Long accSchemaId);

	/**
	 * Find by reference: bpAccount
	 */
	public List<BpAccountAcct> findByBpAccount(BpAccount bpAccount);

	/**
	 * Find by ID of reference: bpAccount.id
	 */
	public List<BpAccountAcct> findByBpAccountId(Long bpAccountId);

	/**
	 * Find by reference: accSchema
	 */
	public List<BpAccountAcct> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<BpAccountAcct> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: custSalesAccount
	 */
	public List<BpAccountAcct> findByCustSalesAccount(Account custSalesAccount);

	/**
	 * Find by ID of reference: custSalesAccount.id
	 */
	public List<BpAccountAcct> findByCustSalesAccountId(Long custSalesAccountId);

	/**
	 * Find by reference: custPrepayAccount
	 */
	public List<BpAccountAcct> findByCustPrepayAccount(Account custPrepayAccount);

	/**
	 * Find by ID of reference: custPrepayAccount.id
	 */
	public List<BpAccountAcct> findByCustPrepayAccountId(
			Long custPrepayAccountId);

	/**
	 * Find by reference: vendorPurchaseAccount
	 */
	public List<BpAccountAcct> findByVendorPurchaseAccount(
			Account vendorPurchaseAccount);

	/**
	 * Find by ID of reference: vendorPurchaseAccount.id
	 */
	public List<BpAccountAcct> findByVendorPurchaseAccountId(
			Long vendorPurchaseAccountId);

	/**
	 * Find by reference: vendorPrepayAccount
	 */
	public List<BpAccountAcct> findByVendorPrepayAccount(
			Account vendorPrepayAccount);

	/**
	 * Find by ID of reference: vendorPrepayAccount.id
	 */
	public List<BpAccountAcct> findByVendorPrepayAccountId(
			Long vendorPrepayAccountId);
}
