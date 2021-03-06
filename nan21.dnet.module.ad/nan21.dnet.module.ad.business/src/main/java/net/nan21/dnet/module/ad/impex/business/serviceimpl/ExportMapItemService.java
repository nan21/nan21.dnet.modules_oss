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
import net.nan21.dnet.module.ad.impex.business.service.IExportMapItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;

/**
 * Repository functionality for {@link ExportMapItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ExportMapItemService extends AbstractEntityService<ExportMapItem>
		implements
			IExportMapItemService {

	public ExportMapItemService() {
		super();
	}

	public ExportMapItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ExportMapItem> getEntityClass() {
		return ExportMapItem.class;
	}

	/**
	 * Find by reference: exportMap
	 */
	public List<ExportMapItem> findByExportMap(ExportMap exportMap) {
		return this.findByExportMapId(exportMap.getId());
	}

	/**
	 * Find by ID of reference: exportMap.id
	 */
	public List<ExportMapItem> findByExportMapId(Long exportMapId) {
		return (List<ExportMapItem>) this
				.getEntityManager()
				.createQuery(
						"select e from ExportMapItem e where e.clientId = :pClientId and e.exportMap.id = :pExportMapId",
						ExportMapItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pExportMapId", exportMapId).getResultList();
	}

	/**
	 * Find by reference: csvExport
	 */
	public List<ExportMapItem> findByCsvExport(CsvExport csvExport) {
		return this.findByCsvExportId(csvExport.getId());
	}

	/**
	 * Find by ID of reference: csvExport.id
	 */
	public List<ExportMapItem> findByCsvExportId(Long csvExportId) {
		return (List<ExportMapItem>) this
				.getEntityManager()
				.createQuery(
						"select e from ExportMapItem e where e.clientId = :pClientId and e.csvExport.id = :pCsvExportId",
						ExportMapItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCsvExportId", csvExportId).getResultList();
	}
}
