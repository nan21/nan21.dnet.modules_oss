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
import net.nan21.dnet.module.md.bp.business.service.ICompanyLegalFormService;
import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;

/**
 * Repository functionality for {@link CompanyLegalForm} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CompanyLegalFormService
		extends
			AbstractEntityService<CompanyLegalForm>
		implements
			ICompanyLegalFormService {

	public CompanyLegalFormService() {
		super();
	}

	public CompanyLegalFormService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CompanyLegalForm> getEntityClass() {
		return CompanyLegalForm.class;
	}

	/**
	 * Find by unique key
	 */
	public CompanyLegalForm findByName(Country country, String name) {
		return (CompanyLegalForm) this.getEntityManager()
				.createNamedQuery(CompanyLegalForm.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCountry", country).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public CompanyLegalForm findByName(Long countryId, String name) {
		return (CompanyLegalForm) this.getEntityManager()
				.createNamedQuery(CompanyLegalForm.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCountryId", countryId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: country
	 */
	public List<CompanyLegalForm> findByCountry(Country country) {
		return this.findByCountryId(country.getId());
	}

	/**
	 * Find by ID of reference: country.id
	 */
	public List<CompanyLegalForm> findByCountryId(Long countryId) {
		return (List<CompanyLegalForm>) this
				.getEntityManager()
				.createQuery(
						"select e from CompanyLegalForm e where e.clientId = :pClientId and e.country.id = :pCountryId",
						CompanyLegalForm.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCountryId", countryId).getResultList();
	}
}
