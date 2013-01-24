/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;

/**
 * Interface to expose business functions specific for {@link ExportJob} domain
 * entity.
 */
public interface IExportJobService extends IEntityService<ExportJob> {

	/**
	 * Find by unique key
	 */
	public ExportJob findByName(String name);

	/**
	 * Find by reference: items
	 */
	public List<ExportJob> findByItems(ExportJobItem items);

	/**
	 * Find by ID of reference: items.id
	 */
	public List<ExportJob> findByItemsId(Long itemsId);
}
