/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;

/**
 * Interface to expose business functions specific for {@link ExportMapItem} domain
 * entity.
 */
public interface IExportMapItemService extends IEntityService<ExportMapItem> {

	/**
	 * Find by reference: exportMap
	 */
	public List<ExportMapItem> findByExportMap(ExportMap exportMap);

	/**
	 * Find by ID of reference: exportMap.id
	 */
	public List<ExportMapItem> findByExportMapId(Long exportMapId);

	/**
	 * Find by reference: csvExport
	 */
	public List<ExportMapItem> findByCsvExport(CsvExport csvExport);

	/**
	 * Find by ID of reference: csvExport.id
	 */
	public List<ExportMapItem> findByCsvExportId(Long csvExportId);
}
