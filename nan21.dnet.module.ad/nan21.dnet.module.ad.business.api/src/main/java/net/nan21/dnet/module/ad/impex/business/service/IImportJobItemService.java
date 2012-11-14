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
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;

/**
 * Interface to expose business functions specific for {@link ImportJobItem} domain
 * entity.
 */
public interface IImportJobItemService extends IEntityService<ImportJobItem> {

	/**
	 * Find by unique key
	 */
	public ImportJobItem findByJob_map(ImportJob job, ImportMap map);

	/**
	 * Find by unique key
	 */
	public ImportJobItem findByJob_map(Long jobId, Long mapId);

	/**
	 * Find by reference: job
	 */
	public List<ImportJobItem> findByJob(ImportJob job);

	/**
	 * Find by ID of reference: job.id
	 */
	public List<ImportJobItem> findByJobId(Long jobId);

	/**
	 * Find by reference: map
	 */
	public List<ImportJobItem> findByMap(ImportMap map);

	/**
	 * Find by ID of reference: map.id
	 */
	public List<ImportJobItem> findByMapId(Long mapId);
}
