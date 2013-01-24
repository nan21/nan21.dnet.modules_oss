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
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

/**
 * Interface to expose business functions specific for {@link VendorGroupAcct} domain
 * entity.
 */
public interface IVendorGroupAcctService
		extends
			IEntityService<VendorGroupAcct> {

	/**
	 * Find by unique key
	 */
	public VendorGroupAcct findByGroup_schema(VendorGroup vendorGroup,
			AccSchema accSchema);

	/**
	 * Find by unique key
	 */
	public VendorGroupAcct findByGroup_schema(Long vendorGroupId,
			Long accSchemaId);

	/**
	 * Find by reference: vendorGroup
	 */
	public List<VendorGroupAcct> findByVendorGroup(VendorGroup vendorGroup);

	/**
	 * Find by ID of reference: vendorGroup.id
	 */
	public List<VendorGroupAcct> findByVendorGroupId(Long vendorGroupId);

	/**
	 * Find by reference: accSchema
	 */
	public List<VendorGroupAcct> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<VendorGroupAcct> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: purchaseAccount
	 */
	public List<VendorGroupAcct> findByPurchaseAccount(Account purchaseAccount);

	/**
	 * Find by ID of reference: purchaseAccount.id
	 */
	public List<VendorGroupAcct> findByPurchaseAccountId(Long purchaseAccountId);

	/**
	 * Find by reference: prepayAccount
	 */
	public List<VendorGroupAcct> findByPrepayAccount(Account prepayAccount);

	/**
	 * Find by ID of reference: prepayAccount.id
	 */
	public List<VendorGroupAcct> findByPrepayAccountId(Long prepayAccountId);
}
