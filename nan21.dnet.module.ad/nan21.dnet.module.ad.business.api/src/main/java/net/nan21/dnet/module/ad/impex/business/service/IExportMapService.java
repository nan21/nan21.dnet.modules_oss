/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;

/**
 * Interface to expose business functions specific for {@link ExportMap} domain
 * entity.
 */
public interface IExportMapService extends IEntityService<ExportMap> {

	/**
	 * Find by unique key
	 */
	public ExportMap findByName(String name);

	/**
	 * Find by reference: items
	 */
	public List<ExportMap> findByItems(ExportMapItem items);

	/**
	 * Find by ID of reference: items.id
	 */
	public List<ExportMap> findByItemsId(Long itemsId);
}
