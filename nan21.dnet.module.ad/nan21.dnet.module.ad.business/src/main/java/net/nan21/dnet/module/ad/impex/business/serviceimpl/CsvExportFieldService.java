/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportFieldService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;

/**
 * Repository functionality for {@link CsvExportField} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CsvExportFieldService
		extends
			AbstractEntityService<CsvExportField>
		implements
			ICsvExportFieldService {

	public CsvExportFieldService() {
		super();
	}

	public CsvExportFieldService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<CsvExportField> getEntityClass() {
		return CsvExportField.class;
	}

	/**
	 * Find by reference: csvExport
	 */
	public List<CsvExportField> findByCsvExport(CsvExport csvExport) {
		return this.findByCsvExportId(csvExport.getId());
	}

	/**
	 * Find by ID of reference: csvExport.id
	 */
	public List<CsvExportField> findByCsvExportId(Long csvExportId) {
		return (List<CsvExportField>) this.em
				.createQuery(
						"select e from CsvExportField e where e.clientId = :pClientId and e.csvExport.id = :pCsvExportId",
						CsvExportField.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCsvExportId", csvExportId).getResultList();
	}
}
