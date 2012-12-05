/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;

/**
 * Repository functionality for {@link BusinessPartner} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BusinessPartnerService
		extends
			AbstractEntityService<BusinessPartner> {

	public BusinessPartnerService() {
		super();
	}

	public BusinessPartnerService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BusinessPartner> getEntityClass() {
		return BusinessPartner.class;
	}

	/**
	 * Find by unique key
	 */
	public BusinessPartner findByCode(String code) {
		return (BusinessPartner) this.getEntityManager()
				.createNamedQuery(BusinessPartner.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: country
	 */
	public List<BusinessPartner> findByCountry(Country country) {
		return this.findByCountryId(country.getId());
	}

	/**
	 * Find by ID of reference: country.id
	 */
	public List<BusinessPartner> findByCountryId(Long countryId) {
		return (List<BusinessPartner>) this
				.getEntityManager()
				.createQuery(
						"select e from BusinessPartner e where e.clientId = :pClientId and e.country.id = :pCountryId",
						BusinessPartner.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCountryId", countryId).getResultList();
	}

	/**
	 * Find by reference: legalForm
	 */
	public List<BusinessPartner> findByLegalForm(CompanyLegalForm legalForm) {
		return this.findByLegalFormId(legalForm.getId());
	}

	/**
	 * Find by ID of reference: legalForm.id
	 */
	public List<BusinessPartner> findByLegalFormId(Long legalFormId) {
		return (List<BusinessPartner>) this
				.getEntityManager()
				.createQuery(
						"select e from BusinessPartner e where e.clientId = :pClientId and e.legalForm.id = :pLegalFormId",
						BusinessPartner.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLegalFormId", legalFormId).getResultList();
	}
}
