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
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;

/**
 * Repository functionality for {@link CsvExport} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CsvExportService extends AbstractEntityService<CsvExport>
		implements
			ICsvExportService {

	public CsvExportService() {
		super();
	}

	public CsvExportService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<CsvExport> getEntityClass() {
		return CsvExport.class;
	}

	/**
	 * Find by unique key
	 */
	public CsvExport findByName(String name) {
		return (CsvExport) this.em.createNamedQuery(CsvExport.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: fields
	 */
	public List<CsvExport> findByFields(CsvExportField fields) {
		return this.findByFieldsId(fields.getId());
	}

	/**
	 * Find by ID of reference: fields.id
	 */
	public List<CsvExport> findByFieldsId(Long fieldsId) {
		return (List<CsvExport>) this.em
				.createQuery(
						"select distinct e from CsvExport e, IN (e.fields) c where e.clientId = :pClientId and c.id = :pFieldsId",
						CsvExport.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFieldsId", fieldsId).getResultList();
	}

	/**
	 * Find by reference: sorts
	 */
	public List<CsvExport> findBySorts(CsvExportSort sorts) {
		return this.findBySortsId(sorts.getId());
	}

	/**
	 * Find by ID of reference: sorts.id
	 */
	public List<CsvExport> findBySortsId(Long sortsId) {
		return (List<CsvExport>) this.em
				.createQuery(
						"select distinct e from CsvExport e, IN (e.sorts) c where e.clientId = :pClientId and c.id = :pSortsId",
						CsvExport.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSortsId", sortsId).getResultList();
	}
}
