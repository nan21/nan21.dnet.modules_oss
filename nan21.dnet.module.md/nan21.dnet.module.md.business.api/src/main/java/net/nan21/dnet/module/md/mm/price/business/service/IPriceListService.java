/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.price.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;

/**
 * Interface to expose business functions specific for {@link PriceList} domain
 * entity.
 */
public interface IPriceListService extends IEntityService<PriceList> {

	public PriceList findDefaultPriceList(Boolean salesList)
			throws BusinessException;

	/**
	 * Find by unique key
	 */
	public PriceList findByName(String name);

	/**
	 * Find by reference: currency
	 */
	public List<PriceList> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<PriceList> findByCurrencyId(Long currencyId);
}
