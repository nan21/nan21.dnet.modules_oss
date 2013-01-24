/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportSortService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;

/**
 * Repository functionality for {@link CsvExportSort} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CsvExportSortService extends AbstractEntityService<CsvExportSort>
		implements
			ICsvExportSortService {

	public CsvExportSortService() {
		super();
	}

	public CsvExportSortService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CsvExportSort> getEntityClass() {
		return CsvExportSort.class;
	}

	/**
	 * Find by reference: csvExport
	 */
	public List<CsvExportSort> findByCsvExport(CsvExport csvExport) {
		return this.findByCsvExportId(csvExport.getId());
	}

	/**
	 * Find by ID of reference: csvExport.id
	 */
	public List<CsvExportSort> findByCsvExportId(Long csvExportId) {
		return (List<CsvExportSort>) this
				.getEntityManager()
				.createQuery(
						"select e from CsvExportSort e where e.clientId = :pClientId and e.csvExport.id = :pCsvExportId",
						CsvExportSort.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCsvExportId", csvExportId).getResultList();
	}
}
