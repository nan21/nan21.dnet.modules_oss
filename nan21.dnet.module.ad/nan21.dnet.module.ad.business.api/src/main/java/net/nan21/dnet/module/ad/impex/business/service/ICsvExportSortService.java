/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;

/**
 * Interface to expose business functions specific for {@link CsvExportSort} domain
 * entity.
 */
public interface ICsvExportSortService extends IEntityService<CsvExportSort> {

	/**
	 * Find by reference: csvExport
	 */
	public List<CsvExportSort> findByCsvExport(CsvExport csvExport);

	/**
	 * Find by ID of reference: csvExport.id
	 */
	public List<CsvExportSort> findByCsvExportId(Long csvExportId);
}
