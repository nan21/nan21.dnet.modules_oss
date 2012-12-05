/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tax.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tax.business.service.ITaxCategoryService;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxCategory;

/**
 * Repository functionality for {@link TaxCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TaxCategoryService extends AbstractEntityService<TaxCategory>
		implements
			ITaxCategoryService {

	public TaxCategoryService() {
		super();
	}

	public TaxCategoryService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<TaxCategory> getEntityClass() {
		return TaxCategory.class;
	}

	/**
	 * Find by unique key
	 */
	public TaxCategory findByName(String name) {
		return (TaxCategory) this.getEntityManager()
				.createNamedQuery(TaxCategory.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
