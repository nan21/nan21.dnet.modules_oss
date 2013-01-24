/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;

/**
 * Interface to expose business functions specific for {@link BusinessPartner} domain
 * entity.
 */
public interface IBusinessPartnerService
		extends
			IEntityService<BusinessPartner> {

	public String getPostingCustomerAcct(BusinessPartner businessPartner,
			Organization organization, AccSchema schema)
			throws BusinessException;

	public String getPostingVendorAcct(BusinessPartner businessPartner,
			Organization organization, AccSchema schema)
			throws BusinessException;

	/**
	 * Find by unique key
	 */
	public BusinessPartner findByCode(String code);

	/**
	 * Find by reference: country
	 */
	public List<BusinessPartner> findByCountry(Country country);

	/**
	 * Find by ID of reference: country.id
	 */
	public List<BusinessPartner> findByCountryId(Long countryId);

	/**
	 * Find by reference: legalForm
	 */
	public List<BusinessPartner> findByLegalForm(CompanyLegalForm legalForm);

	/**
	 * Find by ID of reference: legalForm.id
	 */
	public List<BusinessPartner> findByLegalFormId(Long legalFormId);
}
