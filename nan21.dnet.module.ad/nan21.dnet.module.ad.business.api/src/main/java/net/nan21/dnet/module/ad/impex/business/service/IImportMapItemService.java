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
 * Interface to expose business functions specific for {@link ImportMapItem} domain
 * entity.
 */
public interface IImportMapItemService extends IEntityService<ImportMapItem> {

	/**
	 * Find by reference: importMap
	 */
	public List<ImportMapItem> findByImportMap(ImportMap importMap);

	/**
	 * Find by ID of reference: importMap.id
	 */
	public List<ImportMapItem> findByImportMapId(Long importMapId);
}
