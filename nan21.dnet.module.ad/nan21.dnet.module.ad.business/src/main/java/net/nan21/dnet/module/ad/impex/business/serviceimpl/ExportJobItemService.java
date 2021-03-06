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
import net.nan21.dnet.module.ad.impex.business.service.IExportJobItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

/**
 * Repository functionality for {@link ExportJobItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ExportJobItemService extends AbstractEntityService<ExportJobItem>
		implements
			IExportJobItemService {

	public ExportJobItemService() {
		super();
	}

	public ExportJobItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ExportJobItem> getEntityClass() {
		return ExportJobItem.class;
	}

	/**
	 * Find by unique key
	 */
	public ExportJobItem findByJob_map(ExportJob job, ExportMap map) {
		return (ExportJobItem) this.getEntityManager()
				.createNamedQuery(ExportJobItem.NQ_FIND_BY_JOB_MAP)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJob", job).setParameter("pMap", map)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ExportJobItem findByJob_map(Long jobId, Long mapId) {
		return (ExportJobItem) this.getEntityManager()
				.createNamedQuery(ExportJobItem.NQ_FIND_BY_JOB_MAP_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).setParameter("pMapId", mapId)
				.getSingleResult();
	}

	/**
	 * Find by reference: job
	 */
	public List<ExportJobItem> findByJob(ExportJob job) {
		return this.findByJobId(job.getId());
	}

	/**
	 * Find by ID of reference: job.id
	 */
	public List<ExportJobItem> findByJobId(Long jobId) {
		return (List<ExportJobItem>) this
				.getEntityManager()
				.createQuery(
						"select e from ExportJobItem e where e.clientId = :pClientId and e.job.id = :pJobId",
						ExportJobItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).getResultList();
	}

	/**
	 * Find by reference: map
	 */
	public List<ExportJobItem> findByMap(ExportMap map) {
		return this.findByMapId(map.getId());
	}

	/**
	 * Find by ID of reference: map.id
	 */
	public List<ExportJobItem> findByMapId(Long mapId) {
		return (List<ExportJobItem>) this
				.getEntityManager()
				.createQuery(
						"select e from ExportJobItem e where e.clientId = :pClientId and e.map.id = :pMapId",
						ExportJobItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pMapId", mapId).getResultList();
	}
}
