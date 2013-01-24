/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.domain.entity.Bank;
import net.nan21.dnet.module.md.bp.domain.entity.BpBankAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

/**
 * Interface to expose business functions specific for {@link BpBankAccount} domain
 * entity.
 */
public interface IBpBankAccountService extends IEntityService<BpBankAccount> {

	/**
	 * Find by unique key
	 */
	public BpBankAccount findByAccount(BusinessPartner bpartner,
			String accountNo);

	/**
	 * Find by unique key
	 */
	public BpBankAccount findByAccount(Long bpartnerId, String accountNo);

	/**
	 * Find by reference: bpartner
	 */
	public List<BpBankAccount> findByBpartner(BusinessPartner bpartner);

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<BpBankAccount> findByBpartnerId(Long bpartnerId);

	/**
	 * Find by reference: bank
	 */
	public List<BpBankAccount> findByBank(Bank bank);

	/**
	 * Find by ID of reference: bank.id
	 */
	public List<BpBankAccount> findByBankId(Long bankId);

	/**
	 * Find by reference: currency
	 */
	public List<BpBankAccount> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<BpBankAccount> findByCurrencyId(Long currencyId);
}
