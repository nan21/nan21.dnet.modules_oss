/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;

/**
 * Interface to expose business functions specific for {@link ImportMap} domain
 * entity.
 */
public interface IImportMapService extends IEntityService<ImportMap> {

	/**
	 * Find by unique key
	 */
	public ImportMap findByName(String name);

	/**
	 * Find by reference: items
	 */
	public List<ImportMap> findByItems(ImportMapItem items);

	/**
	 * Find by ID of reference: items.id
	 */
	public List<ImportMap> findByItemsId(Long itemsId);
}
