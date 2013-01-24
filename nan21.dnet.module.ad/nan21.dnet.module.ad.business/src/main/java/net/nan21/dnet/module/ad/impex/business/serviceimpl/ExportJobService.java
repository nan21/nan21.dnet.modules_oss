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
import net.nan21.dnet.module.ad.impex.business.service.IExportJobService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;

/**
 * Repository functionality for {@link ExportJob} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ExportJobService extends AbstractEntityService<ExportJob>
		implements
			IExportJobService {

	public ExportJobService() {
		super();
	}

	public ExportJobService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ExportJob> getEntityClass() {
		return ExportJob.class;
	}

	/**
	 * Find by unique key
	 */
	public ExportJob findByName(String name) {
		return (ExportJob) this.getEntityManager()
				.createNamedQuery(ExportJob.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: items
	 */
	public List<ExportJob> findByItems(ExportJobItem items) {
		return this.findByItemsId(items.getId());
	}

	/**
	 * Find by ID of reference: items.id
	 */
	public List<ExportJob> findByItemsId(Long itemsId) {
		return (List<ExportJob>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from ExportJob e, IN (e.items) c where e.clientId = :pClientId and c.id = :pItemsId",
						ExportJob.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pItemsId", itemsId).getResultList();
	}
}
