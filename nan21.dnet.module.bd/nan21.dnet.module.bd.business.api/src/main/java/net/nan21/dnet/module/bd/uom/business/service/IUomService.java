/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.uom.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

/**
 * Interface to expose business functions specific for {@link Uom} domain
 * entity.
 */
public interface IUomService extends IEntityService<Uom> {

	/**
	 * Find by unique key
	 */
	public Uom findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Uom findByName(String name);

	/**
	 * Find by reference: type
	 */
	public List<Uom> findByType(UomType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Uom> findByTypeId(Long typeId);
}
