/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountMethod;

/**
 * Interface to expose business functions specific for {@link FinancialAccount} domain
 * entity.
 */
public interface IFinancialAccountService
		extends
			IEntityService<FinancialAccount> {

	/**
	 * Find by unique key
	 */
	public FinancialAccount findByName(String name);

	/**
	 * Find by reference: org
	 */
	public List<FinancialAccount> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<FinancialAccount> findByOrgId(Long orgId);

	/**
	 * Find by reference: currency
	 */
	public List<FinancialAccount> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<FinancialAccount> findByCurrencyId(Long currencyId);

	/**
	 * Find by reference: journal
	 */
	public List<FinancialAccount> findByJournal(AccJournal journal);

	/**
	 * Find by ID of reference: journal.id
	 */
	public List<FinancialAccount> findByJournalId(Long journalId);

	/**
	 * Find by reference: methods
	 */
	public List<FinancialAccount> findByMethods(FinancialAccountMethod methods);

	/**
	 * Find by ID of reference: methods.id
	 */
	public List<FinancialAccount> findByMethodsId(Long methodsId);
}
