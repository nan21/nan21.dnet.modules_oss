/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.price.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceListVersion;

/**
 * Interface to expose business functions specific for {@link PriceListVersion} domain
 * entity.
 */
public interface IPriceListVersionService
		extends
			IEntityService<PriceListVersion> {

	/**
	 * Find by unique key
	 */
	public PriceListVersion findByName(String name);

	/**
	 * Find by reference: priceList
	 */
	public List<PriceListVersion> findByPriceList(PriceList priceList);

	/**
	 * Find by ID of reference: priceList.id
	 */
	public List<PriceListVersion> findByPriceListId(Long priceListId);
}
