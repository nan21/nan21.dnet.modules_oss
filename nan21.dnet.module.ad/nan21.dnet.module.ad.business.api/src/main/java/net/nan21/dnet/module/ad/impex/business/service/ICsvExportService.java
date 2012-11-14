/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;

/**
 * Interface to expose business functions specific for {@link CsvExport} domain
 * entity.
 */
public interface ICsvExportService extends IEntityService<CsvExport> {

	/**
	 * Find by unique key
	 */
	public CsvExport findByName(String name);

	/**
	 * Find by reference: fields
	 */
	public List<CsvExport> findByFields(CsvExportField fields);

	/**
	 * Find by ID of reference: fields.id
	 */
	public List<CsvExport> findByFieldsId(Long fieldsId);

	/**
	 * Find by reference: sorts
	 */
	public List<CsvExport> findBySorts(CsvExportSort sorts);

	/**
	 * Find by ID of reference: sorts.id
	 */
	public List<CsvExport> findBySortsId(Long sortsId);
}
