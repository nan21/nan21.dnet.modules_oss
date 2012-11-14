/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;

/**
 * Interface to expose business functions specific for {@link CompanyLegalForm} domain
 * entity.
 */
public interface ICompanyLegalFormService
		extends
			IEntityService<CompanyLegalForm> {

	/**
	 * Find by unique key
	 */
	public CompanyLegalForm findByName(Country country, String name);

	/**
	 * Find by unique key
	 */
	public CompanyLegalForm findByName(Long countryId, String name);

	/**
	 * Find by reference: country
	 */
	public List<CompanyLegalForm> findByCountry(Country country);

	/**
	 * Find by ID of reference: country.id
	 */
	public List<CompanyLegalForm> findByCountryId(Long countryId);
}
