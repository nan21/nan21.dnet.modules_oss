/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.fin.domain.entity.TxBalance;

/**
 * Interface to expose business functions specific for {@link TxBalance} domain
 * entity.
 */
public interface ITxBalanceService extends IEntityService<TxBalance> {

	/**
	 * Find by reference: bpartner
	 */
	public List<TxBalance> findByBpartner(BusinessPartner bpartner);

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<TxBalance> findByBpartnerId(Long bpartnerId);

	/**
	 * Find by reference: org
	 */
	public List<TxBalance> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<TxBalance> findByOrgId(Long orgId);

	/**
	 * Find by reference: currency
	 */
	public List<TxBalance> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<TxBalance> findByCurrencyId(Long currencyId);
}
