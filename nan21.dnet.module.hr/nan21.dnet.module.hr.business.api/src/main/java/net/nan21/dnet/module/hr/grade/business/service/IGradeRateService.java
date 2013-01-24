/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

/**
 * Interface to expose business functions specific for {@link GradeRate} domain
 * entity.
 */
public interface IGradeRateService extends IEntityService<GradeRate> {

	/**
	 * Find by unique key
	 */
	public GradeRate findByName(String name);

	/**
	 * Find by reference: currency
	 */
	public List<GradeRate> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<GradeRate> findByCurrencyId(Long currencyId);
}
