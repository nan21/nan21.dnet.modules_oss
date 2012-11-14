/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.attr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSetAttribute;

/**
 * Interface to expose business functions specific for {@link AttributeSetAttribute} domain
 * entity.
 */
public interface IAttributeSetAttributeService
		extends
			IEntityService<AttributeSetAttribute> {

	/**
	 * Find by unique key
	 */
	public AttributeSetAttribute findByName(AttributeSet attributeSet,
			Attribute attribute);

	/**
	 * Find by unique key
	 */
	public AttributeSetAttribute findByName(Long attributeSetId,
			Long attributeId);

	/**
	 * Find by reference: attributeSet
	 */
	public List<AttributeSetAttribute> findByAttributeSet(
			AttributeSet attributeSet);

	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<AttributeSetAttribute> findByAttributeSetId(Long attributeSetId);

	/**
	 * Find by reference: attribute
	 */
	public List<AttributeSetAttribute> findByAttribute(Attribute attribute);

	/**
	 * Find by ID of reference: attribute.id
	 */
	public List<AttributeSetAttribute> findByAttributeId(Long attributeId);
}
