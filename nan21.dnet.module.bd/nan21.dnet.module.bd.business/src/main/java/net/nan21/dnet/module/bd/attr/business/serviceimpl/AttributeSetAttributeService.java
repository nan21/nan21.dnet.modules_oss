/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.attr.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeSetAttributeService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSetAttribute;

/**
 * Repository functionality for {@link AttributeSetAttribute} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttributeSetAttributeService
		extends
			AbstractEntityService<AttributeSetAttribute>
		implements
			IAttributeSetAttributeService {

	public AttributeSetAttributeService() {
		super();
	}

	public AttributeSetAttributeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AttributeSetAttribute> getEntityClass() {
		return AttributeSetAttribute.class;
	}

	/**
	 * Find by unique key
	 */
	public AttributeSetAttribute findByName(AttributeSet attributeSet,
			Attribute attribute) {
		return (AttributeSetAttribute) this.em
				.createNamedQuery(AttributeSetAttribute.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAttributeSet", attributeSet)
				.setParameter("pAttribute", attribute).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public AttributeSetAttribute findByName(Long attributeSetId,
			Long attributeId) {
		return (AttributeSetAttribute) this.em
				.createNamedQuery(
						AttributeSetAttribute.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAttributeSetId", attributeSetId)
				.setParameter("pAttributeId", attributeId).getSingleResult();
	}

	/**
	 * Find by reference: attributeSet
	 */
	public List<AttributeSetAttribute> findByAttributeSet(
			AttributeSet attributeSet) {
		return this.findByAttributeSetId(attributeSet.getId());
	}

	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<AttributeSetAttribute> findByAttributeSetId(Long attributeSetId) {
		return (List<AttributeSetAttribute>) this.em
				.createQuery(
						"select e from AttributeSetAttribute e where e.clientId = :pClientId and e.attributeSet.id = :pAttributeSetId",
						AttributeSetAttribute.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAttributeSetId", attributeSetId)
				.getResultList();
	}

	/**
	 * Find by reference: attribute
	 */
	public List<AttributeSetAttribute> findByAttribute(Attribute attribute) {
		return this.findByAttributeId(attribute.getId());
	}

	/**
	 * Find by ID of reference: attribute.id
	 */
	public List<AttributeSetAttribute> findByAttributeId(Long attributeId) {
		return (List<AttributeSetAttribute>) this.em
				.createQuery(
						"select e from AttributeSetAttribute e where e.clientId = :pClientId and e.attribute.id = :pAttributeId",
						AttributeSetAttribute.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAttributeId", attributeId).getResultList();
	}
}
