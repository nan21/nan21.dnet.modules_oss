/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tax.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxAcct;

/**
 * Interface to expose business functions specific for {@link TaxAcct} domain
 * entity.
 */
public interface ITaxAcctService extends IEntityService<TaxAcct> {

	/**
	 * Find by unique key
	 */
	public TaxAcct findByTax_schema(Tax tax, AccSchema accSchema);

	/**
	 * Find by unique key
	 */
	public TaxAcct findByTax_schema(Long taxId, Long accSchemaId);

	/**
	 * Find by reference: tax
	 */
	public List<TaxAcct> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<TaxAcct> findByTaxId(Long taxId);

	/**
	 * Find by reference: accSchema
	 */
	public List<TaxAcct> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<TaxAcct> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: salesAccount
	 */
	public List<TaxAcct> findBySalesAccount(Account salesAccount);

	/**
	 * Find by ID of reference: salesAccount.id
	 */
	public List<TaxAcct> findBySalesAccountId(Long salesAccountId);

	/**
	 * Find by reference: purchaseAccount
	 */
	public List<TaxAcct> findByPurchaseAccount(Account purchaseAccount);

	/**
	 * Find by ID of reference: purchaseAccount.id
	 */
	public List<TaxAcct> findByPurchaseAccountId(Long purchaseAccountId);

	/**
	 * Find by reference: nonDeductAccount
	 */
	public List<TaxAcct> findByNonDeductAccount(Account nonDeductAccount);

	/**
	 * Find by ID of reference: nonDeductAccount.id
	 */
	public List<TaxAcct> findByNonDeductAccountId(Long nonDeductAccountId);
}
