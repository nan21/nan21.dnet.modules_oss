/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.attr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeCategory;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

/**
 * Interface to expose business functions specific for {@link Attribute} domain
 * entity.
 */
public interface IAttributeService extends IEntityService<Attribute> {

	/**
	 * Find by unique key
	 */
	public Attribute findByName(String name);

	/**
	 * Find by reference: category
	 */
	public List<Attribute> findByCategory(AttributeCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<Attribute> findByCategoryId(Long categoryId);

	/**
	 * Find by reference: uom
	 */
	public List<Attribute> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<Attribute> findByUomId(Long uomId);
}
