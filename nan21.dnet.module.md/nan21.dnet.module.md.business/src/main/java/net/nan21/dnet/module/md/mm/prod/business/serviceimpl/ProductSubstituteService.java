/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductSubstituteService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductSubstitute;

/**
 * Repository functionality for {@link ProductSubstitute} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductSubstituteService
		extends
			AbstractEntityService<ProductSubstitute>
		implements
			IProductSubstituteService {

	public ProductSubstituteService() {
		super();
	}

	public ProductSubstituteService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductSubstitute> getEntityClass() {
		return ProductSubstitute.class;
	}

	/**
	 * Find by reference: refProduct
	 */
	public List<ProductSubstitute> findByRefProduct(Product refProduct) {
		return this.findByRefProductId(refProduct.getId());
	}

	/**
	 * Find by ID of reference: refProduct.id
	 */
	public List<ProductSubstitute> findByRefProductId(Long refProductId) {
		return (List<ProductSubstitute>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductSubstitute e where e.clientId = :pClientId and e.refProduct.id = :pRefProductId",
						ProductSubstitute.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRefProductId", refProductId).getResultList();
	}

	/**
	 * Find by reference: equivalence
	 */
	public List<ProductSubstitute> findByEquivalence(Product equivalence) {
		return this.findByEquivalenceId(equivalence.getId());
	}

	/**
	 * Find by ID of reference: equivalence.id
	 */
	public List<ProductSubstitute> findByEquivalenceId(Long equivalenceId) {
		return (List<ProductSubstitute>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductSubstitute e where e.clientId = :pClientId and e.equivalence.id = :pEquivalenceId",
						ProductSubstitute.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEquivalenceId", equivalenceId).getResultList();
	}
}
