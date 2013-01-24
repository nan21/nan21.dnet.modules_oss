/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.attr.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeCategory;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

/**
 * Repository functionality for {@link Attribute} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttributeService extends AbstractEntityService<Attribute>
		implements
			IAttributeService {

	public AttributeService() {
		super();
	}

	public AttributeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Attribute> getEntityClass() {
		return Attribute.class;
	}

	/**
	 * Find by unique key
	 */
	public Attribute findByName(String name) {
		return (Attribute) this.getEntityManager()
				.createNamedQuery(Attribute.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: category
	 */
	public List<Attribute> findByCategory(AttributeCategory category) {
		return this.findByCategoryId(category.getId());
	}

	/**
	 * Find by ID of reference: category.id
	 */
	public List<Attribute> findByCategoryId(Long categoryId) {
		return (List<Attribute>) this
				.getEntityManager()
				.createQuery(
						"select e from Attribute e where e.clientId = :pClientId and e.category.id = :pCategoryId",
						Attribute.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoryId", categoryId).getResultList();
	}

	/**
	 * Find by reference: uom
	 */
	public List<Attribute> findByUom(Uom uom) {
		return this.findByUomId(uom.getId());
	}

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<Attribute> findByUomId(Long uomId) {
		return (List<Attribute>) this
				.getEntityManager()
				.createQuery(
						"select e from Attribute e where e.clientId = :pClientId and e.uom.id = :pUomId",
						Attribute.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pUomId", uomId).getResultList();
	}
}
