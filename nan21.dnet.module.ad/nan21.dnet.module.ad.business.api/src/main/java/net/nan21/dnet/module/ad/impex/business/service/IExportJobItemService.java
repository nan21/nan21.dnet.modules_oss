/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

/**
 * Interface to expose business functions specific for {@link ExportJobItem} domain
 * entity.
 */
public interface IExportJobItemService extends IEntityService<ExportJobItem> {

	/**
	 * Find by unique key
	 */
	public ExportJobItem findByJob_map(ExportJob job, ExportMap map);

	/**
	 * Find by unique key
	 */
	public ExportJobItem findByJob_map(Long jobId, Long mapId);

	/**
	 * Find by reference: job
	 */
	public List<ExportJobItem> findByJob(ExportJob job);

	/**
	 * Find by ID of reference: job.id
	 */
	public List<ExportJobItem> findByJobId(Long jobId);

	/**
	 * Find by reference: map
	 */
	public List<ExportJobItem> findByMap(ExportMap map);

	/**
	 * Find by ID of reference: map.id
	 */
	public List<ExportJobItem> findByMapId(Long mapId);
}
