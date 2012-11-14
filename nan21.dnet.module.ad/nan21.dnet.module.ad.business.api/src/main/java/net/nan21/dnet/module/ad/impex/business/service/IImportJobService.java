/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;

/**
 * Interface to expose business functions specific for {@link ImportJob} domain
 * entity.
 */
public interface IImportJobService extends IEntityService<ImportJob> {

	/**
	 * Find by unique key
	 */
	public ImportJob findByName(String name);

	/**
	 * Find by reference: items
	 */
	public List<ImportJob> findByItems(ImportJobItem items);

	/**
	 * Find by ID of reference: items.id
	 */
	public List<ImportJob> findByItemsId(Long itemsId);
}
