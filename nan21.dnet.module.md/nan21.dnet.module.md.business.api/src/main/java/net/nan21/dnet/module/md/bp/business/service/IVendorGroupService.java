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
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

/**
 * Interface to expose business functions specific for {@link VendorGroup} domain
 * entity.
 */
public interface IVendorGroupService extends IEntityService<VendorGroup> {

	/**
	 * Find by unique key
	 */
	public VendorGroup findByCode(String code);

	/**
	 * Find by unique key
	 */
	public VendorGroup findByName(String name);

	/**
	 * Find by reference: paymentMethod
	 */
	public List<VendorGroup> findByPaymentMethod(PaymentMethod paymentMethod);

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<VendorGroup> findByPaymentMethodId(Long paymentMethodId);

	/**
	 * Find by reference: paymentTerm
	 */
	public List<VendorGroup> findByPaymentTerm(PaymentTerm paymentTerm);

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<VendorGroup> findByPaymentTermId(Long paymentTermId);

	/**
	 * Find by reference: accounts
	 */
	public List<VendorGroup> findByAccounts(VendorGroupAcct accounts);

	/**
	 * Find by ID of reference: accounts.id
	 */
	public List<VendorGroup> findByAccountsId(Long accountsId);
}
