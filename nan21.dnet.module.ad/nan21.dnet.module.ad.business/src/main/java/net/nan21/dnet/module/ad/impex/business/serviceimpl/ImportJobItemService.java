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
import net.nan21.dnet.module.ad.impex.business.service.IImportJobItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;

/**
 * Repository functionality for {@link ImportJobItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ImportJobItemService extends AbstractEntityService<ImportJobItem>
		implements
			IImportJobItemService {

	public ImportJobItemService() {
		super();
	}

	public ImportJobItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ImportJobItem> getEntityClass() {
		return ImportJobItem.class;
	}

	/**
	 * Find by unique key
	 */
	public ImportJobItem findByJob_map(ImportJob job, ImportMap map) {
		return (ImportJobItem) this.getEntityManager()
				.createNamedQuery(ImportJobItem.NQ_FIND_BY_JOB_MAP)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJob", job).setParameter("pMap", map)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ImportJobItem findByJob_map(Long jobId, Long mapId) {
		return (ImportJobItem) this.getEntityManager()
				.createNamedQuery(ImportJobItem.NQ_FIND_BY_JOB_MAP_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).setParameter("pMapId", mapId)
				.getSingleResult();
	}

	/**
	 * Find by reference: job
	 */
	public List<ImportJobItem> findByJob(ImportJob job) {
		return this.findByJobId(job.getId());
	}

	/**
	 * Find by ID of reference: job.id
	 */
	public List<ImportJobItem> findByJobId(Long jobId) {
		return (List<ImportJobItem>) this
				.getEntityManager()
				.createQuery(
						"select e from ImportJobItem e where e.clientId = :pClientId and e.job.id = :pJobId",
						ImportJobItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).getResultList();
	}

	/**
	 * Find by reference: map
	 */
	public List<ImportJobItem> findByMap(ImportMap map) {
		return this.findByMapId(map.getId());
	}

	/**
	 * Find by ID of reference: map.id
	 */
	public List<ImportJobItem> findByMapId(Long mapId) {
		return (List<ImportJobItem>) this
				.getEntityManager()
				.createQuery(
						"select e from ImportJobItem e where e.clientId = :pClientId and e.map.id = :pMapId",
						ImportJobItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pMapId", mapId).getResultList();
	}
}
