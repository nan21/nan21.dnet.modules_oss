/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductManufacturerService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;

/**
 * Repository functionality for {@link ProductManufacturer} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductManufacturerService
		extends
			AbstractEntityService<ProductManufacturer>
		implements
			IProductManufacturerService {

	public ProductManufacturerService() {
		super();
	}

	public ProductManufacturerService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductManufacturer> getEntityClass() {
		return ProductManufacturer.class;
	}

	/**
	 * Find by unique key
	 */
	public ProductManufacturer findByCode(String code) {
		return (ProductManufacturer) this.getEntityManager()
				.createNamedQuery(ProductManufacturer.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ProductManufacturer findByName(String name) {
		return (ProductManufacturer) this.getEntityManager()
				.createNamedQuery(ProductManufacturer.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
