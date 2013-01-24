/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;

/**
 * Interface to expose business functions specific for {@link CsvExportField} domain
 * entity.
 */
public interface ICsvExportFieldService extends IEntityService<CsvExportField> {

	/**
	 * Find by reference: csvExport
	 */
	public List<CsvExportField> findByCsvExport(CsvExport csvExport);

	/**
	 * Find by ID of reference: csvExport.id
	 */
	public List<CsvExportField> findByCsvExportId(Long csvExportId);
}
