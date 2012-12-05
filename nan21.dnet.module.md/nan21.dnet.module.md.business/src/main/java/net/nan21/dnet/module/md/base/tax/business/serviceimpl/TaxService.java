/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tax.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tax.business.service.ITaxService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxCategory;

/**
 * Repository functionality for {@link Tax} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TaxService extends AbstractEntityService<Tax>
		implements
			ITaxService {

	public TaxService() {
		super();
	}

	public TaxService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Tax> getEntityClass() {
		return Tax.class;
	}

	/**
	 * Find by unique key
	 */
	public Tax findByName(String name) {
		return (Tax) this.getEntityManager()
				.createNamedQuery(Tax.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: category
	 */
	public List<Tax> findByCategory(TaxCategory category) {
		return this.findByCategoryId(category.getId());
	}

	/**
	 * Find by ID of reference: category.id
	 */
	public List<Tax> findByCategoryId(Long categoryId) {
		return (List<Tax>) this
				.getEntityManager()
				.createQuery(
						"select e from Tax e where e.clientId = :pClientId and e.category.id = :pCategoryId",
						Tax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoryId", categoryId).getResultList();
	}

	/**
	 * Find by reference: parentTax
	 */
	public List<Tax> findByParentTax(Tax parentTax) {
		return this.findByParentTaxId(parentTax.getId());
	}

	/**
	 * Find by ID of reference: parentTax.id
	 */
	public List<Tax> findByParentTaxId(Long parentTaxId) {
		return (List<Tax>) this
				.getEntityManager()
				.createQuery(
						"select e from Tax e where e.clientId = :pClientId and e.parentTax.id = :pParentTaxId",
						Tax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pParentTaxId", parentTaxId).getResultList();
	}

	/**
	 * Find by reference: children
	 */
	public List<Tax> findByChildren(Tax children) {
		return this.findByChildrenId(children.getId());
	}

	/**
	 * Find by ID of reference: children.id
	 */
	public List<Tax> findByChildrenId(Long childrenId) {
		return (List<Tax>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Tax e, IN (e.children) c where e.clientId = :pClientId and c.id = :pChildrenId",
						Tax.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pChildrenId", childrenId).getResultList();
	}
}
